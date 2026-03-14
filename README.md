# Gestión Veterinaria
> *Versión mejorada, claramente más bonita."

**Especificación**

- ***Backend***
    - Spring Boot 4.x
    - java 21
    - Maven

# 🛠️ Descripción Backend

El backend se basa en Microservicio, por lo que cada caja tiene su carpeta,
 si se cae el servicio de cliente, el servicio de paciente sigue intacto.
- Multi-modulo

- **Lista de servicios**
    - Cliente-service
    - Paciente-service
    - productos (Próximamente).

## 🗄️ Base de Datos - H2 Database

- H2 elimina la fricción de configurar credenciales, puertos o servicios externos.
 Permite que se descargue el código pueda ejecutarlo de inmediato sin configuraciones previas de infraestructura.

## 📖 Documentación de la API (Swagger)

- Una vez que la aplicación ya definida del servicio esté corriendo, accede a la interfaz de Swagger:

👉 [http://localhost:8081/doc/swagger-ui.html](http://localhost:8081/doc/swagger-ui.html) - Clientes

👉 [http://localhost:8082/doc/swagger-ui.html](http://localhost:8082/doc/swagger-ui.html) - Pacientes

> Me dio rabia el swagger, vale queso en la versión anterior - Llaitureo