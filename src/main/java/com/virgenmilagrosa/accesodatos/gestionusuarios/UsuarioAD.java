package com.virgenmilagrosa.accesodatos.gestionusuarios;

import com.virgenmilagrosa.tranversal.entidades.Usuario;

import java.util.List;

public interface UsuarioAD {

    public List<Usuario> listarUsuarios();

    public String registrarUsuario(Usuario usuario);

    public String modificarUsuario(Usuario usuario);

    public String modificarPassword(Usuario usuario, String password);

    public String eliminarUsuario(int codUsuario);

    public Usuario buscarUsuario(int codUsuario);

    public int verificarUsuario(String username, String password);
}
