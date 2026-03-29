package com.pruebaTecnica.pruebaTecnica.xml;

import jakarta.xml.bind.annotation.*;

@XmlRootElement(name = "Envelope", namespace = "http://schemas.xmlsoap.org/soap/envelope/")
@XmlAccessorType(XmlAccessType.FIELD)
public class SoapEnvelope {
    
    @XmlElement(name = "Body", namespace = "http://schemas.xmlsoap.org/soap/envelope/")
    private Body body;

    public Body getBody() {
        return body;
    }

    public void setBody(Body body) {
        this.body = body;
    }

    @XmlAccessorType(XmlAccessType.FIELD)
    public static class Body {
        @XmlElement(name = "EnvioPedidoAcme", namespace = "http://WSDLs/EnvioPedidos/EnvioPedidosAcme")
        private EnvioPedidoAcme envioPedidoAcme;

        public EnvioPedidoAcme getEnvioPedidoAcme() {
            return envioPedidoAcme;
        }

        public void setEnvioPedidoAcme(EnvioPedidoAcme envioPedidoAcme) {
            this.envioPedidoAcme = envioPedidoAcme;
        }
    }

    @XmlAccessorType(XmlAccessType.FIELD)
    public static class EnvioPedidoAcme {
        @XmlElement(name = "EnvioPedidoRequest")
        private EnvioPedidoRequest envioPedidoRequest;

        public EnvioPedidoRequest getEnvioPedidoRequest() {
            return envioPedidoRequest;
        }

        public void setEnvioPedidoRequest(EnvioPedidoRequest envioPedidoRequest) {
            this.envioPedidoRequest = envioPedidoRequest;
        }
    }

    @XmlAccessorType(XmlAccessType.FIELD)
    public static class EnvioPedidoRequest {
        @XmlElement(name = "pedido")
        private String pedido;
        
        @XmlElement(name = "Cantidad")
        private String cantidad;
        
        @XmlElement(name = "EAN")
        private String ean;
        
        @XmlElement(name = "Producto")
        private String producto;
        
        @XmlElement(name = "Cedula")
        private String cedula;
        
        @XmlElement(name = "Direccion")
        private String direccion;

        public String getPedido() {
            return pedido;
        }

        public void setPedido(String pedido) {
            this.pedido = pedido;
        }

        public String getCantidad() {
            return cantidad;
        }

        public void setCantidad(String cantidad) {
            this.cantidad = cantidad;
        }

        public String getEan() {
            return ean;
        }

        public void setEan(String ean) {
            this.ean = ean;
        }

        public String getProducto() {
            return producto;
        }

        public void setProducto(String producto) {
            this.producto = producto;
        }

        public String getCedula() {
            return cedula;
        }

        public void setCedula(String cedula) {
            this.cedula = cedula;
        }

        public String getDireccion() {
            return direccion;
        }

        public void setDireccion(String direccion) {
            this.direccion = direccion;
        }
    }
}
