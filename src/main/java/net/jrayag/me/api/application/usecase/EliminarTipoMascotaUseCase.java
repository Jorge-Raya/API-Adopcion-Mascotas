package net.jrayag.me.api.application.usecase;

import org.springframework.stereotype.Component;

import net.jrayag.me.api.core.service.TipoMascotaService;

@Component
public class EliminarTipoMascotaUseCase {
	
	private final TipoMascotaService tipoMascotaService;
	
	public EliminarTipoMascotaUseCase(TipoMascotaService tipoMascotaService) {
		this.tipoMascotaService = tipoMascotaService;
	}
	
	public void eliminar(Long id) {
		tipoMascotaService.eliminarTipoMascota(id);
	}

}
