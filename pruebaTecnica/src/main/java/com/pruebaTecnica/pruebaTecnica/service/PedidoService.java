package com.pruebaTecnica.pruebaTecnica.service;

import com.pruebaTecnica.pruebaTecnica.dto.EnviarPedidoRequest;
import com.pruebaTecnica.pruebaTecnica.dto.EnviarPedidoResponse;
import com.pruebaTecnica.pruebaTecnica.xml.SoapEnvelope;
import com.pruebaTecnica.pruebaTecnica.xml.SoapEnvelopeResponse;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.Marshaller;
import jakarta.xml.bind.Unmarshaller;
import org.springframework.stereotype.Service;

import java.io.StringReader;
import java.io.StringWriter;

@Service
public class PedidoService {

    public EnviarPedidoResponse procesarPedido(EnviarPedidoRequest request) {
        SoapEnvelope soapRequest = jsonToXml(request);
        
        SoapEnvelopeResponse soapResponse = mockSoapService(soapRequest);
        
        return xmlToJson(soapResponse);
    }

    private SoapEnvelope jsonToXml(EnviarPedidoRequest request) {
        SoapEnvelope envelope = new SoapEnvelope();
        SoapEnvelope.Body body = new SoapEnvelope.Body();
        SoapEnvelope.EnvioPedidoAcme envioPedidoAcme = new SoapEnvelope.EnvioPedidoAcme();
        SoapEnvelope.EnvioPedidoRequest envioPedidoRequest = new SoapEnvelope.EnvioPedidoRequest();

        EnviarPedidoRequest.EnvioPedidoData data = request.getEnviarPedido();
        envioPedidoRequest.setPedido(data.getNumPedido());
        envioPedidoRequest.setCantidad(data.getCantidadPedido());
        envioPedidoRequest.setEan(data.getCodigoEAN());
        envioPedidoRequest.setProducto(data.getNombreProducto());
        envioPedidoRequest.setCedula(data.getNumDocumento());
        envioPedidoRequest.setDireccion(data.getDireccion());

        envioPedidoAcme.setEnvioPedidoRequest(envioPedidoRequest);
        body.setEnvioPedidoAcme(envioPedidoAcme);
        envelope.setBody(body);

        return envelope;
    }

    private EnviarPedidoResponse xmlToJson(SoapEnvelopeResponse soapResponse) {
        EnviarPedidoResponse response = new EnviarPedidoResponse();
        EnviarPedidoResponse.EnvioPedidoRespuestaData data = new EnviarPedidoResponse.EnvioPedidoRespuestaData();

        SoapEnvelopeResponse.EnvioPedidoResponse xmlResponse = 
            soapResponse.getBody().getEnvioPedidoAcmeResponse().getEnvioPedidoResponse();

        data.setCodigoEnvio(xmlResponse.getCodigo());
        data.setEstado(xmlResponse.getMensaje());
        response.setEnviarPedidoRespuesta(data);

        return response;
    }

    private SoapEnvelopeResponse mockSoapService(SoapEnvelope request) {
        SoapEnvelopeResponse envelope = new SoapEnvelopeResponse();
        SoapEnvelopeResponse.Body body = new SoapEnvelopeResponse.Body();
        SoapEnvelopeResponse.EnvioPedidoAcmeResponse acmeResponse = new SoapEnvelopeResponse.EnvioPedidoAcmeResponse();
        SoapEnvelopeResponse.EnvioPedidoResponse response = new SoapEnvelopeResponse.EnvioPedidoResponse();

        response.setCodigo("80375472");
        response.setMensaje("Entregado exitosamente al cliente");

        acmeResponse.setEnvioPedidoResponse(response);
        body.setEnvioPedidoAcmeResponse(acmeResponse);
        envelope.setBody(body);

        return envelope;
    }

    public String convertToXmlString(SoapEnvelope envelope) {
        try {
            JAXBContext context = JAXBContext.newInstance(SoapEnvelope.class);
            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            
            StringWriter writer = new StringWriter();
            marshaller.marshal(envelope, writer);
            return writer.toString();
        } catch (Exception e) {
            throw new RuntimeException("Error al convertir a XML", e);
        }
    }

    public SoapEnvelopeResponse convertFromXmlString(String xml) {
        try {
            JAXBContext context = JAXBContext.newInstance(SoapEnvelopeResponse.class);
            Unmarshaller unmarshaller = context.createUnmarshaller();
            return (SoapEnvelopeResponse) unmarshaller.unmarshal(new StringReader(xml));
        } catch (Exception e) {
            throw new RuntimeException("Error al parsear XML", e);
        }
    }
}
