/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.padroes;

/**
 *
 * @author Gutem
 */
public class Recuperacao implements Estado{
    public void setNota(AlunoTurma alunoTurma, double nota) {
        alunoTurma.getNota().setNotaRecuperacao(nota);
        System.out.println("Nota adicionada na recuperação.");
    }
}
