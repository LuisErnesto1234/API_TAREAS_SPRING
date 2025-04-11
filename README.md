# 📝 Gestor de Tareas Personales

Este es un proyecto desarrollado con **Spring Boot** que permite gestionar tareas personales a través de una API RESTful. El sistema permite crear, listar, actualizar y eliminar tareas, así como gestionar su prioridad y estado.

## 🚀 Tecnologías utilizadas

- ⚙️ **Spring Boot 3.4.4**
- 🧠 **Spring Web** (REST API)
- 📦 **Spring Data JPA** + **Hibernate**
- 🐬 **MySQL**
- 🛠️ **Maven**
- 🧪 **Spring Boot DevTools** (para desarrollo en caliente)
- 📋 **Spring Validation**
- 📚 **Swagger UI** vía `springdoc-openapi` (Documentación de APIs)

## 📂 Estructura del proyecto

```
src/
└── main/
    ├── java/ │
        └── com.spring.udemy.gestor_de_tareas_personales │
            ├── controller/ │
            ├── dto/ │
            ├── entity/ │
            ├── enums/ │
            ├── exception/ │
            ├── repository/ │
            ├── service/ │
            └── GestorDeTareasApplication.java
    └── resources/
    ├── application.properties
    └── static/
```

## ⚙️ Configuración

Antes de ejecutar la aplicación asegúrate de tener configurado el acceso a la base de datos en tu archivo `application.properties`:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/gestor_tareas
spring.datasource.username=tu_usuario
spring.datasource.password=tu_contraseña
spring.jpa.hibernate.ddl-auto=update
```
## 📘 Documentación de la API

Este proyecto cuenta con documentación generada automáticamente con Swagger.

## 🔗 Accede a la documentación en:

```bash
http://localhost:8080/swagger-ui/index.html
```

## 📄 También puedes consultar el JSON completo de la API en:
```bash
http://localhost:8080/v3/api-docs
```
💥 Manejo de errores
La aplicación incluye un sistema centralizado de manejo de excepciones que:

Retorna errores personalizados en formato JSON.

Captura excepciones comunes como:

EntityNotFoundException

MethodArgumentNotValidException

NoHandlerFoundException

DataIntegrityViolationException

Proporciona detalles útiles como timestamp, status, mensaje y campos inválidos.

Ejemplo de respuesta de error:

{
  "status": 400,
  "mensaje": "Error de validación",
  "localDateTime": "2025-04-10T16:31:37.5427087",
  "campoErrors": [
    {
      "campo": "titulo",
      "mensaje": "El título es obligatorio"
    }
  ]
}

🧪 Endpoints principales
Método	Endpoint	Descripción
GET	/app/tarea	Listar todas las tareas
GET	/app/tarea/{id}	Obtener una tarea
POST	/app/tarea	Crear una nueva tarea
PUT	/app/tarea/{id}	Actualizar una tarea
DELETE	/app/tarea/{id}	Eliminar una tarea
📌 Estado del proyecto
✅ Proyecto completado con:

CRUD funcional.

API REST documentada.

Manejo robusto de errores.

Base de datos conectada con MySQL.

Configuración limpia para despliegue o pruebas locales.

🧑‍💻 Autor
Desarrollado por [Tu Nombre] ✨
Si te gusta este proyecto, ¡no dudes en darle ⭐ y compartirlo!

yaml
Copiar
Editar

