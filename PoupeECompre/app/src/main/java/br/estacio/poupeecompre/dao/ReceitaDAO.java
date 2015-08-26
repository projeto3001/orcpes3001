package br.estacio.poupeecompre.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import br.estacio.poupeecompre.dominio.Receita;

public class ReceitaDAO extends SQLiteOpenHelper {
    private static final String DATABASE = "PoupeCompre";
    private static final String TABLE = "Receita";
    private static final int VERSION = 1;

    public ReceitaDAO(Context context) {
        super(context, DATABASE, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public void insert(Receita receita) {
        ContentValues values = new ContentValues();
        values.put("data", String.valueOf(receita.getData()));
        values.put("descricao", receita.getDescricao());
        values.put("valor", receita.getValor().doubleValue());
        values.put("contaId", receita.getConta().getId());

        getWritableDatabase().insert(TABLE, null, values);
    }
}
