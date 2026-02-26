Juan Sebastian Romero Torres
Samuel David Cifuentes Alvarez
Juan Camilo Criollo Cifuentes

# Artistas y Pistas

## Requisitos

- JDK 17 o superior
- Maven 3.6 o superior
- Apache Tomcat 10.1.52 (o compatible con Jakarta Servlets)

Las dependencias (Spring, Jakarta, etc.) se resuelven mediante Maven (`pom.xml`).

## Despliegue

1. Compila y empaqueta con Maven:
   ```bash
   mvn clean package
   ```
2. Copia el archivo generado (por ejemplo `target/artists-1.0-SNAPSHOT.war`) en la carpeta `webapps` de Tomcat.
3. Inicia Tomcat (`bin/startup.bat` en Windows).
4. Abre tu navegador y visita las rutas:
   - `http://localhost:8080/Artists/artistas` para gestionar artistas.
   - `http://localhost:8080/Artists/pistas` para gestionar pistas.

   *(si despliegas con otro nombre de contexto sustituye `Artists` por el correspondiente).* 

