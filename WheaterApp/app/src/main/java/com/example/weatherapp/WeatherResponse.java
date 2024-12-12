package com.example.weatherapp;

import com.google.gson.annotations.SerializedName;
import java.util.List;

public class WeatherResponse {
    @SerializedName("weather")
    private List<Weather> weather; // Lista de condiciones climáticas

    @SerializedName("main")
    private Main main; // Información principal del clima

    @SerializedName("name")
    private String name; // Nombre de la ciudad

    // Getters y Setters
    public List<Weather> getWeather() {
        return weather;
    }

    public void setWeather(List<Weather> weather) {
        this.weather = weather;
    }

    public Main getMain() {
        return main;
    }

    public void setMain(Main main) {
        this.main = main;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    // Clase interna para la lista "weather"
    public static class Weather {
        @SerializedName("description")
        private String description; // Descripción del clima, ejemplo: "clear sky"

        @SerializedName("icon")
        private String icon; // Código del ícono del clima

        // Getters y Setters
        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public String getIcon() {
            return icon;
        }

        public void setIcon(String icon) {
            this.icon = icon;
        }
    }

    // Clase interna para la sección "main"
    public static class Main {
        @SerializedName("temp")
        private float temp; // Temperatura actual

        @SerializedName("temp_min")
        private float tempMin; // Temperatura mínima

        @SerializedName("temp_max")
        private float tempMax; // Temperatura máxima

        // Getters y Setters
        public float getTemp() {
            return temp;
        }

        public void setTemp(float temp) {
            this.temp = temp;
        }

        public float getTempMin() {
            return tempMin;
        }

        public void setTempMin(float tempMin) {
            this.tempMin = tempMin;
        }

        public float getTempMax() {
            return tempMax;
        }

        public void setTempMax(float tempMax) {
            this.tempMax = tempMax;
        }
    }
}
