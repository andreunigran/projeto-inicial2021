package br.unigran.crud;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

public class Dados {
    private static List  dados = new LinkedList();
    private Dados(){
    }
    public static void salvar(Object o){
        dados.add(o);
    }
    public static void salvar(Collection o){
        dados.addAll(o);
    }
    public static List getLista(){
       return dados;
    }
}