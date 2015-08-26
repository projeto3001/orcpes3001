package br.estacio.poupeecompre.dominio;

import java.math.BigDecimal;
import java.util.Date;

public class Receita extends EntidadeBase{
    private Date data;
    private String descricao;
    private BigDecimal valor;
    private Conta conta;

    public Receita(Date data, String descricao, BigDecimal valor, Conta conta){
        super();
        this.data = data;
        this.descricao = descricao;
        this.valor = valor;
        this.conta = conta;
    }

    public Date getData(){
        return data;
    }

    public String getDescricao(){
        return  descricao;
    }

    public BigDecimal getValor(){
        return valor;
    }

    public Conta getConta(){
        return conta;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public void setConta(Conta conta) {
        this.conta = conta;
    }
}
