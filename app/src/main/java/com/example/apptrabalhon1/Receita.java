package com.example.apptrabalhon1;

public class Receita {

    public int id;
    public String nome;
    public int tempo;
    public String dificuldade;
    public String ingredientes;
    public String modo;

    public Receita() {

    }

    public Receita(String nome, int tempo, String dificuldade, String ingredientes, String modo) {
        this.nome = nome;
        this.setTempo(tempo);
        this.dificuldade = dificuldade;
        this.ingredientes = ingredientes;
        this.modo = modo;

    }

    public Receita(int id,  int tempo, String dificuldade, String ingredientes, String modo) {
        this.id = id;
        this.nome = nome;
        this.setTempo(tempo);
        this.dificuldade = dificuldade;
        this.ingredientes = ingredientes;
        this.modo = modo;

    }

    public void setTempo(int tempo) {
          this.tempo = tempo;
    }

    public int getTempo() {
        return tempo;
    }

    public String getDificuldade(){
        return dificuldade;
    }

    public void setDificuldade(String dificuldade){
        this.dificuldade = dificuldade;
    }

    public String getIngredientes(){
        return dificuldade;
    }

    public void setIngredientes(String ingredientes){
        this.ingredientes = ingredientes;
    }

    public String getModo() {return modo ;}

    public void setModo(String modo) {this.modo = modo;}

    @Override
    public String toString() {
        return id + " - " + nome + " | " + tempo + "|" + dificuldade + "|" + ingredientes + "|" + modo;
    }
}
