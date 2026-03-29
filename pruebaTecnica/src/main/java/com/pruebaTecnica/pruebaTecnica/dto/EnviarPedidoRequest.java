package com.pruebaTecnica.pruebaTecnica.dto;

public class EnviarPedidoRequest {
    private EnvioPedidoData enviarPedido;

    public EnvioPedidoData getEnviarPedido() {
        return enviarPedido;
    }

    public void setEnviarPedido(EnvioPedidoData enviarPedido) {
        this.enviarPedido = enviarPedido;
    }

    public static class EnvioPedidoData {
        private String numPedido;
        private String cantidadPedido;
        private String codigoEAN;
        private String nombreProducto;
        private String numDocumento;
        private String direccion;

        public String getNumPedido() {
            return numPedido;
        }

        public void setNumPedido(String numPedido) {
            this.numPedido = numPedido;
        }

        public String getCantidadPedido() {
            return cantidadPedido;
        }

        public void setCantidadPedido(String cantidadPedido) {
            this.cantidadPedido = cantidadPedido;
        }

        public String getCodigoEAN() {
            return codigoEAN;
        }

        public void setCodigoEAN(String codigoEAN) {
            this.codigoEAN = codigoEAN;
        }

        public String getNombreProducto() {
            return nombreProducto;
        }

        public void setNombreProducto(String nombreProducto) {
            this.nombreProducto = nombreProducto;
        }

        public String getNumDocumento() {
            return numDocumento;
        }

        public void setNumDocumento(String numDocumento) {
            this.numDocumento = numDocumento;
        }

        public String getDireccion() {
            return direccion;
        }

        public void setDireccion(String direccion) {
            this.direccion = direccion;
        }
    }
}
