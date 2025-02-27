/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.padroes;

/**
 *
 * @author Gutem
 */
import java.util.ArrayList;

public class AdapterExportDados implements IDadoFormatado {
    private ExportData exportData;
    private ArrayList<String[]> data;
    private int multipler;
    private String tag;

    public AdapterExportDados(ExportData exportData, ArrayList<String[]> data, int multipler, String tag) {
        this.exportData = exportData;
        this.data = data;
        this.multipler = multipler;
        this.tag = tag;
    }

    @Override
    public String toJson() {
        //pega o XML de ExportData
        String xml = exportData.ArrayToXMLFormat(data, multipler, tag);

        //converte XML pra JSON
        String json = convertXmlToJson(xml);

        return json;
    }

    private String convertXmlToJson(String xml) {
    //remove o cabeçalho XML
    xml = xml.replace("<?xml version=\"1.0\"?>", "");

    //converte XML p JSON
    xml = xml.replace("<data>", "{\"" + tag + "\": [");
    xml = xml.replace("</data>", "]}");
    xml = xml.replace("<" + tag + ">", "{");
    xml = xml.replace("</" + tag + ">", "}");

    for (String[] item : data) {
        String key = item[0];
        String value = item[1];
        xml = xml.replace("<" + key + "> " + value + " </" + key + ">", "\"" + key + "\": \"" + value + "\",");
    }

    xml = xml.replace(",}", "}");

    xml = xml.replace("}{", "}, {");

    return xml;
}
}
