package br.estacio.poupeecompre.dominio;

public class Usuario extends EntidadeBase{
    private String email;
    private String nome;
    private String senha;

    private Usuario(String email, String nome, String senha){
        super();
        this.email = email;
        this.nome = nome;
        this.senha = senha;
    }

    public static Usuario criar(Long id, String email, String nome, String senha){
        return new Usuario(email, nome, senha);
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