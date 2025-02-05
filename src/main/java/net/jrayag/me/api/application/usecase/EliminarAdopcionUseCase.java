package net.jrayag.me.api.application.usecase;

import org.springframework.stereotype.Component;

import net.jrayag.me.api.core.service.AdopcionService;

@Component
public class EliminarAdopcionUseCase {
	
	private final AdopcionService adopcionService;

	public EliminarAdopcionUseCase(AdopcionService adopcionService) {
		this.adopcionService = adopcionService;
	}
	
	public void eliminar(Long id) {
		adopcionService.eliminarAdopcion(id);
	}

}
