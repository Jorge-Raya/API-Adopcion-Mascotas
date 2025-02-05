package net.jrayag.me.api.application.usecase;

import org.springframework.stereotype.Component;

import net.jrayag.me.api.core.model.Tipo_Mascota;
import net.jrayag.me.api.core.service.TipoMascotaService;

@Component
public class ActualizarTipoMascotaUseCase {
	
	private final TipoMascotaService tipoMascotaService;
	
	public ActualizarTipoMascotaUseCase(TipoMascotaService tipoMascotaService) {
		this.tipoMascotaService = tipoMascotaService;
	}
	
	public Tipo_Mascota actualizar(Long id, Tipo_Mascota tipo_Mascota) {
		return tipoMascotaService.actualizarTipoMascota(id, tipo_Mascota);
		
	}

}
