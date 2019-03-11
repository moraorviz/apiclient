## Kotlin & Spring Reactive APIClient

Cliente del long polling stream que nos sirve la API de meet.com

- Kotlin
- Spring WebFlux & WebClient
- Spring Boot 2.0 RC1 with Netty
- MongoDb & Reactive Repositories

```docker
docker run -d -p 27017:27017 --name mongodb -d mongo
```
Es necesario tener un contenedor de mongo levantado en local
para que spring lo descubra en el arranque y poder persistir

Función:
1. Emplea operadores de reactor para modificar el stream de datos
2. Se usa el objeto flux para almacenar el stream en tiempo real
y flatmap para persistirlo según el modelo de objetos que hemos creado
para la reunión con los campos importantes y anotaciones de Spring
3. Para el segundo caso de uso se intenta combinar FlatMap con 
takeWhile 

Éste microservicio es encargado de realizar operaciones en bbdd (crear)
y es consumido por el servidor de python.


Necesita Java 8 de oracle y la última versión de gradle para funcionar.
Se arranca con el comando $ gradle bootRun o desde el IDE