🛒 Commerce - Plataforma de Comercio Electrónico

📌 Descripción

Commerce es una aplicación backend desarrollada en Java con Spring Boot para la gestión de un comercio
electrónico.Permite administrar productos, usuarios y pedidos de forma eficiente mediante una arquitectura modular
basada en REST APIs.

📂 Estructura del Proyecto

commerce
│── src
│ ├── main
│ │ ├── java/com/store/commerce
│ │ │ ├── dto/ # Objetos de transferencia de datos
│ │ │ ├── exceptions/ # Manejo de excepciones personalizadas
│ │ │ ├── models/ # Entidades del dominio
│ │ │ ├── repository/ # Interfaces de persistencia con Spring Data JPA
│ │ │ ├── services/ # Lógica de negocio
│ │ │ ├── utils/ # Clases de utilidad
│ │ │ ├── web.controller/ # Controladores REST
│ │ │ ├── CommerceApplication.java # Clase principal de Spring Boot
│ │ ├── resources
│ │ │ ├── static/ # Recursos estáticos
│ │ │ ├── templates/ # Plantillas HTML (si aplica)
│ │ │ ├── application.properties # Configuración principal
│ │ │ ├── application-dev.properties # Configuración de desarrollo
│ │ │ ├── application-pdn.properties # Configuración de producción
│── test/ # Pruebas automatizadas
│── build.gradle # Configuración de Gradle
│── README.md # Documentación del proyecto
│── .gitignore # Archivos y carpetas ignoradas por Git

🚀 Tecnologías Utilizadas

Java 21+

Spring Boot 3

Spring Data JPA (Hibernate)

Spring Web (REST API)

Gradle para la gestión de dependencias

SQL Server para la base de datos

Lombok para reducir código repetitivo

JUnit 5 & Mockito para pruebas automatizadas

⚙️ Configuración y Ejecución

1️⃣ Clonar el repositorio:

git clone https://github.com/tu-usuario/tienda-.git
cd commerce

2️⃣ Configurar la base de datos (SQL Server)

Asegúrate de tener un servidor SQL Server corriendo y configura application.properties o application-dev.properties:

spring.datasource.url=jdbc:sqlserver://localhost:1433;databaseName=commerce
spring.datasource.username=tu_usuario
spring.datasource.password=tu_contraseña
spring.datasource.driver-class-name=com.microsoft.sqlserver.jdbc.SQLServerDriver
spring.jpa.hibernate.ddl-auto=update
spring.jpa.database-platform=org.hibernate.dialect.SQLServerDialect

3️⃣ Construir y ejecutar:

./gradlew build
./gradlew bootRun

La API estará disponible en http://localhost:8080

