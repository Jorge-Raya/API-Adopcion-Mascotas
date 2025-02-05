package net.jrayag.me.api.application.usecase;

import java.util.List;

import org.springframework.stereotype.Component;

import net.jrayag.me.api.core.model.Usuario;
import net.jrayag.me.api.core.service.UsuarioService;

@Component
public class ConsultarUsuariosUseCase {
	
	private final UsuarioService usuarioService;

    public ConsultarUsuariosUseCase(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    public List<Usuario> consultar() {
        return usuarioService.consultarUsuarios();
    }

}
