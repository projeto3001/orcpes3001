package br.estacio.poupeecompre.service;

import java.util.List;

import br.estacio.poupeecompre.dominio.Categoria;

public interface ICategoriaService {

    void insert(Categoria categoria) throws Exception;

    void update(Categoria categoria);

    void delete(Categoria categoria);

    Categoria buscarPorId(String id);

    Categoria buscarPorDescricao(String descricao);

    List<Categoria> list();

}
