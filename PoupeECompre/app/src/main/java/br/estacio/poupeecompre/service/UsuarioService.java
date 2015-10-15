package br.estacio.poupeecompre.service;

import android.content.Context;

import java.util.List;

import br.estacio.poupeecompre.dao.UsuarioDAO;
import br.estacio.poupeecompre.dominio.Usuario;

public class UsuarioService implements IUsuarioService{

    private UsuarioDAO usuarioDAO;

    public UsuarioService(Context context){
        usuarioDAO = new UsuarioDAO(context);
    }

    @Override
    public void insert(Usuario usuario) throws Exception {
        usuarioDAO.insert(usuario);
    }

    @Override
    public void update(Usuario usuario) {
        usuarioDAO.update(usuario);
    }

    @Override
    public void delete(Usuario usuario) {
        usuarioDAO.delete(usuario);
    }

    @Override
    public List<Usuario> list() {
        return usuarioDAO.list();
    }

    @Override
    public Usuario buscarPorId(String id) {
        return usuarioDAO.buscarPorId(id);
    }

    @Override
    public Usuario buscarPorEmail(String email) {
        return usuarioDAO.buscarPorEmail(email);
    }
}
