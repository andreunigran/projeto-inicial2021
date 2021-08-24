package br.unigran.aula;

import android.content.ComponentName;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.LinkedList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

private ListView lista;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lista=findViewById(R.id.lista);
        List dados = new LinkedList();
        dados.add("Maça");
        dados.add("Uva");
        dados.add("Pera");
        ArrayAdapter<String>adapter=
                new ArrayAdapter<>(this,R.layout.support_simple_spinner_dropdown_item,dados);
        lista.setAdapter(adapter);

    }
    public void novoProduto(View view){
        Intent it = new Intent(this,Segunda.class);
        startActivityForResult(it,0,null);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

       if(resultCode==RESULT_OK)
            Toast.makeText(this,"Salvo",Toast.LENGTH_SHORT).show();
        else
            Toast.makeText(this,"Saiu",Toast.LENGTH_SHORT).show();

    }


}