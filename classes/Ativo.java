/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.padroes;

/**
 *
 * @author Gutem
 */
public class Ativo implements Estado {
    public void setNota(AlunoTurma alunoturma, Nota nota){
        alunoturma.setNota(nota);
        System.out.println("Nota atribuida");
    }

    
    
}