package br.estacio.poupeecompre.service;

import android.content.Context;

import java.text.ParseException;
import java.util.List;

import br.estacio.poupeecompre.dao.ContaDAO;
import br.estacio.poupeecompre.dominio.Conta;

public class ContaService implements IContaService{

    private ContaDAO contaDAO;

    public ContaService(Context context){
        contaDAO = new ContaDAO(context);
    }

    @Override
    public void insert(Conta conta) {
        contaDAO.insert(conta);
    }

    @Override
    public void update(Conta conta) {
        contaDAO.update(conta);
    }

    @Override
    public List<Conta> list() throws ParseException {
        return contaDAO.list();
    }

    @Override
    public Conta buscarPorId(String id) {
        return contaDAO.buscarPorId(id);
    }

    @Override
    public Conta buscarPorDescricao(String descricao) {
        return contaDAO.buscarPorDescricao(descricao);
    }
}
