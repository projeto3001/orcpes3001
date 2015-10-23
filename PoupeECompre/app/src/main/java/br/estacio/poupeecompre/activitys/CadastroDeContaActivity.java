package br.estacio.poupeecompre.activitys;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import br.estacio.poupeecompre.R;
import br.estacio.poupeecompre.dao.ContaDAO;

public class CadastroDeContaActivity extends AppCompatActivity {

    public void cadastrarDespesa(){
        EditText descricao, usuario, saldo;
        descricao = (EditText) findViewById(R.id.desc_conta);
        usuario = (EditText) findViewById(R.id.usuario_conta);
        saldo = (EditText) findViewById(R.id.saldo_conta);

        ContaDAO contaDAO = new ContaDAO(this);

    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro_de_conta);
        final Button cadastrar = (Button) findViewById(R.id.btnConta);
        cadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cadastrarDespesa();
            }
        });


    }

}
