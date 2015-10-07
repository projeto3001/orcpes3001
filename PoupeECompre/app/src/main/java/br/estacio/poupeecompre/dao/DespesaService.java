package br.estacio.poupeecompre.dao;

import android.content.Context;

import java.text.ParseException;
import java.util.List;

import br.estacio.poupeecompre.dominio.Despesa;
import br.estacio.poupeecompre.service.IDespesaService;

public class DespesaService implements IDespesaService{
    private DespesaDAO despesaDAO;

    public DespesaService(Context context){
        despesaDAO = new DespesaDAO(context);
    }

    @Override
    public void insert(Despesa despesa) {
        despesaDAO.insert(despesa);
    }

    @Override
    public void update(Despesa despesa) {
        despesaDAO.update(despesa);
    }

    @Override
    public List<Despesa> list() throws ParseException {
        return despesaDAO.list();
    }

    @Override
    public void delete(Despesa despesa) {
        despesaDAO.delete(despesa);
    }
}
