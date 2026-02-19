#  Sistema de Gestión y Venta de Boletas
## Programación 2

---

##  Descripción

Sistema desarrollado en Java utilizando Maven, que permite:

- Crear eventos
- Reservar boletas
- Registrar pagos
- Consultar estados de boletas
- Gestionar disponibilidad por zonas

---

## Requerimientos Funcionales

### 1. Creación de Eventos
El sistema permite crear eventos con:
- Nombre
- Fecha
- Hora
- Lugar
- Organizador
- Tipo de evento

Cada evento contiene zonas con disponibilidad de boletas.

Restricciones:
- Mínimo 1000 boletas por evento.
- Máximo 10.000 boletas por evento.

---

### 2. Reserva de Boletas

El usuario debe:
- Seleccionar un evento
- Seleccionar una sola zona
- Comprar máximo 10 boletas
- Ser mayor de 18 años
- Ingresar cédula válida

Estados posibles:
- RESERVADA
- PAGADA
- CANCELADA_POR_NO_PAGO

Las reservas tienen duración de 24 horas.

---

### 3. Registro de Pago

El sistema:
- Verifica la existencia de reserva
- Permite pagar por:
    - Crédito
    - Débito
    - PSE
- Solo acepta pago por valor exacto

---

##  Modelo UML

El sistema está compuesto por las siguientes clases:

- Cliente
- Evento
- Zona
- Reserva
- Pago

Enums:
- EstadoBoleta
- MetodoPago
- TipoEvento

(Relaciones detalladas en el diagrama UML adjunto)

---

##  Arquitectura del Proyecto

Estructura en capas:

- model → entidades del sistema
- service → lógica de negocio
- repository → almacenamiento
- main → punto de inicio

---

##  Control de Versiones

Ramas utilizadas:

- master → versión estable
- develop → desarrollo
- feature-evento
- feature-pago

Flujo:
1. Desarrollo en ramas feature
2. Merge a develop
3. Merge final a master

---

## 👥 Integrantes

- Nombre 1 : Omar Santiago Ibañez 
- Nombre 2 : Jeronimo Araujo 
