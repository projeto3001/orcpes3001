package br.estacio.poupeecompre.dominio;

import java.math.BigDecimal;

public class Conta extends EntidadeBase{
    private String descricao;
    private BigDecimal saldo;
    private Usuario usuario;

    private Conta(Long id, String descricao, BigDecimal saldo, Usuario usuario){
        super(id);
        this.descricao = descricao;
        this.saldo = saldo;
        this.usuario = usuario;
    }

    public static Conta criar(Long id, String descricao, BigDecimal saldo, Usuario usuario){
        return new Conta(id, descricao, saldo, usuario);
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
