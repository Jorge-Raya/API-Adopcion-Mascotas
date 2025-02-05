package net.jrayag.me.api.infrastructure.service;

import java.util.List;

import org.springframework.stereotype.Service;

import net.jrayag.me.api.core.model.Usuario;
import net.jrayag.me.api.core.service.UsuarioService;
import net.jrayag.me.api.infrastructure.persistence.UsuarioRepository;

@Service
public class UsuarioServiceImpl implements UsuarioService {
	
	private final UsuarioRepository usuarioRepository;
	
	 public UsuarioServiceImpl(UsuarioRepository usuarioRepository) {
	        this.usuarioRepository = usuarioRepository;
	    }

	@Override
	public Usuario registrarUsuario(Usuario usuario) {
		return usuarioRepository.save(usuario);
	}

	@Override
	public List<Usuario> consultarUsuarios() {
		return usuarioRepository.findAll();
	}

	@Override
	public Usuario actualizarUsuario(Long id, Usuario usuario) {
		return usuarioRepository.findById(id).map(usuarioExistente -> {
            usuarioExistente.setNombre(usuario.getNombre());
            usuarioExistente.setCorreoElectronico(usuario.getCorreoElectronico());
            usuarioExistente.setTelefono(usuario.getTelefono());
            return usuarioRepository.save(usuarioExistente);
        }).orElseThrow(() -> new RuntimeException("Usuario con ID " + id + " no encontrado."));

	}

	@Override
	public void eliminarUsuario(Long id) {
		if (usuarioRepository.existsById(id)) {
            usuarioRepository.deleteById(id);
        } else {
            throw new RuntimeException("Usuario con ID " + id + " no encontrado.");
        }

	}

}
