package org.example.model;

public class Vacina {
    private int id;
    private String nome;
    private String dataInicio;
    private String dataTermino;
    private String publicoAlvo;

    public Vacina(int id, String nome, String dataInicio, String dataTermino, String publicoAlvo) {
        this.id = id;
        this.nome = nome;
        this.dataInicio = dataInicio;
        this.dataTermino = dataTermino;
        this.publicoAlvo = publicoAlvo;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(String dataInicio) {
        this.dataInicio = dataInicio;
    }

    public String getDataTermino() {
        return dataTermino;
    }

    public void setDataTermino(String dataTermino) {
        this.dataTermino = dataTermino;
    }

    public String getPublicoAlvo() {
        return publicoAlvo;
    }

    public void setPublicoAlvo(String publicoAlvo) {
        this.publicoAlvo = publicoAlvo;
    }
}
