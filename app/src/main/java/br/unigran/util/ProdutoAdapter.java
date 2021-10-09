package br.unigran.util;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import br.unigran.aula.R;
import br.unigran.domain.Produto;

public class ProdutoAdapter extends RecyclerView.Adapter<ProdutoAdapter.ProdutoViewHolder> {

    private List<Produto> dados;
    public ProdutoAdapter(List dados){
        this.dados=dados;
    }
    @NonNull
    @Override
    public ProdutoViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater layoutInflater = LayoutInflater.from(viewGroup.getContext());
        View view = layoutInflater.inflate(R.layout.linha,viewGroup,false);
        ProdutoViewHolder produtoViewHolder = new ProdutoViewHolder(view);
        return produtoViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ProdutoViewHolder produtoViewHolder, int i) {
        Produto produto = dados.get(i);
        produtoViewHolder.nomelinha.setText(produto.getNome());
    }

    @Override
    public int getItemCount() {
        return dados.size();
    }

    public class ProdutoViewHolder extends RecyclerView.ViewHolder {
        private TextView nomelinha;
        private Button botao;
        public ProdutoViewHolder(@NonNull View itemView) {
            super(itemView);
            nomelinha=itemView.findViewById(R.id.nomeLinha);
            botao=itemView.findViewById(R.id.btnLinha);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Toast.makeText(itemView.getContext(),"Olá",Toast.LENGTH_SHORT).show();
                }
            });
            nomelinha.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    //acao
                }
            });
            botao.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    //Acai
                }
            });
        }
    }
}
