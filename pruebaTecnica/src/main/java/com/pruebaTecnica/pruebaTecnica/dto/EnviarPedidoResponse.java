package com.pruebaTecnica.pruebaTecnica.dto;

public class EnviarPedidoResponse {
    private EnvioPedidoRespuestaData enviarPedidoRespuesta;

    public EnvioPedidoRespuestaData getEnviarPedidoRespuesta() {
        return enviarPedidoRespuesta;
    }

    public void setEnviarPedidoRespuesta(EnvioPedidoRespuestaData enviarPedidoRespuesta) {
        this.enviarPedidoRespuesta = enviarPedidoRespuesta;
    }

    public static class EnvioPedidoRespuestaData {
        private String codigoEnvio;
        private String estado;

        public String getCodigoEnvio() {
            return codigoEnvio;
        }

        public void setCodigoEnvio(String codigoEnvio) {
            this.codigoEnvio = codigoEnvio;
        }

        public String getEstado() {
            return estado;
        }

        public void setEstado(String estado) {
            this.estado = estado;
        }
    }
}
