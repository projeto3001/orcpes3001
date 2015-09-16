package br.estacio.poupeecompre.activitys;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

import br.estacio.poupeecompre.R;
import br.estacio.poupeecompre.dao.UsuarioDAO;
import br.estacio.poupeecompre.dominio.Usuario;


public class CadastroDeUsuarioActivity extends ActionBarActivity {

    private void cadastrarUsuario(){
        EditText nomeDoUsuario, email, senha1, senha2;
        nomeDoUsuario = (EditText) findViewById(R.id.usuario);
        email = (EditText) findViewById(R.id.email);
        senha1 = (EditText) findViewById(R.id.senha1);
        senha2 = (EditText) findViewById(R.id.senha2);
        try{
            validarCamposObrigatorios(Arrays.asList(new String[]{nomeDoUsuario.getText().toString(), email.getText().toString(),
                    senha1.getText().toString(), senha2.getText().toString()}));
            validarSenhas(senha1.getText().toString(), senha2.getText().toString());
            Usuario usuario = new Usuario(email.getText().toString(), nomeDoUsuario.getText().toString(), senha1.getText().toString());
            UsuarioDAO usuarioDAO = new UsuarioDAO(this);
            usuarioDAO.insert(usuario);
            Intent login = new Intent(CadastroDeUsuarioActivity.this, LoginActivity.class);
            startActivity(login);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    private void validarSenhas(String senha1, String senha2) throws Exception {
        if(!senha1.equals(senha2)){
            throw new Exception("As senhas estão diferentes!");
        }
    }

    private void validarCamposObrigatorios(List<String> camposObrigatorios) throws Exception {
        for (String campo : camposObrigatorios){
            campo = campo.trim();
            if(campo == null || campo.equals("")){
                throw new Exception("Campo obrigatório esta vazio!");
            }
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cadastro_de_usuario);
        Button cadastrar = (Button) findViewById(R.id.cadastrarBtn);
        cadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cadastrarUsuario();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_cadastro_de_usuario, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}