package com.example.weatherapp;

import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.squareup.picasso.Picasso;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DetailActivity extends AppCompatActivity {

    private TextView cityNameTextView, currentTempTextView, minTempTextView, maxTempTextView, weatherDescriptionTextView;
    private ImageView weatherIconImageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        // Vincula las vistas
        cityNameTextView = findViewById(R.id.city_name);
        currentTempTextView = findViewById(R.id.current_temp);
        minTempTextView = findViewById(R.id.min_temp);
        maxTempTextView = findViewById(R.id.max_temp);
        weatherDescriptionTextView = findViewById(R.id.weather_description);
        weatherIconImageView = findViewById(R.id.weather_icon);

        // Obtiene el nombre de la ciudad desde el intent
        String cityName = getIntent().getStringExtra("city_name");

        if (cityName != null && !cityName.isEmpty()) {
            cityNameTextView.setText(cityName);
            // Llama a la API para obtener los detalles del clima
            getWeatherDetails(cityName);
        } else {
            Toast.makeText(this, "Nombre de ciudad no proporcionado", Toast.LENGTH_SHORT).show();
            Log.e("DetailActivity", "El intent no proporcionó un nombre de ciudad.");
            showDefaultData("Sin nombre de ciudad");
        }
    }

    private void getWeatherDetails(String cityName) {
        // Obtiene la instancia del servicio de Retrofit
        WeatherService weatherService = RetrofitClient.getInstance().create(WeatherService.class);

        // Realiza la llamada a la API
        Call<WeatherResponse> call = weatherService.getCurrentWeather(cityName, BuildConfig.API_KEY, "metric");
        call.enqueue(new Callback<WeatherResponse>() {
            @Override
            public void onResponse(Call<WeatherResponse> call, Response<WeatherResponse> response) {
                if (response.isSuccessful() && response.body() != null) {
                    WeatherResponse weather = response.body();

                    // Valida si los datos devueltos son correctos antes de acceder a ellos
                    if (weather.getMain() != null && weather.getWeather() != null && !weather.getWeather().isEmpty()) {
                        String description = weather.getWeather().get(0).getDescription();
                        float temp = weather.getMain().getTemp();
                        float tempMin = weather.getMain().getTempMin();
                        float tempMax = weather.getMain().getTempMax();
                        String icon = weather.getWeather().get(0).getIcon();

                        // Actualiza los TextViews con los datos obtenidos
                        currentTempTextView.setText("Temperatura: " + temp + "°C");
                        minTempTextView.setText("Temperatura mínima: " + tempMin + "°C");
                        maxTempTextView.setText("Temperatura máxima: " + tempMax + "°C");
                        weatherDescriptionTextView.setText("Clima: " + description);

                        // Muestra el ícono del clima
                        String iconUrl = "https://openweathermap.org/img/wn/" + icon + "@2x.png";
                        weatherIconImageView.setVisibility(android.view.View.VISIBLE);
                        Picasso.get().load(iconUrl).into(weatherIconImageView);
                    } else {
                        Log.e("DetailActivity", "Datos incompletos o mal formateados en la respuesta de la API.");
                        showDefaultData("Datos incompletos");
                    }
                } else {
                    Log.e("DetailActivity", "Error en la respuesta: " + response.message());
                    showDefaultData("Error en la respuesta");
                }
            }

            @Override
            public void onFailure(Call<WeatherResponse> call, Throwable t) {
                Log.e("DetailActivity", "Error en la red: " + t.getMessage());
                showDefaultData("Error de red");
            }
        });
    }

    private void showDefaultData(String errorMessage) {
        currentTempTextView.setText("Temperatura: No disponible");
        minTempTextView.setText("Temperatura mínima: No disponible");
        maxTempTextView.setText("Temperatura máxima: No disponible");
        weatherDescriptionTextView.setText("Clima: " + errorMessage);
        weatherIconImageView.setVisibility(android.view.View.GONE);
        Toast.makeText(this, errorMessage, Toast.LENGTH_SHORT).show();
    }
}
