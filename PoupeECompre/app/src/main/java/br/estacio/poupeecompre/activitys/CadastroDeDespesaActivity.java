package br.estacio.poupeecompre.activitys;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.math.BigDecimal;
import java.util.Date;

import br.estacio.poupeecompre.R;
import br.estacio.poupeecompre.dao.CategoriaDAO;
import br.estacio.poupeecompre.dao.ContaDAO;
import br.estacio.poupeecompre.dao.DespesaDAO;
import br.estacio.poupeecompre.dominio.Categoria;
import br.estacio.poupeecompre.dominio.Conta;
import br.estacio.poupeecompre.dominio.Despesa;

public class CadastroDeDespesaActivity extends AppCompatActivity {


    private void cadastrarDespesa(){
        EditText descricao, categoriaCampo, contaCampo, valor, dataCampo;
        descricao = (EditText) findViewById(R.id.descricao);
        categoriaCampo = (EditText) findViewById(R.id.categoria);
        contaCampo = (EditText) findViewById(R.id.conta);
        valor = (EditText) findViewById(R.id.valor);
        dataCampo = (EditText) findViewById(R.id.data);
        try {
            ContaDAO contaDAO = new ContaDAO(this);
            Conta conta = contaDAO.buscarPorDescricao(contaCampo.getText().toString());
            CategoriaDAO categoriaDAO = new CategoriaDAO(this);
            Categoria categoria = categoriaDAO.buscarPorDescricao(categoriaCampo.getText().toString());
            Date data = new Date(dataCampo.getText().toString());
            DespesaDAO despesaDAO = new DespesaDAO(this);
            Despesa despesa = new Despesa(descricao.getText().toString(),data, BigDecimal.valueOf(Double.parseDouble(valor.getText().toString())),conta, categoria);
            despesaDAO.insert(despesa);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }

    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cadastro_de_despesa);
        Button cadastrar  = (Button) findViewById(R.id.despesaBtn);
        cadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cadastrarDespesa();
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_cadastro_de_despesa, menu);
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
