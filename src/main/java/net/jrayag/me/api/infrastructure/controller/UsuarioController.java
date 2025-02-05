package net.jrayag.me.api.infrastructure.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import net.jrayag.me.api.application.usecase.ActualizarUsuarioUseCase;
import net.jrayag.me.api.application.usecase.ConsultarUsuariosUseCase;
import net.jrayag.me.api.application.usecase.EliminarUsuarioUseCase;
import net.jrayag.me.api.application.usecase.RegistrarUsuarioUseCase;
import net.jrayag.me.api.core.model.Usuario;

@RestController
@RequestMapping("/api/usuarios")
public class UsuarioController {
	
    private final RegistrarUsuarioUseCase registrarUsuarioUseCase;
    private final ConsultarUsuariosUseCase consultarUsuariosUseCase;
    private final ActualizarUsuarioUseCase actualizarUsuarioUseCase;
    private final EliminarUsuarioUseCase eliminarUsuarioUseCase;

	public UsuarioController(RegistrarUsuarioUseCase registrarUsuarioUseCase,
			ConsultarUsuariosUseCase consultarUsuariosUseCase, 
			ActualizarUsuarioUseCase actualizarUsuarioUseCase,
			EliminarUsuarioUseCase eliminarUsuarioUseCase) {
		this.registrarUsuarioUseCase = registrarUsuarioUseCase;
		this.consultarUsuariosUseCase = consultarUsuariosUseCase;
		this.actualizarUsuarioUseCase = actualizarUsuarioUseCase;
		this.eliminarUsuarioUseCase = eliminarUsuarioUseCase;
	}
	
	@PostMapping
    public ResponseEntity<Usuario> registrarUsuario(@RequestBody Usuario usuario) {
        Usuario usuarioRegistrado = registrarUsuarioUseCase.registrar(usuario);
        return ResponseEntity.ok(usuarioRegistrado);
    }
	
	@GetMapping
    public ResponseEntity<List<Usuario>> consultarUsuarios() {
        List<Usuario> usuarios = consultarUsuariosUseCase.consultar();
        return ResponseEntity.ok(usuarios);
    }
	
	@PutMapping("/{id}")
    public ResponseEntity<Usuario> actualizarUsuario(@PathVariable Long id, @RequestBody Usuario usuario) {
        Usuario usuarioActualizado = actualizarUsuarioUseCase.actualizar(id, usuario);
        return ResponseEntity.ok(usuarioActualizado);
    }
	
	@DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarUsuario(@PathVariable Long id) {
        eliminarUsuarioUseCase.eliminar(id);
        return ResponseEntity.noContent().build();
    }

}
