package br.estacio.poupeecompre.dominio;

import java.math.BigDecimal;
import java.util.Date;

public class Despesa extends EntidadeBase{
    private String descricao;
    private Date data;
    private BigDecimal valor;
    private Conta conta;
    private Categoria categoria;

    private Despesa(String descricao, Date data, BigDecimal valor, Conta conta, Categoria categoria){
        super();
        this.descricao = descricao;
        this.data = data;
        this.valor = valor;
        this.conta = conta;
        this.categoria = categoria;
    }

    public static Despesa criar(String descricao, Date data, BigDecimal valor, Conta conta, Categoria categoria){
        return new Despesa(descricao, data, valor, conta, categoria);
    }

    public String getDescricao() {
        return descricao;
    }

    public Date getData() {
        return data;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public Conta getConta() {
        return conta;
    }

    public Categoria getCategoria() {
        return categoria;
    }
}
