package net.jrayag.me.api.application.usecase;

import java.util.List;

import org.springframework.stereotype.Component;

import net.jrayag.me.api.core.model.Adopcion;
import net.jrayag.me.api.core.service.AdopcionService;

@Component
public class ConsultarAdopcionesUseCase {
	
	private final AdopcionService adopcionService;

	public ConsultarAdopcionesUseCase(AdopcionService adopcionService) {
		this.adopcionService = adopcionService;
	}
	
	public List<Adopcion> consultar(){
		return adopcionService.consultarAdopciones();
	}

}
