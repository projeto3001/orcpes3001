package br.estacio.poupeecompre.helpers;

public class ValidadorDeCadastro extends Exception{
    private String usuario, email, senha1, senha2;

    public ValidadorDeCadastro comUsuario(String usuario){
        this.usuario = usuario;
        return this;
    }

    public ValidadorDeCadastro comEmail(String email){
        this.email = email;
        return this;
    }

    public ValidadorDeCadastro comSenha(String senha1, String senha2){
        this.senha1 = senha1;
        this.senha2 = senha2;
        return this;
    }

    public ValidadorDeCadastro() {}

}
