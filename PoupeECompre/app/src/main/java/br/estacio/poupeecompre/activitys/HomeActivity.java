package br.estacio.poupeecompre.activitys;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import br.estacio.poupeecompre.R;

public class HomeActivity extends AppCompatActivity {

    private void registrarEventos(Button despesas, Button receitas, Button categoria, Button conta) {
        despesas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent despesasActivity = new Intent(HomeActivity.this, CadastroDeDespesaActivity.class);
                startActivity(despesasActivity);
            }
        });

        receitas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent receitasActivity = new Intent(HomeActivity.this, CasdastroDeReceitasActivity.class);
                startActivity(receitasActivity);
            }
        });

        categoria.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent categoriaActivity = new Intent(HomeActivity.this, CadastroDeCategoriaActivity.class);
                startActivity(categoriaActivity);
            }
        });

        conta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent contaActivity = new Intent(HomeActivity.this, CadastroDeContaActivity.class);
                startActivity(contaActivity);
            }
        });

    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //Verifcar se esta logado, se nao estiver chama a tela de login

        setContentView(R.layout.activity_home);
        Button despesas = (Button) findViewById(R.id.despesasBtn);

        Button receitas = (Button) findViewById(R.id.receitasBtn);

        Button categoria = (Button) findViewById(R.id.categoriasBtn);

        Button conta = (Button) findViewById(R.id.contasBtn);

        registrarEventos(despesas, receitas, categoria, conta);

        Button sair = (Button) findViewById(R.id.sairBtn);
        sair.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_home, menu);
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
