# TALLER 3 - BUENAS PRACTICAS DE POO

**Table of Contents**

[TOCM]

[TOC]

## INTRODUCCION

Este proyecto tiene como finalidad cumplir con los requisitos mínimos exigidos para la entrega del tercer taller (Buenas prácticas de programación y manejo de excepciones). Para tal fin, se realiza un proceso de análisis de la información con el objetivo de extraer datos relevantes que permitan diseñar una aplicación que administre una lista de canciones y que adicionalmente cumpla con los siguientes requisitos:

1. Tener una biblioteca principal con todas las canciones.

2. Tener una funcionalidad que permita crear playlist con canciones determinadas

3. Cada canción debe tener el título, identificador, fecha, duración, genero, caratula y una descripción corta.

4. Se deben crear comportamientos en donde se permita hacer filtros a la biblioteca principal, los filtros son:
	- Filtrar canciones del mismo género.
	- Filtrar canciones en el mismo año.
5. Se debe crear comportamientos en donde se permita ordenar por duración y fecha.

## DESCRIPCION

Se llevó a cabo un proceso de abstracción por medio del cual se detectaron aspectos específicos que describen el comportamiento de un reproductor de música.

Gracias al proceso de abstracción anteriormente mencionado, se logró que el reproductor de música desarrollado en el presente proyecto ofrezca las siguientes funcionalidades:

### Funcionalidades Del Reproductor
A continuación, se puntualizan cada una de las funciones que ofrece el reproductor:

1. Listar la biblioteca general de canciones.
2. Reproducir la biblioteca general de canciones.
3. Crear playlist a partir de la biblioteca general de canciones.
	- Ver playlist.
	- Reproducir playlist.
4. Ordenar la Biblioteca general de canciones:
	- Ordenar por generos.
	- Ordenar alfabeticamente por titulo de la canción.
	- Ordenar por duración.
	- Ordenar por año.
5. Reproducir lista ordenada.
6. Crear playlist a partir de la lista ordenada.
	- Ver playlist.
	- Reproducir playlist.
6. Filtrar canciones por género.
7. Reproducir genero filtrado.

### Clases Implementadas
- Main (Clase Main)
- SongsLibrary (Clase Abstracta)
- PlayList
- SortBy

## TEMAS

En el presente proyecto se elaboraron 4 clases de la cuales 1 es abstracta. En estas se abordan algunos temas de la programación orientada a objetos, tales como:

- Clases.
- Objetos.
- Atributos.
- Métodos.
- Modificadores de acceso.
- Método constructor.
- Abstracciones.
- Polimorfismo, etc.
- Manejo de excepciones (try-catch).
- Documentación.
- Buenas prácticas de programación.

Finalmente, la totalidad de las clases se encuentran en el package ***edu.musicplayer*** .
