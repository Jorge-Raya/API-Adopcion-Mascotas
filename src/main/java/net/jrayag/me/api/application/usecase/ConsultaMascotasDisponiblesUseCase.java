package net.jrayag.me.api.application.usecase;

import java.util.List;

import org.springframework.stereotype.Component;

import net.jrayag.me.api.core.model.Mascota;
import net.jrayag.me.api.core.service.MascotaService;

@Component
public class ConsultaMascotasDisponiblesUseCase {
	
	private final MascotaService mascotaService;
	
	public ConsultaMascotasDisponiblesUseCase(MascotaService mascotaService) {
        this.mascotaService = mascotaService;
    }
	
	public List<Mascota> consultar() {
        return mascotaService.consultarMascotasDisponibles();
    }

}
