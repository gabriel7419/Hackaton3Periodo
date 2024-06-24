package org.example.model;

public class HorarioDisponivel {
    private int id;
    private String dataHora;
    private boolean disponivel;

    public HorarioDisponivel(int id, String dataHora, boolean disponivel) {
        this.id = id;
        this.dataHora = dataHora;
        this.disponivel = disponivel;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDataHora() {
        return dataHora;
    }

    public void setDataHora(String dataHora) {
        this.dataHora = dataHora;
    }

    public boolean isDisponivel() {
        return disponivel;
    }

    public void setDisponivel(boolean disponivel) {
        this.disponivel = disponivel;
    }
}
