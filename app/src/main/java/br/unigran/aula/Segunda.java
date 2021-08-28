package br.unigran.aula;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import br.unigran.crud.Dados;
import br.unigran.domain.Produto;

public class Segunda extends AppCompatActivity {

    private EditText nomeProd;
    private EditText quantidade;
    Produto produto;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_segunda);
        nomeProd=findViewById(R.id.nomeProduto);
        quantidade=findViewById(R.id.qtdProduto);
        Intent it = getIntent();

        /*nomeProd.setText(it.getStringExtra("nome"));
        quantidade.setText(it.getIntExtra("quantidade",0));*/

        if(it.getSerializableExtra("Produto")!=null){
            produto= (Produto) it.getSerializableExtra("Produto");
            nomeProd.setText(produto.getNome());
            quantidade.setText(produto.getQuantidade().toString());
        }

    }
    public void cancelar(View view){
        setResult(RESULT_CANCELED);
        finish();
    }
    public void salvar(View view){
       if(produto==null)
        produto = new Produto();

       produto.setNome(nomeProd.getText().toString());
       produto.setQuantidade(Integer.parseInt(quantidade.getText().toString()));

        Dados.salvar(produto);
        setResult(RESULT_OK);
        finish();
    }
}