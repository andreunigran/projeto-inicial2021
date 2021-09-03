package br.unigran.crud;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

import br.unigran.domain.Produto;

public class Dados {
    private static final List  dados = new LinkedList();
    private Dados(){
    }
    public static void salvar(Produto o){
        if(dados.contains(o)) {
            dados.set(dados.indexOf(o), o);
        }else{
            o.setId(dados.size()+1);
            dados.add(o);
        }
    }
    public static void salvar(Collection o){
        dados.addAll(o);
    }
    public static List getLista(){
       return dados;
    }

    public static void remove(int i) {
        dados.remove(i);
    }
}
