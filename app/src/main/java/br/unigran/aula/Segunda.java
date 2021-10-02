package br.unigran.aula;

import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.hardware.camera2.CameraMetadata;
import android.net.Uri;
import android.os.PatternMatcher;
import android.provider.ContactsContract;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;
import java.util.regex.Pattern;

import br.unigran.crud.Dados;
import br.unigran.crud.ManipulaBD;
import br.unigran.domain.Produto;

public class Segunda extends AppCompatActivity {

    private EditText nomeProd;
    private EditText quantidade;
    private ImageView foto;
    Produto produto;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_segunda);
        nomeProd=findViewById(R.id.nomeProduto);
        quantidade=findViewById(R.id.qtdProduto);
        foto=findViewById(R.id.imagem);
        Intent it = getIntent();

        /*nomeProd.setText(it.getStringExtra("nome"));
        quantidade.setText(it.getIntExtra("quantidade",0));*/

        if(it.getSerializableExtra("Produto")!=null){
            produto= (Produto) it.getSerializableExtra("Produto");
            nomeProd.setText(produto.getNome());
            quantidade.setText(produto.getQuantidade().toString());
            if(produto.getImagem()!=null)
              foto.setImageBitmap(BitmapFactory.
                      decodeByteArray(produto.getImagem(),0,produto.getImagem().length));
        }else{
                produto = new Produto();

        }

    }
    public void cancelar(View view){
        setResult(RESULT_CANCELED);
        //finish();
        onBackPressed();
    }
    public void salvar(View view){

       produto.setNome(nomeProd.getText().toString());
       produto.setQuantidade(Integer.parseInt(quantidade.getText().toString()));
      //  if(produto.getNome()!=null&&produto.getNome().trim().isEmpty())
        if(!TextUtils.isEmpty(produto.getNome())
        &&Pattern.matches("[a-z]{10}",produto.getNome())){
            //Dados.salvar(produto);
            ManipulaBD db = new ManipulaBD(getApplicationContext());
            db.insere(produto);
            setResult(RESULT_OK);
            finish();
            onBackPressed();
        }else{
            Toast.makeText(this,"Erro",Toast.LENGTH_SHORT).show();
        }
    }

    public void capturaImg(View view){
        Intent contatos = new Intent(Intent.ACTION_PICK); //CHAMANDO UMA ACTIVITY COM A CONSTANTE DE ESCOLHER UM DADO A SER RETORNADO
        contatos.setType(ContactsContract.CommonDataKinds.Phone.CONTENT_TYPE); //SELECIONANDO O CONTEUDO UTILIZANDO A CONTACTS PROVIDER

        //VALIDANDO
        if (contatos.resolveActivity(getPackageManager()) != null){
            //CHAMO OS CONTATOS
            startActivityForResult(contatos, 1);

        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==CameraMetadata.REQUEST_AVAILABLE_CAPABILITIES_BACKWARD_COMPATIBLE) {
            if (resultCode == RESULT_OK) {
                Bitmap img = (Bitmap) data.getExtras().get("data");

                ByteArrayOutputStream stream = new ByteArrayOutputStream();
                img.compress(Bitmap.CompressFormat.PNG, 100, stream);
                produto.setImagem(stream.toByteArray());
                foto.setImageBitmap(img);


            }
        }
            if(requestCode==1 && resultCode==RESULT_OK){
                Uri uri = data.getData();
                String[] projecao = {ContactsContract.CommonDataKinds.Phone.NUMBER,
                        ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME};



                Cursor cursor = getContentResolver().query(uri, projecao, null, null, null);

                //SE O CURSOR RETORNAR UM VALOR VALIDO ENTÃO PEGA O NUMERO
                if (cursor != null && cursor.moveToFirst()) {
                    produto.setNome(cursor.getString(0));
                    produto.setNome(cursor.getString(1));
                    nomeProd.setText(produto.getNome());
                    //   Toast.makeText(Segunda.this, numero, Toast.LENGTH_LONG).show();
                }


            }

    }
}