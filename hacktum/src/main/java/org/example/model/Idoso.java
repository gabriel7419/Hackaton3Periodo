package org.example.model;

public class Idoso {
    private int id;
    private String nome;
    private String cpf;
    private String cartaoSus;
    private String cep;
    private String logradouro;
    private String dataNascimento;
    private String nomeResponsavel;
    private String cpfResponsavel;
    private String emailResponsavel;
    private String celular1;
    private String celular2;
    private String celular3;
    private String senha;


    public Idoso(int id, String nome, String cpf, String cartaoSus, String cep, String logradouro, String dataNascimento, String nomeResponsavel, String cpfResponsavel, String emailResponsavel, String celular1, String celular2, String celular3, String senha) {
        this.id = id;
        this.nome = nome;
        this.cpf = cpf;
        this.cartaoSus = cartaoSus;
        this.cep = cep;
        this.logradouro = logradouro;
        this.dataNascimento = dataNascimento;
        this.nomeResponsavel = nomeResponsavel;
        this.cpfResponsavel = cpfResponsavel;
        this.emailResponsavel = emailResponsavel;
        this.celular1 = celular1;
        this.celular2 = celular2;
        this.celular3 = celular3;
        this.senha = senha;
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

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getCartaoSus() {
        return cartaoSus;
    }

    public void setCartaoSus(String cartaoSus) {
        this.cartaoSus = cartaoSus;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public String getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(String dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getNomeResponsavel() {
        return nomeResponsavel;
    }

    public void setNomeResponsavel(String nomeResponsavel) {
        this.nomeResponsavel = nomeResponsavel;
    }

    public String getCpfResponsavel() {
        return cpfResponsavel;
    }

    public void setCpfResponsavel(String cpfResponsavel) {
        this.cpfResponsavel = cpfResponsavel;
    }

    public String getEmailResponsavel() {
        return emailResponsavel;
    }

    public void setEmailResponsavel(String emailResponsavel) {
        this.emailResponsavel = emailResponsavel;
    }

    public String getCelular1() {
        return celular1;
    }

    public void setCelular1(String celular1) {
        this.celular1 = celular1;
    }

    public String getCelular2() {
        return celular2;
    }

    public void setCelular2(String celular2) {
        this.celular2 = celular2;
    }

    public String getCelular3() {
        return celular3;
    }

    public void setCelular3(String celular3) {
        this.celular3 = celular3;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
}
