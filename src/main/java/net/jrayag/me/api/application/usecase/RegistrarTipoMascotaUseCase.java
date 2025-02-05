package net.jrayag.me.api.application.usecase;

import org.springframework.stereotype.Component;

import net.jrayag.me.api.core.model.Tipo_Mascota;
import net.jrayag.me.api.core.service.TipoMascotaService;

@Component
public class RegistrarTipoMascotaUseCase {
	
	private final TipoMascotaService tipoMascotaService;
	
	public RegistrarTipoMascotaUseCase(TipoMascotaService tipoMascotaService) {
		this.tipoMascotaService = tipoMascotaService;
	}
	
	public Tipo_Mascota registrar(Tipo_Mascota tipo_Mascota) {
		return tipoMascotaService.registrarTipoMascota(tipo_Mascota);
	}

}
