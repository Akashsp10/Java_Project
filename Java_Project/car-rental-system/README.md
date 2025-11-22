Car Rental Management System
This package contains:
- backend: Spring Boot (Java 17) application using H2 in-memory DB
- frontend: React app (create-react-app style)

How to run backend:
1. cd backend
2. mvn spring-boot:run
   (or build with mvn package and run the jar)

H2 console: http://localhost:8080/h2-console
JDBC URL: jdbc:h2:mem:car_rental


How to run frontend:
1. cd frontend
2. npm install
3. npm start

The frontend expects the backend at http://localhost:8080
