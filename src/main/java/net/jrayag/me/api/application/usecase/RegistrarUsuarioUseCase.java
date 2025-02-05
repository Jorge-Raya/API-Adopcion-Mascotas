package net.jrayag.me.api.application.usecase;

import org.springframework.stereotype.Component;

import net.jrayag.me.api.core.model.Usuario;
import net.jrayag.me.api.core.service.UsuarioService;

@Component
public class RegistrarUsuarioUseCase {
	
	private final UsuarioService usuarioService;

    public RegistrarUsuarioUseCase(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    public Usuario registrar(Usuario usuario) {
        return usuarioService.registrarUsuario(usuario);
    }

}
