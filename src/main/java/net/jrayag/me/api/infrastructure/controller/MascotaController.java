package net.jrayag.me.api.infrastructure.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import net.jrayag.me.api.application.usecase.ActualizarMascotaUseCase;
import net.jrayag.me.api.application.usecase.ConsultaMascotasDisponiblesUseCase;
import net.jrayag.me.api.application.usecase.EliminarMascotaUseCase;
import net.jrayag.me.api.application.usecase.RegistraMascotaUseCase;
import net.jrayag.me.api.core.model.Mascota;

@RestController
public class MascotaController {
	
	private final RegistraMascotaUseCase registraMascotaUseCase;
	private final ConsultaMascotasDisponiblesUseCase consultaMascotasDisponiblesUseCase;
	private final ActualizarMascotaUseCase actualizarMascotaUseCase;
	private final EliminarMascotaUseCase eliminarMascotaUseCase;


	public MascotaController(RegistraMascotaUseCase registraMascotaUseCase,
            ConsultaMascotasDisponiblesUseCase consultaMascotasDisponiblesUseCase,
            ActualizarMascotaUseCase actualizarMascotaUseCase,
            EliminarMascotaUseCase eliminarMascotaUseCase) {
		this.registraMascotaUseCase = registraMascotaUseCase;
		this.consultaMascotasDisponiblesUseCase = consultaMascotasDisponiblesUseCase;
		this.actualizarMascotaUseCase = actualizarMascotaUseCase;
		this.eliminarMascotaUseCase = eliminarMascotaUseCase;
	}
	
	
	@PostMapping("/api/mascotas")
	public ResponseEntity<Mascota> registrarMascota(@RequestBody Mascota mascota){
		
		Mascota mascotaIngresante = registraMascotaUseCase.registrar(mascota);
		return ResponseEntity.ok(mascotaIngresante);
	}
	
	@GetMapping("/api/mascotas")
	public ResponseEntity<List<Mascota>> consultarMascotasDisponibles() {
	    List<Mascota> mascotasDisponibles = consultaMascotasDisponiblesUseCase.consultar();
	    return ResponseEntity.ok(mascotasDisponibles);
	}
	
	@PutMapping("/api/mascotas/{id}")
    public ResponseEntity<Mascota> actualizarMascota(@PathVariable Long id, @RequestBody Mascota mascota) {
        Mascota mascotaActualizada = actualizarMascotaUseCase.actualizar(id, mascota);
        return ResponseEntity.ok(mascotaActualizada);
    }
	
	@DeleteMapping("/api/mascotas/{id}")
    public ResponseEntity<Void> eliminarMascota(@PathVariable Long id) {
        eliminarMascotaUseCase.eliminar(id);
        return ResponseEntity.noContent().build();
    }

}
