package net.jrayag.me.api.application.usecase;

import org.springframework.stereotype.Component;

import net.jrayag.me.api.core.model.Adopcion;
import net.jrayag.me.api.core.service.AdopcionService;

@Component
public class RegistrarAdopcionUseCase {
	
	private final AdopcionService adopcionService;
	
	public RegistrarAdopcionUseCase(AdopcionService adopcionService) {
		this.adopcionService = adopcionService;
	}
	
	public Adopcion registrar(Adopcion adopcion) {
		return adopcionService.registrarAdopcion(adopcion);
	}

}
