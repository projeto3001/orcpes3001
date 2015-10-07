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
import java.util.List;
import java.util.Date;

import br.estacio.poupeecompre.dominio.Conta;
import br.estacio.poupeecompre.dominio.Receita;
import br.estacio.poupeecompre.service.IReceitaService;

public class ReceitaDAO extends SQLiteOpenHelper implements IReceitaService{
    private static final String DATABASE = "PoupeCompre";
    private static final String TABLE = "Receita";
    private static final int VERSION = 1;
    private Context context;

    public ReceitaDAO(Context context) {
        super(context, DATABASE, null, VERSION);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "CREATE TABLE " + TABLE +
                "(id INTEGER PRIMARY KEY, " +
                "data TEXT NOT NULL, " +
                "descricao TEXT," +
                "valor NUMERIC NOT NULL," +
                "contaId INTEGER NOT NULL," +
                "FOREIGN KEY(contaId) REFERENCES Conta(id))";
        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    @Override
    public void inser(Receita receita) {
        ContentValues values = new ContentValues();
        values.put("data", String.valueOf(receita.getData()));
        values.put("descricao", receita.getDescricao());
        values.put("valor", receita.getValor().doubleValue());
        values.put("contaId", receita.getConta().getId());

        getWritableDatabase().insert(TABLE, null, values);
    }

    @Override
    public void update(Receita receita) {
        ContentValues values = new ContentValues();
        values.put("data", String.valueOf(receita.getData()));
        values.put("descricao", receita.getDescricao());
        values.put("valor", receita.getValor().doubleValue());
        values.put("contaId", receita.getConta().getId());

        String [] params = {receita.getId().toString()};
        getWritableDatabase().update(TABLE, values, "id=?", params);
    }

    @Override
    public List<Receita> list() throws ParseException {
        List<Receita> receitas = new ArrayList<Receita>();
        Cursor c = getReadableDatabase()
                .rawQuery("SELECT * FROM " + TABLE + " ORDER BY data",null);

        while (c.moveToNext()) {
            DateFormat dateFormat = new SimpleDateFormat("MM/dd/yy");
            Date data  = (Date)dateFormat.parse(c.getString(c.getColumnIndex("data")));
            ContaDAO contaDAO = new ContaDAO(context);
            Conta conta = contaDAO.buscarPorId(c.getString(c.getColumnIndex("contaId")));
            Receita receita = new Receita(data,
                    c.getString(c.getColumnIndex("descricao")),
                    BigDecimal.valueOf(c.getDouble(c.getColumnIndex("valor"))),
                    conta);
            receita.setId(c.getLong(c.getColumnIndex("id")));
            receitas.add(receita);
        }
        c.close();
        return receitas;
    }
}
