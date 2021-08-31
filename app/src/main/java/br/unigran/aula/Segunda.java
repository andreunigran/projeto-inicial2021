package br.unigran.aula;

import android.content.Intent;
import android.graphics.Bitmap;
import android.hardware.camera2.CameraMetadata;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import br.unigran.crud.Dados;
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
              foto.setImageBitmap(produto.getImagem());
        }else{
                produto = new Produto();

        }

    }
    public void cancelar(View view){
        setResult(RESULT_CANCELED);
        finish();
    }
    public void salvar(View view){

       produto.setNome(nomeProd.getText().toString());
       produto.setQuantidade(Integer.parseInt(quantidade.getText().toString()));
        Dados.salvar(produto);
        setResult(RESULT_OK);
        finish();
    }

    public void capturaImg(View view){
        Intent it = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
       if(it.resolveActivity(getPackageManager())!=null)
            startActivityForResult(it, CameraMetadata.REQUEST_AVAILABLE_CAPABILITIES_BACKWARD_COMPATIBLE);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==CameraMetadata.REQUEST_AVAILABLE_CAPABILITIES_BACKWARD_COMPATIBLE){
            if(resultCode==RESULT_OK){
                Bitmap img= (Bitmap) data.getExtras().get("data");
                produto.setImagem(img);
                foto.setImageBitmap(img);


           }

        }
    }
}