package br.estacio.poupeecompre.service;

import java.text.ParseException;
import java.util.List;

import br.estacio.poupeecompre.dominio.Receita;

public interface IReceitaService {

    void inser(Receita receita);

    void update(Receita receita);

    List<Receita> list() throws ParseException;
}
