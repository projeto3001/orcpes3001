package br.estacio.poupeecompre.dao;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DAO extends SQLiteOpenHelper {
    private static final String DATABASE = "PoupeCompre";
    private static final int VERSION = 1;

    public DAO(Context context) {
        super(context, DATABASE, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        criarTabelaCategoria(db);
        criarTabelaConta(db);
        criarTabelaDespesa(db);
        criarTabelaReceita(db);
        criarTabelaUsuario(db);
    }

    private void criarTabelaUsuario(SQLiteDatabase db) {
        String TABLE = "Usuario";
        String sql = "CREATE TABLE " + TABLE +
                "(id INTEGER PRIMARY KEY, " +
                "nome TEXT NOT NULL, " +
                "email TEXT NOT NULL UNIQUE, " +
                "senha TEXT NOT NULL)";
        db.execSQL(sql);
    }

    private void criarTabelaReceita(SQLiteDatabase db) {
        String TABLE = "Receita";
        String sql = "CREATE TABLE " + TABLE +
                "(id INTEGER PRIMARY KEY, " +
                "data TEXT NOT NULL, " +
                "descricao TEXT," +
                "valor NUMERIC NOT NULL," +
                "contaId INTEGER NOT NULL," +
                "FOREIGN KEY(contaId) REFERENCES Conta(id))";
        db.execSQL(sql);
    }

    private void criarTabelaDespesa(SQLiteDatabase db) {
        String TABLE = "Despesa";
        String sql = "CREATE TABLE " + TABLE +
                "(id INTEGER PRIMARY KEY, " +
                "descricao TEXT NOT NULL," +
                "data TEXT NOT NULL," +
                "valor NUMERIC NOT NULL," +
                "FOREIGN KEY(contaId) REFERENCES Conta(id))," +
                "FOREIGN KEY(categoriaId) REFERENCES Categoria(id)";
        db.execSQL(sql);
    }

    private void criarTabelaConta(SQLiteDatabase db) {
        String TABLE = "Conta";
        String sql = "CREATE TABLE " + TABLE +
                "(id INTEGER PRIMARY KEY, " +
                "descricao TEXT UNIQUE," +
                "saldo NUMERIC," +
                "FOREIGN KEY(usuarioId) REFERENCES Usuario(id))";
        db.execSQL(sql);
    }

    private void criarTabelaCategoria(SQLiteDatabase db) {
        String TABLE = "Categoria";
        String sql = "CREATE TABLE " + TABLE +
                "(id INTEGER PRIMARY KEY, " +
                "descricao TEXT NOT NULL UNIQUE)";
        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
