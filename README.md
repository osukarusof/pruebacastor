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
>#Tabla de Cargos
>CREATE TABLE Cargos (
>   id_cargo INT PRIMARY KEY AUTO_INCREMENT,
>   nombre_cargo VARCHAR(50) NOT NULL
>);
>
>#Tabla de Empleados
>CREATE TABLE Empleados (
>   id INT PRIMARY KEY AUTO_INCREMENT,
>   cedula INT UNIQUE NOT NULL,
>   nombre VARCHAR(100) NOT NULL,
>   foto VARCHAR(255) NOT NULL,
>   fecha_ingreso DATE NOT NULL,
>   id_cargo INT,
>   FOREIGN KEY (id_cargo) REFERENCES Cargos(id_cargo)
>);
>
>#Tabla de Estados de Solicitud
>CREATE TABLE EstadoSolicitudes (
>   id_estado_solicitud INT PRIMARY KEY AUTO_INCREMENT,
>   nombre_estado VARCHAR(50) NOT NULL
>);
>
>#Tabla de Solicitudes
>CREATE TABLE Solicitudes (
>   nro_solicitud INT PRIMARY KEY AUTO_INCREMENT,
>   fecha_solicitud DATE NOT NULL,
>   id_solicitante INT,
>   id_estado_solicitud INT,
>   FOREIGN KEY (id_solicitante) REFERENCES Empleados(id),
>   FOREIGN KEY (id_estado_solicitud) REFERENCES EstadoSolicitudes(id_estado_solicitud)
>);
>
>#Tabla de Servicios
>CREATE TABLE Servicios (
>   id_servicio INT PRIMARY KEY AUTO_INCREMENT,
>   nombre_servicio VARCHAR(100) NOT NULL
>);
>
>#Tabla de Relación entre Solicitudes y Servicios (Muchos a Muchos)
>CREATE TABLE SolicitudServicios (
>   id_solicitud INT,
>   id_servicio INT,
>   PRIMARY KEY (id_solicitud, id_servicio),
>   FOREIGN KEY (id_solicitud) REFERENCES Solicitudes(nro_solicitud),
>   FOREIGN KEY (id_servicio) REFERENCES Servicios(id_servicio)
>);
>```
