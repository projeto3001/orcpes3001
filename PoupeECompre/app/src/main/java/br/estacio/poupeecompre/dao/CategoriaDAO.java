package br.estacio.poupeecompre.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

import br.estacio.poupeecompre.dominio.Categoria;

public class CategoriaDAO extends SQLiteOpenHelper {
    private static final String DATABASE = "PoupeCompre";
    private static final String TABLE = "Categoria";
    private static final int VERSION = 1;
    private Context context;


    public CategoriaDAO(Context context) {
        super(context, DATABASE, null, VERSION);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "CREATE TABLE " + TABLE +
                "(id INTEGER PRIMARY KEY, " +
                "descricao TEXT NOT NULL)";
        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    }

    public void insert(Categoria categoria) {
        ContentValues values = new ContentValues();
        values.put("nome", categoria.getDescricao());

        getWritableDatabase().insert(TABLE, null, values);
    }

    public void update(Categoria categoria) {
        ContentValues values = new ContentValues();
        values.put("descricao", categoria.getDescricao());

        String [] params = {categoria.getId().toString()};
        getWritableDatabase().update(TABLE, values, "id=?", params);
    }

    public List<Categoria> list() {
        List<Categoria> categorias = new ArrayList<Categoria>();
        Cursor c = getReadableDatabase()
                .rawQuery("SELECT * FROM " + TABLE + " ORDER BY id",null);

        while (c.moveToNext()) {
            Categoria categoria = new Categoria(c.getString(c.getColumnIndex("descricao")));
            categoria.setId(c.getLong(c.getColumnIndex("id")));
            categorias.add(categoria);
        }
        c.close();
        return categorias;
    }

    public void delete(Categoria categoria) {
        String [] params = {categoria.getId().toString()};
        getWritableDatabase().delete(TABLE, "id=?", params);
    }

    public Categoria buscarPorId(String id) {
        Cursor c = getReadableDatabase()
                .rawQuery("SELECT * FROM " + TABLE + " WHERE id = ", new String[]{id});
        Categoria categoria = new Categoria(c.getString(c.getColumnIndex("descricao")));
        categoria.setId(c.getLong(c.getColumnIndex("id")));
        return categoria;
    }
}
