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

import net.jrayag.me.api.application.usecase.ActualizarTipoMascotaUseCase;
import net.jrayag.me.api.application.usecase.ConsultarTiposMascotaUseCase;
import net.jrayag.me.api.application.usecase.EliminarTipoMascotaUseCase;
import net.jrayag.me.api.application.usecase.RegistrarTipoMascotaUseCase;
import net.jrayag.me.api.core.model.Tipo_Mascota;

@RestController
@RequestMapping("/api/tipo_mascota")
public class TipoMascotaController {
	
	private final RegistrarTipoMascotaUseCase registrarTipoMascotaUseCase;
	
	private final ConsultarTiposMascotaUseCase consultarTiposMascotaUseCase;
	
	private final ActualizarTipoMascotaUseCase actualizarTipoMascotaUseCase;
	
	private final EliminarTipoMascotaUseCase eliminarTipoMascotaUseCase;

	public TipoMascotaController(RegistrarTipoMascotaUseCase registrarTipoMascotaUseCase,
			ConsultarTiposMascotaUseCase consultarTiposMascotaUseCase,
			ActualizarTipoMascotaUseCase actualizarTipoMascotaUseCase,
			EliminarTipoMascotaUseCase eliminarTipoMascotaUseCase) {

		this.registrarTipoMascotaUseCase = registrarTipoMascotaUseCase;
		this.consultarTiposMascotaUseCase = consultarTiposMascotaUseCase;
		this.actualizarTipoMascotaUseCase = actualizarTipoMascotaUseCase;
		this.eliminarTipoMascotaUseCase = eliminarTipoMascotaUseCase;
	}
	
	@PostMapping
	public ResponseEntity<Tipo_Mascota> registrarTipoMascota(@RequestBody Tipo_Mascota tipo_Mascota){
		Tipo_Mascota tipoMascotaRegistrado = registrarTipoMascotaUseCase.registrar(tipo_Mascota);
		return ResponseEntity.ok(tipoMascotaRegistrado);
	}
	
	@GetMapping
	public ResponseEntity<List<Tipo_Mascota>> consultarTiposMascota(){
		List<Tipo_Mascota> tiposMascota = consultarTiposMascotaUseCase.consultar();
		return ResponseEntity.ok(tiposMascota);
	}
	
	
	@PutMapping("/{id}")
	public ResponseEntity<Tipo_Mascota> actualizarTipoMascota(@PathVariable Long id,@RequestBody Tipo_Mascota tipo_Mascota){
		Tipo_Mascota tipoMascotaActualizado = actualizarTipoMascotaUseCase.actualizar(id, tipo_Mascota);
		return ResponseEntity.ok(tipoMascotaActualizado);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> eliminarTipoMascota(@PathVariable Long id){
		eliminarTipoMascotaUseCase.eliminar(id);
		return ResponseEntity.noContent().build();
	}
	

}
