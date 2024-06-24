package org.example.model;

public class Historico {
    private int id;
    private String nome;
    private boolean febre;
    private boolean dorCabeca;
    private boolean tosse;
    private String vacina;
    private float peso;
    private float altura;
    private String alergias;
    private String medico;

    public Historico(int id, String nome, boolean febre, boolean dorCabeca, boolean tosse, String vacina, float peso, float altura, String alergias, String medico) {
        this.id = id;
        this.nome = nome;
        this.febre = febre;
        this.dorCabeca = dorCabeca;
        this.tosse = tosse;
        this.vacina = vacina;
        this.peso = peso;
        this.altura = altura;
        this.alergias = alergias;
        this.medico = medico;
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public boolean isFebre() {
        return febre;
    }

    public boolean isDorCabeca() {
        return dorCabeca;
    }

    public boolean isTosse() {
        return tosse;
    }

    public String getVacina() {
        return vacina;
    }

    public float getPeso() {
        return peso;
    }

    public float getAltura() {
        return altura;
    }

    public String getAlergias() {
        return alergias;
    }

    public String getMedico() {
        return medico;
    }
}
