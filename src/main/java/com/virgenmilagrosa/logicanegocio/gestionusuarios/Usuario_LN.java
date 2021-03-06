package com.virgenmilagrosa.logicanegocio.gestionusuarios;

import com.virgenmilagrosa.accesodatos.FactoryADOracle;
import java.util.List;

import com.virgenmilagrosa.accesodatos.gestionusuarios.*;
import com.virgenmilagrosa.tranversal.entidades.Usuario;

public class Usuario_LN {

    private static final Usuario_LN instance = new Usuario_LN();

    private Usuario_LN() {
    }

    public static Usuario_LN getInstance() {
        return instance;
    }

    private UsuarioAD usuarioAD = FactoryADOracle.getFactory().getUsuarioAD();

    public List<Usuario> listarUsuarios() {
        return usuarioAD.listarUsuarios();
    }

    public String registrarUsuario(Usuario usuario) {
        return usuarioAD.registrarUsuario(usuario);
    }

    public String modificarUsuario(Usuario usuario) {
        return usuarioAD.modificarUsuario(usuario);
    }

    public String modificarPassword(Usuario usuario, String password) {
        return usuarioAD.modificarPassword(usuario, password);
    }

    public String eliminarUsuario(int codUsuario) {
        return usuarioAD.eliminarUsuario(codUsuario);
    }

    public Usuario buscarUsuario(String codUsuario) {
        return usuarioAD.buscarUsuario(codUsuario);
    }

    public int verificarUsuario(String username, String password) {
        return usuarioAD.verificarUsuario(username, password);
    }
}
