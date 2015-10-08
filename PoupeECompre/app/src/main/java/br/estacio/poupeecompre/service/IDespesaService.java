package br.estacio.poupeecompre.service;

import java.text.ParseException;
import java.util.List;

import br.estacio.poupeecompre.dominio.Despesa;

public interface IDespesaService {

    void insert(Despesa despesa);

    void update(Despesa despesa);

    List<Despesa> list() throws ParseException;

    void delete(Despesa despesa);
}
