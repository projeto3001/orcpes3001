package br.estacio.poupeecompre.dominio;

import java.math.BigDecimal;

public class Conta extends EntidadeBase{
    private String descricao;
    private BigDecimal saldo;
    private Usuario usuario;

    private Conta(String descricao, BigDecimal saldo, Usuario usuario){
        super();
        this.descricao = descricao;
        this.saldo = saldo;
        this.usuario = usuario;
    }

    public static Conta criar(String descricao, BigDecimal saldo, Usuario usuario){
        return new Conta(descricao, saldo, usuario);
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public String getDescricao() {
        return descricao;
    }

    public BigDecimal getSaldo() {
        return saldo;
    }

}
