package net.jrayag.me.api.core.service;

import java.util.List;

import net.jrayag.me.api.core.model.Usuario;

public interface UsuarioService {
	
	Usuario registrarUsuario(Usuario usuario); // Crear
	
    List<Usuario> consultarUsuarios(); // Leer
    
    Usuario actualizarUsuario(Long id, Usuario usuario); // Actualizar
    
    void eliminarUsuario(Long id); // Eliminar

}
