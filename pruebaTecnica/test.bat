@echo off
echo Probando API...
curl -X POST http://localhost:8080/api/enviar-pedido -H "Content-Type: application/json" -d @test-request.json
echo.
echo.
