# API REST - Envío de Pedidos ACME

## Ejecutar con Docker

```bash
docker-compose up --build
```

La aplicación estará disponible en `http://localhost:8080`

## Swagger UI

Accede a la documentación interactiva en:
- **Swagger UI:** http://localhost:8080/swagger-ui.html
- **API Docs:** http://localhost:8080/api-docs

Desde Swagger UI puedes probar todos los endpoints directamente desde el navegador.

## Endpoint

**POST** `/api/enviar-pedido`

### Request
```json
{
  "enviarPedido": {
    "numPedido": "75630275",
    "cantidadPedido": "1",
    "codigoEAN": "0011000076519100210458",
    "nombreProducto": "Armario INVAL",
    "numDocumento": "1113987400",
    "direccion": "CR 72B 45 12 APT 301"
  }
}
```

### Response
```json
{
  "enviarPedidoRespuesta": {
    "codigoEnvio": "80375472",
    "estado": "Entregado exitosamente al cliente"
  }
}
```

## Ejemplo con curl

```bash
curl -X POST http://localhost:8080/api/enviar-pedido \
  -H "Content-Type: application/json" \
  -d '{
    "enviarPedido": {
      "numPedido": "75630275",
      "cantidadPedido": "1",
      "codigoEAN": "0011000076519100210458",
      "nombreProducto": "Armario INVAL",
      "numDocumento": "1113987400",
      "direccion": "CR 72B 45 12 APT 301"
    }
  }'
```

## Probar con script

```bash
.\test.bat
```

## Ejecutar sin Docker

```bash
./mvnw spring-boot:run
```
