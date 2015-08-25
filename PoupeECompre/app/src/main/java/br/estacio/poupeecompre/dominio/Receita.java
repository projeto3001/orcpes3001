package br.estacio.poupeecompre.dominio;

import java.math.BigDecimal;
import java.util.Date;

public class Receita extends EntidadeBase{
    private Date data;
    private String descricao;
    private BigDecimal valor;

    private Receita(Long id, Date data, String descricao, BigDecimal valor){
        super(id);
        this.data = data;
        this.descricao = descricao;
        this.valor = valor;
    }

    public static Receita criar(Long id, Date data, String descricao, BigDecimal valor){
       return new Receita(id, data, descricao, valor);
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
}
