package br.estacio.poupeecompre.dao;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import br.estacio.poupeecompre.dominio.Conta;

/**
 * Created by kernelkill on 28/08/15.
 */
public class ContaDAO extends SQLiteOpenHelper {
    private static final String DATABASE = "PoupeCompre";
    private static final String TABLE = "Conta";
    private static final int VERSION = 1;

    public ContaDAO(Context context) {
        super(context, DATABASE, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "CREATE TABLE" + TABLE +
                "(id INTERGE PRIMARY KEY, " +
                "descricao TEXT," +
                "saldo NUMERIC NOT NULL," +
                "usuarioId INTERGE NOT NULL," +
                "FOREIGN KEY(usuarioId) REFERENCES Usuario(id))";
        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    public Conta buscarPorId(Long contaId){
        Conta conta = new Conta();




        return conta;
    }
}
