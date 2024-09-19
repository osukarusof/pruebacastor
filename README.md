<div align="center">
    <img src="https://download.logo.wine/logo/Spring_Framework/Spring_Framework-Logo.wine.png" width="250" alt="spring boot" />
</div>

El proyecto tiene como objetivo desarrollar una solución en Java para gestionar la información de empleados y solicitudes de servicios en una empresa. El sistema permitirá almacenar y administrar datos de empleados, como su cédula, nombre, fecha de ingreso, cargo y una foto de perfil, utilizando Spring Boot para la API. Además, se podrán registrar solicitudes de servicios, gestionando la información de cada solicitud, su estado y los servicios solicitados. La solución incluirá una base de datos asociada para almacenar y gestionar toda la información de manera eficiente.

# Tecnologias
- Java
- Maven
- Spring Boot
- Mysql Database
- JPA
- Docker

# Requirimientos
- Java 17
- maven 3.9
- Docker

# Prerrequisitos

* Docker: Asegúrate de tener Docker y Docker Compose instalados en tu máquina. Puedes descargar Docker desde aquí e instalar Docker Compose siguiendo las instrucciones oficiales.


# EXPLICACIÓN

* Definicion del modelo entidad-relación

>```mermaid
>erDiagram
>   EMPLEADOS {
>       int id PK
>       int cedula
>       string nombre
>       string foto
>       date fecha_ingreso
>       int id_cargo FK
>   }
>   CARGOS {
>       int id_cargo PK
>       string nombre_cargo
>   }
>   ESTADOSOLICITUDES {
>       int id_estado_solicitud PK
>       string nombre_estado
>   }
>   SOLICITUDES {
>       int nro_solicitud PK
>       date fecha_solicitud
>       int id_solicitante FK
>       int id_estado_solicitud FK
>   }
>   SERVICIOS {
>       int id_servicio PK
>       string nombre_servicio
>   }
>   SOLICITUDSERVICIOS {
>       int id_solicitud FK
>       int id_servicio FK
>   }
>
>   CARGOS ||--o{ EMPLEADOS : "uno a muchos"
>   EMPLEADOS ||--o{ SOLICITUDES : "uno a muchos"
>   ESTADOSOLICITUDES ||--o{ SOLICITUDES : "uno a muchos"
>   SOLICITUDES ||--o{ SOLICITUDSERVICIOS : "uno a muchos"
>   SERVICIOS ||--o{ SOLICITUDSERVICIOS : "uno a muchos"
>```

# Guía para Ejecutar la Aplicación

Esta guía explica cómo ejecutar la aplicación Spring Boot junto con una base de datos MySQL utilizando Docker y LocalStack para simular servicios de AWS, como S3.

- **Spring Boot y MySQL en Docker**: Usaremos Docker Compose para definir los servicios de la aplicación Spring Boot y MySQL. La aplicación se conectará a la base de datos MySQL mediante las variables de entorno que pasaremos a través del archivo docker-compose.yml.

- **Integración con LocalStack**: LocalStack es una herramienta que simula los servicios de AWS en un entorno local. En esta configuración, agregaremos LocalStack para simular S3 u otros servicios que la aplicación Spring Boot pueda necesitar. No se necesitan credenciales reales, ya que se pueden utilizar credenciales ficticias para las pruebas locales.

Abre una terminal y navega al directorio raíz de tu proyecto donde se encuentran los archivos docker-compose.yml y Dockerfile. Usa el comando cd para cambiar al directorio adecuado:

>```shell
> cd /ruta/a/tu/proyecto
>```

Asegúrate de reemplazar /ruta/a/tu/proyecto con la ruta real a tu directorio de proyecto.

### Paso 1: Construir y Ejecutar los Contenedores

1. Detén y elimina los contenedores existentes (si los hay):

>```shell
> docker-compose down
>```

2. Construye la imagen y levanta los contenedores:

>```shell
> docker-compose up --build
>```

### Paso 2: Acceder a la Aplicación

Una vez que los contenedores estén funcionando, puedes acceder a la aplicación Spring Boot

1. Ejecute el siguiente *script* para el debido funcionamiento de la aplicación

>```sql
>#Tabla de cargos
>CREATE TABLE cargos (
>   id INT PRIMARY KEY AUTO_INCREMENT,
>   nombre VARCHAR(50) NOT NULL
>);
>
>#Tabla de empleados
>CREATE TABLE empleados (
>   id INT PRIMARY KEY AUTO_INCREMENT,
>   cargo_id INT NOT NULL,
>   cedula INT UNIQUE NOT NULL,
>   nombre VARCHAR(100) NOT NULL,
>   foto VARCHAR(255) NOT NULL,
>   fecha_ingreso DATE NOT NULL,
>   FOREIGN KEY (cargo_id) REFERENCES cargos(id)
>);
>
>#Tabla de Estados de Solicitud
>CREATE TABLE estado_solicitudes (
>   id INT PRIMARY KEY AUTO_INCREMENT,
>   nombre VARCHAR(50) NOT NULL
>);
>
>#Tabla de solicitudes
>CREATE TABLE solicitudes (
>   id INT PRIMARY KEY AUTO_INCREMENT,
>   empleado_id INT NOT NULL,
>   estado_solicitud_id INT NOT NULL,
>   fecha_solicitud DATE NOT NULL,
>   FOREIGN KEY (empleado_id) REFERENCES empleados(id),
>   FOREIGN KEY (estado_solicitud_id) REFERENCES estado_solicitudes(id)
>);
>
>#Tabla de Servicios
>CREATE TABLE servicios (
>   id INT PRIMARY KEY AUTO_INCREMENT,
>   nombre VARCHAR(100) NOT NULL
>);
>
>#Tabla de Relación entre Solicitudes y Servicios (Muchos a Muchos)
>CREATE TABLE solicitud_servicios (
>   solicitud_id INT NOT NULL,
>   servicio_id INT NOT NULL,
>   PRIMARY KEY (solicitud_id, servicio_id),
>   FOREIGN KEY (solicitud_id) REFERENCES solicitudes(id),
>   FOREIGN KEY (servicio_id) REFERENCES servicios(id)
>);
>```
