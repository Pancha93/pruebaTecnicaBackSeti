package com.pruebaTecnica.pruebaTecnica.xml;

import jakarta.xml.bind.annotation.*;

@XmlRootElement(name = "Envelope", namespace = "http://schemas.xmlsoap.org/soap/envelope/")
@XmlAccessorType(XmlAccessType.FIELD)
public class SoapEnvelopeResponse {
    
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
        @XmlElement(name = "EnvioPedidoAcmeResponse", namespace = "http://WSDLs/EnvioPedidos/EnvioPedidosAcme")
        private EnvioPedidoAcmeResponse envioPedidoAcmeResponse;

        public EnvioPedidoAcmeResponse getEnvioPedidoAcmeResponse() {
            return envioPedidoAcmeResponse;
        }

        public void setEnvioPedidoAcmeResponse(EnvioPedidoAcmeResponse envioPedidoAcmeResponse) {
            this.envioPedidoAcmeResponse = envioPedidoAcmeResponse;
        }
    }

    @XmlAccessorType(XmlAccessType.FIELD)
    public static class EnvioPedidoAcmeResponse {
        @XmlElement(name = "EnvioPedidoResponse")
        private EnvioPedidoResponse envioPedidoResponse;

        public EnvioPedidoResponse getEnvioPedidoResponse() {
            return envioPedidoResponse;
        }

        public void setEnvioPedidoResponse(EnvioPedidoResponse envioPedidoResponse) {
            this.envioPedidoResponse = envioPedidoResponse;
        }
    }

    @XmlAccessorType(XmlAccessType.FIELD)
    public static class EnvioPedidoResponse {
        @XmlElement(name = "Codigo")
        private String codigo;
        
        @XmlElement(name = "Mensaje")
        private String mensaje;

        public String getCodigo() {
            return codigo;
        }

        public void setCodigo(String codigo) {
            this.codigo = codigo;
        }

        public String getMensaje() {
            return mensaje;
        }

        public void setMensaje(String mensaje) {
            this.mensaje = mensaje;
        }
    }
}
