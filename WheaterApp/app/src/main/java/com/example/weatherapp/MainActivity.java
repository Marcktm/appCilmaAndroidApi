package com.example.weatherapp;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;


import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Habilitar EdgeToEdge para manejar barras del sistema
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        // Ajustar el padding del layout principal para las barras del sistema
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Configurar el botón "Listado de ciudades" para abrir ListActivity
        findViewById(R.id.city_list_button).setOnClickListener(view -> {
            // Crear un intent para iniciar ListActivity
            Intent intent = new Intent(MainActivity.this, ListActivity.class);
            startActivity(intent);
        });

        Button currentForecastButton = findViewById(R.id.current_forecast_button);
        currentForecastButton.setOnClickListener(view -> {
            Intent intent = new Intent(MainActivity.this, DetailActivity.class);
            intent.putExtra("city_name", "Buenos Aires"); // Puedes cambiar el nombre por otro valor de prueba
            startActivity(intent);
        });

    }
}
