package net.jrayag.me.api.application.usecase;

import org.springframework.stereotype.Component;

import net.jrayag.me.api.core.service.MascotaService;

@Component
public class EliminarMascotaUseCase {
	
	private final MascotaService mascotaService;

    public EliminarMascotaUseCase(MascotaService mascotaService) {
        this.mascotaService = mascotaService;
    }

    public void eliminar(Long id) {
        mascotaService.eliminarMascota(id);
    }

}
