package com.tienda.core.controllers;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.awt.*;

@RestController
@RequestMapping("/clientes")
public class ClienteRenderController {

    @GetMapping(value = "html", produces = MediaType.TEXT_HTML_VALUE)
    public String getClienteAsHtml(){

        StringBuilder sb = new StringBuilder();
        sb.append("<html>");
        sb.append("<body>");
        sb.append(" <div><h1>Cliente</h1>");
        sb.append("  <ul>");
        sb.append("   <li>Nombre: Rafael Sanches</li>");
        sb.append("   <li>UserName: rbs</li>");
        sb.append("  <ul>");
        sb.append(" <div>");
        sb.append("<body>");
        sb.append("<html>");

        return sb.toString();
    }

    @GetMapping(value = "xml", produces = MediaType.APPLICATION_XML_VALUE)
    public String getClienteAsXml(){

        StringBuilder sb = new StringBuilder();
        sb.append("<Xml>");
        sb.append("<cliente>");
        sb.append("  <ul>");
        sb.append("   <li>Nombre: Rafael Sanches</li>");
        sb.append("   <li>UserName: rbs</li>");
        sb.append("  <ul>");
        sb.append("<cliente>");
        sb.append("<Xml>");

        return sb.toString();
    }
}
