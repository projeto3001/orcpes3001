package br.estacio.poupeecompre.activitys;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import br.estacio.poupeecompre.R;
import br.estacio.poupeecompre.dao.DAO;
import br.estacio.poupeecompre.dominio.Usuario;
import br.estacio.poupeecompre.helpers.ValidadorDeLogin;
import br.estacio.poupeecompre.service.UsuarioService;


public class LoginActivity extends ActionBarActivity {

    private void entrar(){
        EditText nomeDeUsuario, senha;
        nomeDeUsuario = (EditText) findViewById(R.id.nomeUsuario);
        senha = (EditText) findViewById(R.id.senha);
        try{
            UsuarioService usuarioService = new UsuarioService(this);
            Usuario usuario = usuarioService.buscarPorEmail(nomeDeUsuario.getText().toString());
            if (usuario == null) {
                Toast.makeText(this, "Usuário não encontrado!!", Toast.LENGTH_LONG).show();
            }
            else {
                ValidadorDeLogin validadorDeLogin = new ValidadorDeLogin(senha.getText().toString(), usuario.getSenha());
                validadorDeLogin.validar();
                Intent home = new Intent(LoginActivity.this, HomeActivity.class);
                startActivity(home);
            }
        }catch(Exception e){
            Toast.makeText(this, e.getMessage(), Toast.LENGTH_LONG).show();
        }
    }

    private void casdastrarUsuario(){
        Intent cadastroDeUsuario = new Intent(LoginActivity.this, CadastroDeUsuarioActivity.class);
        startActivity(cadastroDeUsuario);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
        Button entrar, criarUsuario;

        entrar = (Button) findViewById(R.id.entrarBtn);
        criarUsuario = (Button) findViewById(R.id.criarUsuarioBtn);

        entrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                entrar();
            }
        });

        criarUsuario.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                casdastrarUsuario();
            }
        });

        criarAdmin();
    }

    private void criarAdmin() {
        Usuario admin = new Usuario("admin", "admin", "123");
        UsuarioService usuarioService = new UsuarioService(this);
        try{
            usuarioService.insert(admin);
        }catch (Exception e){
            System.out.println("!!!Admin ja havia sido cadastrado!!!");
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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
