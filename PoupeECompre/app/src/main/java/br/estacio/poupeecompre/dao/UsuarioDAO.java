package br.estacio.poupeecompre.dao;

import android.content.Context;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

import br.estacio.poupeecompre.dominio.Usuario;

public class UsuarioDAO extends SQLiteOpenHelper {
    private static final String DATABASE = "PoupeCompre";
    private static final String TABLE = "Usuario";
    private static final int VERSION = 1;

    public UsuarioDAO(Context context) {
        super(context, DATABASE, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "CREATE TABLE " + TABLE +
                "(id INTEGER PRIMARY KEY, " +
                "nome TEXT NOT NULL, " +
                "email TEXT NOT NULL " +
                "senha TEXT NOT NULL)";
        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    }

    public void insert(Usuario usuario) {
        ContentValues values = new ContentValues();
        values.put("nome", usuario.getNome());
        values.put("email", usuario.getEmail());
        values.put("senha", usuario.getSenha());

        getWritableDatabase().insert(TABLE, null, values);
    }

    public void update(Usuario usuario) {
        ContentValues values = new ContentValues();
        values.put("nome", usuario.getNome());
        values.put("email", usuario.getEmail());
        values.put("senha", usuario.getSenha());

        String [] params = {usuario.getId().toString()};
        getWritableDatabase().update(TABLE, values, "id=?", params);
    }

    public List<Usuario> list() {
        List<Usuario> usuarios = new ArrayList<Usuario>();
        Cursor c = getReadableDatabase()
                .rawQuery("SELECT * FROM " + TABLE + " ORDER BY NOME",null);

        while (c.moveToNext()) {
            Usuario usuario = new Usuario(c.getString(c.getColumnIndex("nome")),
                    c.getString(c.getColumnIndex("email")),
                    c.getString(c.getColumnIndex("senha")));

            usuario.setId(c.getLong(c.getColumnIndex("id")));

            usuarios.add(usuario);
        }
        c.close();
        return usuarios;
    }

    public void delete(Usuario usuario) {
        String [] params = {usuario.getId().toString()};
        getWritableDatabase().delete(TABLE, "id=?", params);
    }
}
