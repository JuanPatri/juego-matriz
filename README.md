# Proyecto Obligatorio 1: Juego de Tablero

## Descripción

Este proyecto implementa un juego de tablero interactivo en Java donde los jugadores pueden elegir entre diferentes modos de juego. El juego permite leer tableros desde un archivo de texto, utilizar tableros predefinidos o generar tableros aleatorios. El usuario puede realizar movimientos en el tablero y, a medida que avanza, puede acceder a un historial de movimientos y soluciones.

## Integrantes
- **Theo Brum** (N° 315141)
- **Juan Pablo Patri** (N° 266824)

## Características principales

- **Modos de juego**:
  - **Tomar datos del archivo**: Cargar un tablero desde un archivo de texto.
  - **Usar el tablero predefinido**: Elegir un tablero predefinido basado en un nivel de dificultad.
  - **Tablero aleatorio**: Generar un tablero aleatorio con filas, columnas y niveles de dificultad definidos por el usuario.

- **Movimientos**: El jugador puede realizar movimientos en el tablero, especificando filas y columnas para colocar elementos.
  
- **Historial y solución**: El jugador tiene la opción de ver un historial de los movimientos realizados o la solución al juego.

- **Interfaz de consola**: La interfaz es completamente basada en consola, con interacción a través de texto.

## Requisitos

- **Java 8 o superior**
- **Un entorno de desarrollo integrado (IDE)**, como IntelliJ IDEA, Eclipse o NetBeans.

## Estructura del Proyecto

El proyecto está estructurado en las siguientes clases principales:

### 1. `Interfaz`
Esta clase maneja la interacción con el usuario. Permite iniciar el juego, seleccionar entre las diferentes opciones de tablero, realizar movimientos y acceder a las opciones de historial y solución.

### 2. `Juego`
Contiene las lógicas relacionadas con el juego en sí, incluyendo el manejo de los tableros, los movimientos realizados, el historial y las soluciones.

### 3. `Sistema`
Encargada de manejar operaciones del sistema, como la lectura de archivos, generación de tableros predefinidos, generación de tableros aleatorios y la manipulación del tiempo de juego.
