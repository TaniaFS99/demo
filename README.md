## Instalación
https://github.com/TaniaFS99/demo.git

## Link para consultar la documentación de Swagger: 
http://localhost:8080/swagger-ui/index.html#/demo-controller/retornaConsulta

## Instrucciones para la ejecución del proyecto: 
El proyecto fue contruido en el IDE Intellij Idea, para lograr ejecutar el mismo es necesario seguir los siguientes pasos:
1. Definir el sdk module a utilizar en la aplicación, en este caso la aplicación se desarrolló con el sdk de java en su versión 11.0.13
2. Seleccionar la carpeta src como módulo Source. Para ello dirigirse al apartado File-> Project Structure -> Modules -> Mark as: Sources -> src
3. Definir el home path de maven: Para configurar esta opción dirigirse a: File-> Settings -> Build, Execution, Deployment -> Build Tools -> Maven -> Maven home path -> Bundled (Maven 3)
4. Añadir configuraciones de ejecución. En el apartado de Add Configuration seleccionar: Add new run configuration -> Application -> Seleccionar la clase main -> apply -> ok
