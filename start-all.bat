@echo off
echo Starting all services...

start "Auth Service" cmd /k "cd auth-service && node index.js"
start "Payment Service" cmd /k "cd payment-service && node index.js"
start "Library Service" cmd /k "cd library_service && ./mvnw spring-boot:run"
start "Frontend" cmd /k "cd capstone && npm run dev"

echo All services are starting in separate windows.