package org.example.model;

public class Agendamento {
    private int id;
    private String data;
    private String hora;
    private String local;
    private String detalhes;

    public Agendamento(int id, String data, String hora, String local, String detalhes) {
        this.id = id;
        this.data = data;
        this.hora = hora;
        this.local = local;
        this.detalhes = detalhes;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
    }

    public String getDetalhes() {
        return detalhes;
    }

    public void setDetalhes(String detalhes) {
        this.detalhes = detalhes;
    }
}

