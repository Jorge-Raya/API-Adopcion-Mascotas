package net.jrayag.me.api.application.usecase;

import java.util.List;

import org.springframework.stereotype.Component;

import net.jrayag.me.api.core.model.Tipo_Mascota;
import net.jrayag.me.api.core.service.TipoMascotaService;

@Component
public class ConsultarTiposMascotaUseCase {
	
	private final TipoMascotaService tipoMascotaService;
	
	public ConsultarTiposMascotaUseCase(TipoMascotaService tipoMascotaService) {
		this.tipoMascotaService = tipoMascotaService;
		
	}
	
	public List<Tipo_Mascota> consultar(){
		return tipoMascotaService.consultarTiposMascota();
	}

}
