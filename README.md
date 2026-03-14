# Gestión Veterinaria
> *Versión mejorada, claramente más bonita."

**Especificación**

- ***Backend***
    - Spring Boot 4.x
    - java 21
    - Maven
    -H2 Database

# 🛠️ Descripción Backend

- **Lista de servicios**
    - Cliente-service
    - Paciente-service
    - productos (Próximamente).

## 🗄️ Base de Datos - H2 Database

- H2 elimina la fricción de configurar credenciales, puertos o servicios externos.
 Permite que se descargue el código pueda ejecutarlo de inmediato sin configuraciones previas de infraestructura.

## Funcionamiento

- Levanta primero el servicio "Cliente" con Spring Dashboard (preferible, no necesario) y luego el servicio "Paciente", el servicio paciente depende del puerto activo de cliente.

## 📖 Documentación de la API (Swagger)

- Una vez que la aplicación esté totalmente levantada, accede a la interfaz de Swagger para las pruebas en postman:

👉 [http://localhost:8081/doc/swagger-ui.html](http://localhost:8081/doc/swagger-ui.html) - Clientes

👉 [http://localhost:8082/doc/swagger-ui.html](http://localhost:8082/doc/swagger-ui.html) - Pacientes

# Descripción Frontend
> próximamente.
