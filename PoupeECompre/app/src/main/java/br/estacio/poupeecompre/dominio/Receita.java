package br.estacio.poupeecompre.dominio;

import java.math.BigDecimal;
import java.util.Date;

public class Receita extends EntidadeBase{
    private Date data;
    private String descricao;
    private BigDecimal valor;
    private Conta conta;

    private Receita(Long id, Date data, String descricao, BigDecimal valor, Conta conta){
        super(id);
        this.data = data;
        this.descricao = descricao;
        this.valor = valor;
        this.conta = conta;
    }

    public static Receita criar(Long id, Date data, String descricao, BigDecimal valor, Conta conta){
       return new Receita(id, data, descricao, valor, conta);
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
}
