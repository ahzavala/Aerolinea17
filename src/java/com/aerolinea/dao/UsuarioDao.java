package com.aerolinea.dao;

import com.aerolinea.entidad.Pais;
import com.aerolinea.entidad.Rol;
import com.aerolinea.entidad.Usuario;
import java.util.List;

public interface UsuarioDao {
    public void guardarUsuario(Usuario u);
    public List<Usuario> consultarUsuarios();
    public Usuario validarUsuario(Usuario u);
    public List<Rol> getRoles();
    public List<Pais> getPaises();
    public Usuario getUsuario(String id);
    public void EliminarUsuario(String id);
}

