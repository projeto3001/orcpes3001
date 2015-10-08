package br.estacio.poupeecompre.service;

import android.content.Context;

import java.text.ParseException;
import java.util.List;

import br.estacio.poupeecompre.dao.ReceitaDAO;
import br.estacio.poupeecompre.dominio.Receita;

public class ReceitaService implements IReceitaService {

    private ReceitaDAO receitaDAO;

    public ReceitaService(Context context){
        receitaDAO = new ReceitaDAO(context);
    }

    @Override
    public void inser(Receita receita) {
        receitaDAO.inser(receita);
    }

    @Override
    public void update(Receita receita) {
        receitaDAO.update(receita);
    }

    @Override
    public List<Receita> list() throws ParseException {
        return receitaDAO.list();
    }
}
