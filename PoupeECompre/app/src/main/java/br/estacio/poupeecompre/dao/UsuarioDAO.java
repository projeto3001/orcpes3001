package br.estacio.poupeecompre.dao;

import android.content.Context;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteConstraintException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

import br.estacio.poupeecompre.dominio.Usuario;
import br.estacio.poupeecompre.service.IUsuarioService;

public class UsuarioDAO extends SQLiteOpenHelper implements IUsuarioService{
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
                "email TEXT NOT NULL UNIQUE, " +
                "senha TEXT NOT NULL)";
        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    }

    public void insert(Usuario usuario) throws Exception {
        if(buscarPorEmail(usuario.getEmail()) == null){
            ContentValues values = new ContentValues();
            values.put("nome", usuario.getNome());
            values.put("email", usuario.getEmail());
            values.put("senha", usuario.getSenha());
            getWritableDatabase().insert(TABLE, null, values);
        }else{
            throw new Exception("Este email ja foi cadastrado");
        }
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
                .rawQuery("SELECT * FROM " + TABLE + " ORDER BY nome",null);

        while (c.moveToNext()) {
            Usuario usuario = new Usuario(c.getString(c.getColumnIndex("email")),
                    c.getString(c.getColumnIndex("nome")),
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

    public Usuario buscarPorId(String id) {
        Cursor c = getReadableDatabase()
                .rawQuery("SELECT * FROM " + TABLE + " WHERE id = ?", new String[]{id});
        Usuario usuario = null;
        if(c.moveToNext()) {
            usuario = new Usuario(c.getString(c.getColumnIndex("email")),
                    c.getString(c.getColumnIndex("nome")),
                    c.getString(c.getColumnIndex("senha")));
            usuario.setId(c.getLong(c.getColumnIndex("id")));
        }
        c.close();
        return usuario;
    }

    public Usuario buscarPorEmail(String email) {
        Cursor c = getReadableDatabase()
                .rawQuery("SELECT * FROM " + TABLE + " WHERE email = ?", new String[]{email});
        Usuario usuario = null;
        if(c.moveToNext()) {
            usuario = new Usuario(c.getString(c.getColumnIndex("email")),
                    c.getString(c.getColumnIndex("nome")),
                    c.getString(c.getColumnIndex("senha")));
            usuario.setId(c.getLong(c.getColumnIndex("id")));
        }
        c.close();
        return usuario;
    }
}
