package br.estacio.poupeecompre.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

import br.estacio.poupeecompre.dominio.Categoria;
import br.estacio.poupeecompre.service.ICategoriaService;

public class CategoriaDAO extends DAO implements ICategoriaService{
    private static final String TABLE = "Categoria";


    public CategoriaDAO(Context context) {
        super(context);
    }

    public void insert(Categoria categoria) throws Exception{
        ContentValues values = new ContentValues();
        values.put("descricao", categoria.getDescricao());
        if(buscarPorDescricao(categoria.getDescricao()) != null) {
            getWritableDatabase().insert(TABLE, null, values);
        }else{
            throw new Exception("Categoria ja existe");
        }
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
        Categoria categoria = null;
        if(c.moveToNext()) {
            categoria = new Categoria(c.getString(c.getColumnIndex("descricao")));
            categoria.setId(c.getLong(c.getColumnIndex("id")));
        }
        c.close();
        return categoria;
    }

    public Categoria buscarPorDescricao(String descricao) {
        Cursor c = getReadableDatabase()
                .rawQuery("SELECT * FROM " + TABLE + " WHERE descricao = ?", new String[]{descricao});
        Categoria categoria = null;
        if(c.moveToNext()) {
            categoria = new Categoria(c.getString(c.getColumnIndex("descricao")));
            categoria.setId(c.getLong(c.getColumnIndex("id")));
        }
        c.close();

        return categoria;
    }
}
