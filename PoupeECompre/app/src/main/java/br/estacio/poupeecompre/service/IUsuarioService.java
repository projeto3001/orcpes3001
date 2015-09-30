package br.estacio.poupeecompre.service;

import java.util.List;

import br.estacio.poupeecompre.dominio.Usuario;

public interface IUsuarioService {

    void insert(Usuario usuario);

    void update(Usuario usuario);

    void delete(Usuario usuario);

    List<Usuario> list();

    Usuario buscarPorId(String id);

    Usuario buscarPorEmail(String email);
}
