package net.jrayag.me.api.application.usecase;

import org.springframework.stereotype.Component;

import net.jrayag.me.api.core.model.Mascota;
import net.jrayag.me.api.core.service.MascotaService;

@Component
public class ActualizarMascotaUseCase {
	
	private final MascotaService mascotaService;
	
	public ActualizarMascotaUseCase(MascotaService mascotaService) {
        this.mascotaService = mascotaService;
    }

    public Mascota actualizar(Long id, Mascota mascota) {
        return mascotaService.actualizarMascota(id, mascota);
    }

}
