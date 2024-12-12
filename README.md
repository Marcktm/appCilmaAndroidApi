# Weather App

Una aplicación móvil desarrollada en **Java** utilizando **Android Studio** como IDE. La app muestra información climática en tiempo real de diversas ciudades, obteniendo los datos desde la API de OpenWeatherMap.

---

## **Características del Proyecto**

### **1. Pantalla Principal (`MainActivity`)**
- Mensaje de bienvenida: "Bienvenido a la aplicación del clima".
- Botones principales:
  - **Pronóstico actual**: Navega a `DetailActivity` para mostrar detalles del clima de una ciudad específica (Buenos Aires por defecto).
  - **Listado de ciudades**: Navega a `ListActivity` para seleccionar una ciudad de la lista.

### **2. Listado de Ciudades (`ListActivity`)**
- **ListView** que muestra una lista de 5 ciudades:
  - Buenos Aires, Córdoba, Rosario, Mendoza, Salta.
- Diseño personalizado de los elementos de la lista mediante un layout (`list_item.xml`) y un adaptador (`MyAdapter`).
- Navegación a `DetailActivity` al seleccionar una ciudad de la lista, pasando el nombre de la ciudad como parámetro.

### **3. Detalles del Clima (`DetailActivity`)**
- Muestra la siguiente información:
  - Nombre de la ciudad.
  - Temperatura actual, mínima y máxima.
  - Descripción del clima.
  - Icono representativo del clima.
- Implementación de una llamada a la API de OpenWeatherMap mediante Retrofit para obtener datos climáticos en tiempo real.
- Manejo de errores en caso de fallos en la red o datos incompletos.

### **4. API y Conexión (`RetrofitClient` y `WeatherService`)**
- Conexión a OpenWeatherMap utilizando Retrofit.
- Conversión automática de JSON a objetos Java mediante Gson.
- Endpoints utilizados:
  - `/weather`: Obtiene el clima actual de una ciudad específica.

---

## **Estructura del Proyecto**

### **Archivos Principales**
- **`MainActivity.java`**: Actividad principal con navegación a `ListActivity` y `DetailActivity`.
- **`ListActivity.java`**: Muestra el listado de ciudades y permite seleccionar una para ver su detalle.
- **`DetailActivity.java`**: Muestra la información climática detallada de una ciudad.
- **`RetrofitClient.java`**: Configuración de Retrofit para la conexión con OpenWeatherMap.
- **`WeatherService.java`**: Interface para realizar las llamadas a la API.
- **`MyAdapter.java`**: Adaptador personalizado para la lista de ciudades.

### **Clases y Modelos**
- **`WeatherResponse`**: Clase modelo que mapea la respuesta JSON de la API.
- **`Weather` y `Main`**: Subclases de `WeatherResponse` que representan partes específicas del JSON.

### **Layouts**
- **`activity_main.xml`**: Diseño de la pantalla principal.
- **`activity_list.xml`**: Diseño de la pantalla de listado de ciudades.
- **`activity_detail.xml`**: Diseño de la pantalla de detalles del clima.
- **`list_item.xml`**: Diseño personalizado para los elementos de la lista de ciudades.

---

## **Requisitos Previos**
- **Android Studio** instalado.
- Dispositivo o emulador Android configurado.
- API Key de OpenWeatherMap.

---

## **Configuración del Proyecto**
1. Clona el repositorio.
   ```bash
   git clone https://github.com/Marcktm/appClimaAndroidApi.git
   ```
2. Abre el proyecto en Android Studio.
3. Añade tu API Key de OpenWeatherMap en `BuildConfig.API_KEY`.
4. Ejecuta el proyecto en un emulador o dispositivo real.

---

## **Capturas de Pantalla**
1. **Pantalla Principal:**
   ![Pantalla Principal](./img/Screenshot%202024-12-08%2012.40.12.png)

2. **Listado de Ciudades:**
   ![Listado de Ciudades](./img/Screenshot%202024-12-08%2012.43.58.png)

3. **Detalles del Clima:**
   ![Detalles del Clima](./img/Screenshot%202024-12-08%2012.44.30.png)
   ![Detalles del Clima](./img/Screenshot%202024-12-08%2012.45.46.png)

---

## **Tecnologías Utilizadas**
- **Lenguaje:** Java
- **IDE:** Android Studio
- **Librerías:**
  - Retrofit
  - Gson
  - Picasso

---

## **Autores**
Desarrollado por **Marcos Reyeros** como parte de un proceso de evaluación técnica para Teclab S.A.

---

## **Licencia**
Este proyecto se encuentra bajo la licencia MIT. Puedes utilizarlo libremente para fines educativos o personales.
