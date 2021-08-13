package br.unigran.aula;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText nome;
    Button btnOk;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        nome=findViewById(R.id.campoNome);
        btnOk = findViewById(R.id.btnOk);
        btnOk.setOnClickListener(view -> Toast.makeText(getApplicationContext(),"Olá "+nome.getText(),Toast.LENGTH_LONG).show());

    }
    public void limpar(View view){
        nome.setText("");
        Toast.makeText(this,"Limpo",Toast.LENGTH_LONG).show();
    }
}