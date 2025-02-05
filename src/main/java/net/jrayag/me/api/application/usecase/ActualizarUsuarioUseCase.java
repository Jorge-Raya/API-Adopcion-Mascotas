package net.jrayag.me.api.application.usecase;

import org.springframework.stereotype.Component;

import net.jrayag.me.api.core.model.Usuario;
import net.jrayag.me.api.core.service.UsuarioService;

@Component
public class ActualizarUsuarioUseCase {
	private final UsuarioService usuarioService;

    public ActualizarUsuarioUseCase(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    public Usuario actualizar(Long id, Usuario usuario) {
        return usuarioService.actualizarUsuario(id, usuario);
    }

}
