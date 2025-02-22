package com.mycompany.padroes;
import java.util.ArrayList;
public class Semestre {
    private String nome;
    private boolean ativo;
    private ArrayList<IObserver> observadores;

    public Semestre() { }

    public Semestre(String nome, boolean ativo) {
        this.nome = nome;
        this.ativo = ativo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
        notifyObservers();
    }
    
    public void addObservadores(IObserver observer){
        observadores.add(observer);
    }
    
    public void removeObservadores(IObserver observer){
        observadores.remove(observer);
    }
    
    public void notifyObservers(){
        for(int i = 0; i < observadores.size(); i++){
            observadores.get(i).update(ativo);
        }
    }
}
