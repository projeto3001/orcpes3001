package br.estacio.poupeecompre.dao;

<<<<<<< HEAD
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import br.estacio.poupeecompre.dominio.Conta;

/**
 * Created by kernelkill on 28/08/15.
 */
=======
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.math.BigDecimal;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import br.estacio.poupeecompre.dominio.Conta;
import br.estacio.poupeecompre.dominio.Usuario;

>>>>>>> 4ed497f37812f07ed72730d4b1790c5a6b5d32db
public class ContaDAO extends SQLiteOpenHelper {
    private static final String DATABASE = "PoupeCompre";
    private static final String TABLE = "Conta";
    private static final int VERSION = 1;
<<<<<<< HEAD

    public ContaDAO(Context context) {
        super(context, DATABASE, null, VERSION);
=======
    private Context context;

    public ContaDAO(Context context) {
        super(context, DATABASE, null, VERSION);
        this.context = context;
>>>>>>> 4ed497f37812f07ed72730d4b1790c5a6b5d32db
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
<<<<<<< HEAD
        String sql = "CREATE TABLE" + TABLE +
                "(id INTERGE PRIMARY KEY, " +
                "descricao TEXT," +
                "saldo NUMERIC NOT NULL," +
                "usuarioId INTERGE NOT NULL," +
=======
        String sql = "CREATE TABLE " + TABLE +
                "(id INTEGER PRIMARY KEY, " +
                "descricao TEXT," +
                "saldo NUMERIC," +
>>>>>>> 4ed497f37812f07ed72730d4b1790c5a6b5d32db
                "FOREIGN KEY(usuarioId) REFERENCES Usuario(id))";
        db.execSQL(sql);
    }

    @Override
<<<<<<< HEAD
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    public Conta buscarPorId(Long contaId){
        Conta conta = new Conta();




=======
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public void insert(Conta conta) {
        ContentValues values = new ContentValues();
        values.put("descricao", conta.getDescricao());
        values.put("saldo", conta.getSaldo().doubleValue());
        values.put("usuarioId", conta.getUsuario().getId());

        getWritableDatabase().insert(TABLE, null, values);
    }

    public void update(Conta conta) {
        ContentValues values = new ContentValues();
        values.put("descricao", conta.getDescricao());
        values.put("saldo", conta.getSaldo().doubleValue());
        values.put("usuarioId", conta.getUsuario().getId());

        String [] params = {conta.getId().toString()};
        getWritableDatabase().update(TABLE, values, "id=?", params);
    }

    public List<Conta> list() throws ParseException {
        List<Conta> contas = new ArrayList<Conta>();
        Cursor c = getReadableDatabase()
                .rawQuery("SELECT * FROM " + TABLE + " ORDER BY id",null);

        while (c.moveToNext()) {
            UsuarioDAO usuarioDAO = new UsuarioDAO(context);
            Usuario usuario = usuarioDAO.buscarPorId(c.getString(c.getColumnIndex("id")));
            Conta conta = new Conta(c.getString(c.getColumnIndex("descricao")),
                    BigDecimal.valueOf(c.getDouble(c.getColumnIndex("saldo"))),
                    usuario);
            conta.setId(c.getLong(c.getColumnIndex("id")));

            contas.add(conta);
        }
        c.close();
        return contas;
    }

    public Conta buscarPorId(String id) {
        Cursor c = getReadableDatabase()
                .rawQuery("SELECT * FROM " + TABLE + " WHERE id = ", new String[]{id});
        UsuarioDAO usuarioDAO = new UsuarioDAO(context);
        Usuario usuario = usuarioDAO.buscarPorId(c.getString(c.getColumnIndex("id")));
        Conta conta = new Conta(c.getString(c.getColumnIndex("descricao")),
                BigDecimal.valueOf(c.getDouble(c.getColumnIndex("saldo"))),
                usuario);
        conta.setId(c.getLong(c.getColumnIndex("id")));
>>>>>>> 4ed497f37812f07ed72730d4b1790c5a6b5d32db
        return conta;
    }
}
