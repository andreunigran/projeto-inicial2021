package br.unigran.aula;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import br.unigran.domain.Produto;

public class Segunda extends AppCompatActivity {

    private EditText nomeProd;
    private EditText quantidade;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_segunda);
        nomeProd=findViewById(R.id.nomeProduto);
        quantidade=findViewById(R.id.qtdProduto);
    }
    public void cancelar(View view){
        setResult(RESULT_CANCELED);
        finish();
    }
    public void salvar(View view){
        Produto produto = new Produto();
        produto.setNome(nomeProd.getText().toString());
        produto.setQuantidade(Integer.parseInt(quantidade.getText()+""));
        setResult(RESULT_OK);
        finish();
    }
}