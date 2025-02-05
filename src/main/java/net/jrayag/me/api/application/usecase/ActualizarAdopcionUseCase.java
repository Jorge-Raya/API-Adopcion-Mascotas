package net.jrayag.me.api.application.usecase;

import org.springframework.stereotype.Component;

import net.jrayag.me.api.core.model.Adopcion;
import net.jrayag.me.api.core.service.AdopcionService;

@Component
public class ActualizarAdopcionUseCase {

	private final AdopcionService adopcionService;

	public ActualizarAdopcionUseCase(AdopcionService adopcionService) {
		this.adopcionService = adopcionService;
	}
	
	public Adopcion actualiza(Long id,Adopcion adopcion) {
		return adopcionService.actualizarAdopcion(id, adopcion);
	}
}
