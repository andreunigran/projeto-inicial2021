package br.unigran.crud;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.provider.ContactsContract;
import android.support.annotation.Nullable;

public class CriaBD extends SQLiteOpenHelper {
    public CriaBD(Context context){
     super(context,"Aula001",null,1);
    }
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("CREATE TABLE produto (" +
                "    id         INTEGER        PRIMARY KEY AUTOINCREMENT," +
                "    nome       VARCHAR (50)," +
                "    quantidade INTEGER," +
                "    valor      NUMERIC (4, 2)," +
                "    imagem     BLOB (10000) " +
                ");");
    }
    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("");
    }
}
