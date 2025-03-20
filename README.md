# dnd-app-backend

DnDAppBackend es el backend para la aplicación DnDApp. Proporciona servicios para la gestión de usuarios, personajes y mundos.

## Tecnologías

- **Java**: 21
- **Spring Boot**: 3.4.3
- **Maven**: 4.0.0
- **Base de datos**: MySQL

### Dependencias principales:

- `spring-boot-starter-data-jpa` (3.4.3)
- `spring-boot-starter-security` (3.4.3)
- `spring-boot-starter-web` (3.4.3)
- `mysql-connector-j` (9.1.0)
- `lombok` (1.18.36)

## Configuración

El proyecto utiliza un archivo `application.properties`para configurar la base de datos.

## Endpoints

- **`api/auth`** > Autenticación (registro, login, ...)
- **`api/users`** > Consulta y manejo de usuarios.
- **`api/users/{id}/characters`** > Consulta y manejo de personajes de un usuario.
- **`api/users/{id}/worlds`** > Consulta y manejo de mundos de un usuario.

## Ejecución

Las instrucciones para ejecutar el proyecto se añadirán más tarde.

## Licencia

Este proyecto no tiene licencia.
