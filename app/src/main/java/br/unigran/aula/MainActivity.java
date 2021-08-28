package br.unigran.aula;

import android.content.ComponentName;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.LinkedList;
import java.util.List;

import br.unigran.crud.Dados;
import br.unigran.domain.Produto;

public class MainActivity extends AppCompatActivity {
    private ListView lista;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lista= findViewById(R.id.lista);
     atualiza();

        lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
               Intent it = new Intent(getApplicationContext(),Segunda.class);
               it.putExtra("Produto", (Produto)Dados.getLista().get(i));

                Produto o=(Produto)Dados.getLista().get(i);
               /* it.putExtra("nome",o.getNome());
                it.putExtra("quatidade",o.getQuantidade());*/
                startActivityForResult(it,201);
            }
        });

        lista.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                Dados.remove(i);

                atualiza();
                return true;
            }
        });
    }

    private void atualiza() {
        ArrayAdapter<String> adapter =
                new ArrayAdapter<>(this, R.layout.support_simple_spinner_dropdown_item,
                        Dados.getLista());
        lista.setAdapter(adapter);
    }

    public void novoProduto(View view) {
        Intent it = new Intent(this, Segunda.class);
        startActivityForResult(it, 201, null);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 201)
            if (resultCode == RESULT_OK) {
                Toast.makeText(this, "Salvo " , Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "Saiu", Toast.LENGTH_SHORT).show();
            }

    }


}