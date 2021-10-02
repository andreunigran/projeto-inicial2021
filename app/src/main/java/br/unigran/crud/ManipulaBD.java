package br.unigran.crud;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.LinkedList;
import java.util.List;

import br.unigran.domain.Produto;

public class ManipulaBD {
    private final Context context;

    public ManipulaBD(Context context) {
        this.context = context;
    }

    public Long insere(Produto produto) {
        CriaBD criaBD = new CriaBD(context);
        SQLiteDatabase database = criaBD.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("nome", produto.getNome());
        contentValues.put("quantidade", produto.getQuantidade());
        return database.insertOrThrow("produto", null, contentValues);
    }

    public List<Produto> getProdutos() {
        List<Produto> retorno = new LinkedList<>();
        CriaBD criaBD = new CriaBD(context);
        SQLiteDatabase database = criaBD.getReadableDatabase();
        Cursor cursor = database.query("produto", new String[]{"nome", "quantidade"},
                null, null,
                null, null, null, null);
        if (cursor.moveToFirst()) {
            do {
                Produto p = new Produto();
                p.setNome(cursor.getString(0));
                p.setQuantidade(cursor.getInt(1));
                retorno.add(p);
            } while (cursor.moveToNext());
        }

    return retorno;
    }


}
