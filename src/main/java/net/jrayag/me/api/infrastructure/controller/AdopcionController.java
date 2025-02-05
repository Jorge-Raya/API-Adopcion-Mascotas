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

import net.jrayag.me.api.application.usecase.ActualizarAdopcionUseCase;
import net.jrayag.me.api.application.usecase.ConsultarAdopcionesUseCase;
import net.jrayag.me.api.application.usecase.EliminarAdopcionUseCase;
import net.jrayag.me.api.application.usecase.RegistrarAdopcionUseCase;
import net.jrayag.me.api.core.model.Adopcion;

@RestController
@RequestMapping("/api/adopciones")
public class AdopcionController {
	
	private final RegistrarAdopcionUseCase registrarAdopcionUseCase;
	private final ConsultarAdopcionesUseCase consultarAdopcionesUseCase;
	private final ActualizarAdopcionUseCase actualizarAdopcionUseCase;
	private final EliminarAdopcionUseCase eliminarAdopcionUseCase;
	
	
	public AdopcionController(RegistrarAdopcionUseCase registrarAdopcionUseCase,
			ConsultarAdopcionesUseCase consultarAdopcionesUseCase, ActualizarAdopcionUseCase actualizarAdopcionUseCase,
			EliminarAdopcionUseCase eliminarAdopcionUseCase) {
		this.registrarAdopcionUseCase = registrarAdopcionUseCase;
		this.consultarAdopcionesUseCase = consultarAdopcionesUseCase;
		this.actualizarAdopcionUseCase = actualizarAdopcionUseCase;
		this.eliminarAdopcionUseCase = eliminarAdopcionUseCase;
	}
	
	
	@PostMapping
	public ResponseEntity<Adopcion> registrarAdopcion(@RequestBody Adopcion adopcion){
		Adopcion adopcionRegistrada = registrarAdopcionUseCase.registrar(adopcion);
		return ResponseEntity.ok(adopcionRegistrada);
	}
	
	
	@GetMapping
	public ResponseEntity<List<Adopcion>> consultarAdopciones(){
		List<Adopcion> adopciones = consultarAdopcionesUseCase.consultar();
		return ResponseEntity.ok(adopciones);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Adopcion> actualizarAdopcion(@PathVariable Long id, @RequestBody Adopcion adopcion){
		Adopcion adopcionActualizada = actualizarAdopcionUseCase.actualiza(id, adopcion);
		return ResponseEntity.ok(adopcionActualizada);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> eliminarAdopcion(@PathVariable Long id){
		eliminarAdopcionUseCase.eliminar(id);
		return ResponseEntity.noContent().build();
	}
	
	

}
