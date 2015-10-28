package br.estacio.poupeecompre.service;

import android.content.Context;

import java.util.List;

import br.estacio.poupeecompre.dao.CategoriaDAO;
import br.estacio.poupeecompre.dominio.Categoria;

public class CategoriaService implements ICategoriaService{

    private CategoriaDAO categoriaDAO;

    public CategoriaService(Context context){
        this.categoriaDAO = new CategoriaDAO(context);
    }

    @Override
    public void insert(Categoria categoria) throws Exception{
        categoriaDAO.insert(categoria);
    }

    @Override
    public void update(Categoria categoria) {
        categoriaDAO.update(categoria);
    }

    @Override
    public void delete(Categoria categoria) {
        categoriaDAO.delete(categoria);
    }

    @Override
    public Categoria buscarPorId(String id) {
        return categoriaDAO.buscarPorId(id);
    }

    @Override
    public Categoria buscarPorDescricao(String descricao) {
        return categoriaDAO.buscarPorDescricao(descricao);
    }

    @Override
    public List<Categoria> list() {
        return categoriaDAO.list();
    }
}
