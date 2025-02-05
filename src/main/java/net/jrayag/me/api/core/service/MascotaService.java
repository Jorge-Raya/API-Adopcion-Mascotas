package net.jrayag.me.api.core.service;

import java.util.List;

import net.jrayag.me.api.core.model.Mascota;

public interface MascotaService {
	
	Mascota registraMascota(Mascota mascota);
	
	List<Mascota> consultarMascotasDisponibles();
	
	Mascota actualizarMascota(Long id, Mascota mascota);
	
	void eliminarMascota(Long id);
	
}
