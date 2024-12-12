package com.example.weatherapp;

import android.content.Intent;
import android.os.Bundle;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Arrays;
import java.util.List;

public class ListActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        // Encontrar la ListView en el diseño
        ListView listView = findViewById(R.id.city_list_view);

        // Lista de ciudades
        List<String> cities = Arrays.asList("Buenos Aires", "Córdoba", "Rosario", "Mendoza", "Salta");

        // Configurar el adaptador personalizado
        MyAdapter adapter = new MyAdapter(this, cities);
        listView.setAdapter(adapter);

        // Configurar clic en los elementos de la lista
        listView.setOnItemClickListener((AdapterView<?> parent, android.view.View view, int position, long id) -> {
            // Obtiene el nombre de la ciudad seleccionada
            String selectedCity = cities.get(position);

            // Crear un intent para abrir DetailActivity
            Intent intent = new Intent(ListActivity.this, DetailActivity.class);
            intent.putExtra("city_name", selectedCity);
            startActivity(intent);
        });
    }
}
