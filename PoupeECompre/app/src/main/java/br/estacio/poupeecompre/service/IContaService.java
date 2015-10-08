package br.estacio.poupeecompre.service;

import java.text.ParseException;
import java.util.List;

import br.estacio.poupeecompre.dominio.Conta;

public interface IContaService {

    void insert(Conta conta);

    void update(Conta conta);

    List<Conta> list() throws ParseException;

    Conta buscarPorId(String id);

    Conta buscarPorDescricao(String descricao);
}
