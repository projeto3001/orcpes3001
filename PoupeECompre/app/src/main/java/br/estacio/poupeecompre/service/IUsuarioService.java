package br.estacio.poupeecompre.service;

import java.util.List;

import br.estacio.poupeecompre.dominio.Usuario;

public interface IUsuarioService {

    public void insert(Usuario usuario) throws Exception;

    public void update(Usuario usuario);

    public void delete(Usuario usuario);

    public List<Usuario> list();

    public Usuario buscarPorId(String id);

    public Usuario buscarPorEmail(String email) throws Exception;
}
