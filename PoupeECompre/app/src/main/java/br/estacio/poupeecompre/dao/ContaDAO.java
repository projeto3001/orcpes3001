package br.estacio.poupeecompre.dao;


import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import br.estacio.poupeecompre.dominio.Conta;


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
import br.estacio.poupeecompre.service.IContaService;


public class ContaDAO extends DAO implements IContaService{
    private static final String TABLE = "Conta";
    private Context context;


    public ContaDAO(Context context) {
        super(context);
        this.context = context;

    }

    @Override
    public void insert(Conta conta) {
        ContentValues values = new ContentValues();
        values.put("descricao", conta.getDescricao());
        values.put("saldo", conta.getSaldo().doubleValue());
        values.put("usuarioId", conta.getUsuario().getId());

        getWritableDatabase().insert(TABLE, null, values);
    }

    @Override
    public void update(Conta conta) {
        ContentValues values = new ContentValues();
        values.put("descricao", conta.getDescricao());
        values.put("saldo", conta.getSaldo().doubleValue());
        values.put("usuarioId", conta.getUsuario().getId());

        String [] params = {conta.getId().toString()};
        getWritableDatabase().update(TABLE, values, "id=?", params);
    }

    @Override
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

    @Override
    public Conta buscarPorId(String id) {
        Cursor c = getReadableDatabase()
                .rawQuery("SELECT * FROM " + TABLE + " WHERE id = ", new String[]{id});
        UsuarioDAO usuarioDAO = new UsuarioDAO(context);
        Usuario usuario = usuarioDAO.buscarPorId(c.getString(c.getColumnIndex("id")));
        Conta conta = null;
        if(c.moveToNext()) {
            conta = new Conta(c.getString(c.getColumnIndex("descricao")),
                    BigDecimal.valueOf(c.getDouble(c.getColumnIndex("saldo"))),
                    usuario);
            conta.setId(c.getLong(c.getColumnIndex("id")));
        }
        c.close();
        return conta;
    }

    @Override
    public Conta buscarPorDescricao(String descricao) {
        Cursor c = getReadableDatabase()
                .rawQuery("SELECT * FROM " + TABLE + " WHERE descricao = ", new String[]{descricao});
        UsuarioDAO usuarioDAO = new UsuarioDAO(context);
        Usuario usuario = usuarioDAO.buscarPorId(c.getString(c.getColumnIndex("id")));
        Conta conta = null;
        if(c.moveToNext()) {
            conta = new Conta(c.getString(c.getColumnIndex("descricao")),
                    BigDecimal.valueOf(c.getDouble(c.getColumnIndex("saldo"))),
                    usuario);
            conta.setId(c.getLong(c.getColumnIndex("id")));
        }
        c.close();
        return conta;
    }
}
