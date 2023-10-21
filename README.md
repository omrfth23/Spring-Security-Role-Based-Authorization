# Example of Role-Based Access Control with Spring Security

This project is an example of using Spring Security to implement role-based access control for "Manager," "Admin," and "Employee" roles.

## Roles and Access Control

- **Employee:** Can only access GET methods.
- **Manager:** Can access PUT and POST methods, cannot access DELETE method.
- **Admin:** Can access GET and DELETE methods, cannot access PUT and POST methods.

## Project Usage

When the project is running, different users with different roles can access different endpoints as follows:

- **Employee:**
  - GET /api/employee

- **Manager:**
  - GET /api/employee
  - PUT /api/employee
  - POST /api/employee

- **Admin:**
  - GET /api/employee
  - PUT /api/employee
  - POST /api/employee
  - DELETE /api/employee
