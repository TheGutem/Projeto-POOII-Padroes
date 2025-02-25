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

//VOCÊ NÃO DEVE MODIFICAR ESTA CLASSE
public class ExportData {
    public String ArrayToXMLFormat(ArrayList<String[]> data, int multipler, String tag){
        String xml = "";
        xml += "<?xml version=\"1.0\"?>";
		xml += "<data>";
		for (int i = 0; i < data.size(); i++) {
            if(i%multipler == 0){
               xml += "<"+tag+">"; 
            }
			xml += "   <" + data.get(i)[0] + "> " + data.get(i)[1] + " </" + data.get(i)[0] + ">";
            if(i+1%multipler == 0){
                xml += "</"+tag+">"; 
            }
        }
		xml += "</data>";
        return xml;
    }
}
