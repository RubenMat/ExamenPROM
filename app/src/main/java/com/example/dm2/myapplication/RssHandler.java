package com.example.dm2.myapplication;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dm2 on 02/02/2018.
 */

public class RssHandler extends DefaultHandler {

    private List<Tiempo> tiempos;
    private Tiempo tiempoActual;
    private StringBuilder sbTexto;
    public List<Tiempo> getNoticias(){
        return tiempos;
    }
    @Override
    public void characters(char[] ch, int start, int length)
            throws SAXException {
        super.characters(ch, start, length);
        if (this.tiempoActual != null)
            sbTexto.append(ch, start, length);
    }
    @Override
    public void endElement(String uri, String localName, String name)
            throws SAXException {
        super.endElement(uri, localName, name);
        if (this.tiempoActual != null) {
            if (localName.equals("hora_datos")) {
                    tiempoActual.setHora(sbTexto.toString());
            } else if (localName.equals("temperatura")) {
                tiempoActual.setTemperatura(sbTexto.toString());
            } else if (localName.equals("texto")) {
                tiempoActual.setCielo(sbTexto.toString());
            } else if (localName.equals("hora")) {
                tiempos.add(tiempoActual);
            }
            sbTexto.setLength(0);
        }
    }
    @Override
    public void startDocument() throws SAXException {
        super.startDocument();
        tiempos = new ArrayList<Tiempo>();
        sbTexto = new StringBuilder();
    }
    @Override
    public void startElement(String uri, String localName,
                             String name, Attributes attributes) throws SAXException {
        super.startElement(uri, localName, name, attributes);
        if (localName.equals("hora")) {
            tiempoActual= new Tiempo();
        }
    }
}
