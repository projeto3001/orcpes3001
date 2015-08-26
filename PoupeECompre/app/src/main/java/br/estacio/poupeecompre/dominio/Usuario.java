package br.estacio.poupeecompre.dominio;

public class Usuario extends EntidadeBase{
    private String email;
    private String nome;
    private String senha;

    public Usuario(String email, String nome, String senha){
        super();
        this.email = email;
        this.nome = nome;
        this.senha = senha;
    }

    public String getEmail(){
        return email;
    }

    public String getNome(){
        return nome;
    }

    public String getSenha(){
        return senha;
    }
}