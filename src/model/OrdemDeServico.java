package model;

import java.util.Date;

public class OrdemDeServico {
    private int id;
    private String cliente;
    private String telefone;
    private String modelo;
    private String problema;
    private Date dataRecebimento;
    private Date dataEntrega;
    private double valor;

    // Getters e Setters

    @Override
    public String toString() {
        return "OrdemDeServico{" +
                "id=" + id +
                ", cliente='" + cliente + '\'' +
                ", telefone='" + telefone + '\'' +
                ", modelo='" + modelo + '\'' +
                ", problema='" + problema + '\'' +
                ", dataRecebimento=" + dataRecebimento +
                ", dataEntrega=" + dataEntrega +
                ", valor=" + valor +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getProblema() {
        return problema;
    }

    public void setProblema(String problema) {
        this.problema = problema;
    }

    public Date getDataRecebimento() {
        return dataRecebimento;
    }

    public void setDataRecebimento(Date dataRecebimento) {
        this.dataRecebimento = dataRecebimento;
    }

    public Date getDataEntrega() {
        return dataEntrega;
    }

    public void setDataEntrega(Date dataEntrega) {
        this.dataEntrega = dataEntrega;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }
}
