package br.estacio.poupeecompre.activitys;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import br.estacio.poupeecompre.R;
import br.estacio.poupeecompre.dominio.Categoria;
import br.estacio.poupeecompre.service.CategoriaService;


public class CadastroDeCategoriaActivity extends AppCompatActivity {

    private void cadastrar(){
        EditText descricao = (EditText) findViewById(R.id.desc_categoria);
        CategoriaService categoriaService = new CategoriaService(this);
        Categoria categoria = new Categoria(descricao.getText().toString());
        try{
            System.out.println("Inserindo categoria..........");
            categoriaService.insert(categoria);
            finish();
        }catch (Exception e){
            Toast.makeText(this, e.getMessage(), Toast.LENGTH_LONG);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro_de_categoria);
        final Button cadastrar = (Button) findViewById(R.id.btnCategoria);

        cadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cadastrar();
            }

        });

    }

}
