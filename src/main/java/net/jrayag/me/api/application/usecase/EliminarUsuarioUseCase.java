package net.jrayag.me.api.application.usecase;

import org.springframework.stereotype.Component;

import net.jrayag.me.api.core.service.UsuarioService;

@Component
public class EliminarUsuarioUseCase {
	private final UsuarioService usuarioService;

    public EliminarUsuarioUseCase(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    public void eliminar(Long id) {
        usuarioService.eliminarUsuario(id);
    }

}
