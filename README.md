# Foro-Hub-Challenge
![Imagen_API](https://github.com/CristinaReyes99/Foro-Hub-Challenge/blob/desarrollo/Imagenes/image.png?raw=true)

![Java](https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=java&logoColor=white)
![Spring Boot](https://img.shields.io/badge/Spring_Boot-6DB33F?style=for-the-badge&logo=spring-boot&logoColor=white)
![Hibernate](https://img.shields.io/badge/Hibernate-59666C?style=for-the-badge&logo=hibernate&logoColor=white)
![MySQL](https://img.shields.io/badge/MySQL-4479A1?style=for-the-badge&logo=mysql&logoColor=white)
![Flyway](https://img.shields.io/badge/Flyway-CC0200?style=for-the-badge&logo=flyway&logoColor=white)
![JWT](https://img.shields.io/badge/JWT-black?style=for-the-badge&logo=JSON%20web%20tokens)
![Lombok](https://img.shields.io/badge/Lombok-CA0C00?style=for-the-badge&logo=lombok&logoColor=white)
![Maven](https://img.shields.io/badge/Maven-C71A36?style=for-the-badge&logo=apache-maven&logoColor=white)

![Static Badge](https://img.shields.io/badge/STATUS-EN%20DESARROLLO-green) 

Foro-Hub es una API Rest con la funcionalidad para que todos los participantes de una plataforma puedan plantear sus preguntas sobre determinados tópicos.

## Índice
1. [Descripción del Proyecto](#descripción-del-proyecto)
2. [Estado del Proyecto](#estado-del-proyecto)
3. [Características de la Aplicación y Demostración](#características-de-la-aplicación-y-demostración)
4. [Acceso al Proyecto](#acceso-al-proyecto)
5. [Tecnologías Utilizadas](#tecnologías-utilizadas)


## 📖 Descripción del Proyecto 📚
Foro-Hub es resultado del Challenge proporcionado por Alura Latam del programa Oracle One Next Education.

El objetivo de este challenge es implementar una API REST usando SpringBoot con las siguientes funcionalidades:

- API con rutas implementadas siguiendo las mejores prácticas del modelo REST;

- Validaciones realizadas según las reglas de negocio;

- Implementación de una base de datos relacional para la persistencia de la información;

- Servicio de autenticación/autorización para restringir el acceso a la información.

## 🛠️ Estado del Proyecto
El proyecto se encuentra en desarrollo y se planean futuras actualizaciones para expandir sus funcionalidades. Actualmente, el proyecto es completamente funcional, enfocándose específicamente en la gestión de tópicos. La API permite a los usuarios realizar las siguientes operaciones:

- Autenticación/autorización de usuario
- Crear un nuevo tópico
- Mostrar todos los tópicos creados
- Mostrar un tópico específico
- Actualizar un tópico
- Eliminar un tópico

### 🎯 Próximas Actualizaciones
Para completar las funcionalidades del foro, se implementarán nuevas rutas o endpoints que permitirán manejar otras informaciones además de los tópicos. Las rutas previstas son:

/usuario: Para gestionar usuarios del foro.

respuestas: Para gestionar las respuestas a los tópicos.

Estas nuevas funcionalidades ayudarán a enriquecer la interacción dentro del foro, permitiendo un manejo más completo de la información.

## 🌟 Características de la Aplicación 📚

### 📌 Autenticación/Autorización
La API cuenta con un endpoint para el Login de los usuarios, y acepta solicitudes del tipo POST para la URI /tópicoslogin.


**→ Control de acceso:** Después de la generación del token JWT, este debe ser utilizado para autenticar la gestión de registros de los tópicos, incluyendo acciones como creación, consulta, actualización o eliminación. Solo los usuarios autenticados pueden interactuar con la API.


### 📌 Registro de un nuevo tópico
La API cuenta con un endpoint para el registro de tópicos, y  acepta solicitudes del tipo POST para la URI /topicos.

Los datos del tópico (título, mensaje, autor y curso) deben ser enviados en el cuerpo de la solicitud, en formato JSON.

**→ Reglas de negocio:** Todos los campos son obligatorios, por lo tanto, es necesario verificar si todos los campos se están ingresando correctamente.
La API no debe permitir el registro de tópicos duplicados (con el mismo título y mensaje).

### 📌 Listado de tópicos
La API cuenta con un endpoint para el listado de todos los tópicos, y acepta solicitudes del tipo GET para la URI /topicos.

**→ Reglas de negocio:** Los datos de los tópicos (título, mensaje, fecha de creación, estado, autor y curso) deben ser devueltos en el cuerpo de la respuesta, en formato JSON.

### 📌 Detalle de tópicos
La API cuenta con un endpoint para el listado de todos los tópicos, y acepta solicitudes del tipo GET para la URI /topicos/{id}.

**→ Reglas de negocio:** Solicitar el campo ID para realizar la consulta es una acción obligatoria, ya que tu usuario necesita poder visualizar los detalles de un tópico solicitando una consulta a los datos en la base de datos. En este caso, es necesario verificar si el campo ID se ingresó correctamente. Los datos de los tópicos (título, mensaje, fecha de creación, estado, autor y curso) deben ser devueltos en el cuerpo de la respuesta, en formato JSON.

### 📌 Actualización de tópico
La API cuenta con un endpoint para la actualización de los datos de un determinado tópico, y acepta solicitudes del tipo PUT para la URI /topicos/{id}.

**→ Reglas de negocio:** Las mismas reglas de negocio del registro de un tópico deben aplicarse también en su actualización. Dado que estamos realizando una consulta en la base de datos para luego actualizar un tópico, es necesario solicitar y verificar el campo ID de su solicitud.

### 📌 Eliminación de tópico
La API cuenta con un endpoint para la eliminación de un tópico específico, el cual debe aceptar solicitudes del tipo DELETE para la URI /topicos/{id}.

## 💻 Acceso al Proyecto

```sh
git clone https://github.com/CristinaReyes99/Foro-Hub-Challenge.git
```

## 🛠️ Tecnologías Utilizadas 
1. **Spring Boot**
   - **Spring Boot Starter Data JPA**: Para acceso y gestión de datos.
   - **Spring Boot Starter Security**: Para autenticación y autorización.
   - **Spring Boot Starter Validation**: Para validación de datos.
   - **Spring Boot Starter Web**: Para construir aplicaciones web y servicios RESTful.

2. **Flyway**
   - **Flyway Core**: Para migraciones de base de datos.
   - **Flyway MySQL**: Soporte específico de MySQL.

3. **MySQL**
   - **MySQL Connector/J**: Driver JDBC para conexión con MySQL.

4. **Herramientas de Desarrollo**
   - **Spring Boot DevTools**: Herramientas para desarrollo en caliente.

5. **Lombok**
   - **Project Lombok**: Para reducir el código boilerplate.

6. **Autenticación y Seguridad**
   - **Java JWT (Auth0)**: Para manejo de JSON Web Tokens (JWT).

## Autora

|[<img src="https://avatars.githubusercontent.com/u/156963931?v=4" width=115><br><sub>Cristina Reyes</sub>](https://github.com/CristinaReyes99)|
|:---:|
