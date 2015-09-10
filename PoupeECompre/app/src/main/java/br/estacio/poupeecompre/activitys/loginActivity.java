package br.estacio.poupeecompre.activitys;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import br.estacio.poupeecompre.R;


public class LoginActivity extends ActionBarActivity {

    private void entrar(){
        //TODO: implementar o login
        System.out.println("A fazer...");
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
