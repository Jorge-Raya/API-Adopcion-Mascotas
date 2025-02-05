package net.jrayag.me.api.application.usecase;

import org.springframework.stereotype.Component;

import net.jrayag.me.api.core.model.Mascota;
import net.jrayag.me.api.core.service.MascotaService;

@Component
public class RegistraMascotaUseCase {
	
	private final MascotaService mascotaService;

	public RegistraMascotaUseCase(MascotaService mascotaService) {
		
		this.mascotaService = mascotaService;
	}
	
	public Mascota registrar(Mascota mascota) {
		return mascotaService.registraMascota(mascota);
	}
	
	

}
