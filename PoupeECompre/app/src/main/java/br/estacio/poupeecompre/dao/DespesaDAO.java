package br.estacio.poupeecompre.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import br.estacio.poupeecompre.dominio.Categoria;
import br.estacio.poupeecompre.dominio.Conta;
import br.estacio.poupeecompre.dominio.Despesa;

public class DespesaDAO extends SQLiteOpenHelper {
    private static final String DATABASE = "PoupeCompre";
    private static final String TABLE = "Despesa";
    private static final int VERSION = 1;
    public static Object insert;
    private Context context;


    public DespesaDAO(Context context) {
        super(context, DATABASE, null, VERSION);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "CREATE TABLE " + TABLE +
                "(id INTEGER PRIMARY KEY, " +
                "descricao TEXT NOT NULL," +
                "data TEXT NOT NULL," +
                "valor NUMERIC NOT NULL," +
                "FOREIGN KEY(contaId) REFERENCES Conta(id))," +
                "FOREIGN KEY(categoriaId) REFERENCES Categoria(id)";
        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    }

    public void insert(Despesa despesa) {
        ContentValues values = new ContentValues();
        values.put("descricao", despesa.getDescricao());
        values.put("data", String.valueOf(despesa.getData()));
        values.put("valor", despesa.getValor().doubleValue());
        values.put("contaId", despesa.getConta().getId());
        values.put("categoriaId", despesa.getCategoria().getId());

        getWritableDatabase().insert(TABLE, null, values);
    }

    public void update(Despesa despesa) {
        ContentValues values = new ContentValues();
        values.put("descricao", despesa.getDescricao());
        values.put("data", String.valueOf(despesa.getData()));
        values.put("valor", despesa.getValor().doubleValue());
        values.put("contaId", despesa.getConta().getId());
        values.put("categoriaId", despesa.getCategoria().getId());

        String [] params = {despesa.getId().toString()};
        getWritableDatabase().update(TABLE, values, "id=?", params);
    }

    public List<Despesa> list() throws ParseException {
        List<Despesa> despesas = new ArrayList<Despesa>();
        Cursor c = getReadableDatabase()
                .rawQuery("SELECT * FROM " + TABLE + " ORDER BY id",null);

        while (c.moveToNext()) {
            DateFormat dateFormat = new SimpleDateFormat("MM/dd/yy");
            Date data  = (Date)dateFormat.parse(c.getString(c.getColumnIndex("data")));
            ContaDAO contaDAO = new ContaDAO(context);
            Conta conta = contaDAO.buscarPorId(c.getString(c.getColumnIndex("contaId")));
            CategoriaDAO categoriaDAO = new CategoriaDAO(context);
            Categoria categoria = categoriaDAO.buscarPorId(c.getString(c.getColumnIndex("categoriaId")));
            Despesa despesa = new Despesa(c.getString(c.getColumnIndex("descricao")),
                    data,
                    BigDecimal.valueOf(c.getDouble(c.getColumnIndex("valor"))),
                    conta,
                    categoria);
            despesa.setId(c.getLong(c.getColumnIndex("id")));
            despesas.add(despesa);
        }
        c.close();
        return despesas;
    }

    public void delete(Despesa despesa) {
        String [] params = {despesa.getId().toString()};
        getWritableDatabase().delete(TABLE, "id=?", params);
    }
}
