package br.estacio.poupeecompre.helpers;

public class ValidadorDeCadastro{
    private String erroDeCadastro;
    private String usuario, email, senha1, senha2;

    public ValidadorDeCadastro(String usuario,String email,String senha1,String senha2) {
        this.usuario = usuario;
        this.email = email;
        this.senha1 = senha1;
        this.senha2 = senha2;
        this.erroDeCadastro = "";
    }

    private void paraUsuario(){
        String usuarioInserido = usuario.trim();
        if(usuarioInserido == null || usuarioInserido.equals("")){
            erroDeCadastro += "Informe um nome de usuario\n";
        }
    }

    private void paraEmail(){
        String emailInserido = email.trim();
        if(emailInserido == null || emailInserido.equals("")){
            erroDeCadastro += "Informe um email\n";
        }
    }

    private void paraSenha(){
        if(!senha1.equals(senha2) || (senha1.isEmpty() || senha2.isEmpty())){
            erroDeCadastro += "Senhas diferentes inseridas\n";
        }
    }

    public void validar() throws Exception {
        paraUsuario();
        paraEmail();
        paraSenha();
        if(!erroDeCadastro.isEmpty()){
            throw new Exception(erroDeCadastro);
        }
    }
}
