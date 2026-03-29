package com.pruebaTecnica.pruebaTecnica.controller;

import com.pruebaTecnica.pruebaTecnica.dto.EnviarPedidoRequest;
import com.pruebaTecnica.pruebaTecnica.dto.EnviarPedidoResponse;
import com.pruebaTecnica.pruebaTecnica.service.PedidoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@Tag(name = "Pedidos", description = "API para gestión de pedidos ACME")
public class PedidoController {

    private final PedidoService pedidoService;

    public PedidoController(PedidoService pedidoService) {
        this.pedidoService = pedidoService;
    }

    @PostMapping("/enviar-pedido")
    @Operation(summary = "Enviar pedido", description = "Procesa un pedido transformando JSON a XML y retorna la respuesta del servicio de envío")
    public ResponseEntity<EnviarPedidoResponse> enviarPedido(@RequestBody EnviarPedidoRequest request) {
        EnviarPedidoResponse response = pedidoService.procesarPedido(request);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/health")
    @Operation(summary = "Health check", description = "Verifica que el servicio está disponible")
    public ResponseEntity<String> health() {
        return ResponseEntity.ok("OK");
    }
}
