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
        //pega o XML da classe ExportData
        String xml = exportData.ArrayToXMLFormat(data, multipler, tag);

        //converte XML para JSON
        String json = convertXmlToJson(xml);

        return json; //retorna o JSON
    }

    private String convertXmlToJson(String xml) {
        ////remove o cabeçalho XML
        xml = xml.replaceAll("<\\?xml.*?\\?>", "").trim();

        StringBuilder json = new StringBuilder();
        json.append("{\"").append(tag).append("\": [");

        boolean firstItem = true;
        for (String[] item : data) {
            if (!firstItem) {
                json.append(", "); //vírgula entre os itens para a formatação ficar certinha
            }
            firstItem = false;

            json.append("{");
            for (int i = 0; i < item.length; i += 2) {
                if (i > 0) json.append(", ");
                json.append("\"").append(item[i]).append("\": \"").append(item[i + 1]).append("\"");
            }
            json.append("}");
        }
        //echa JSson
        json.append("]}");

        return json.toString();
    }
}
