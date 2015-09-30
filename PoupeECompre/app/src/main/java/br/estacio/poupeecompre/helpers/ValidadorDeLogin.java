package br.estacio.poupeecompre.helpers;

public class ValidadorDeLogin {
    private String senhaInserida, senhaCorreta;

    public ValidadorDeLogin(String senhaInserida, String senhaCorreta){
        this.senhaInserida = senhaInserida;
        this.senhaCorreta = senhaCorreta;
    }

    public void validar() throws Exception {
        if(!senhaCorreta.equals(senhaInserida)){
            throw new Exception("Usuario ou senha incorretos");
        }
    }
}
