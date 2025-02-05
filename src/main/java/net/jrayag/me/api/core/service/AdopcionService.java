package net.jrayag.me.api.core.service;

import java.util.List;

import net.jrayag.me.api.core.model.Adopcion;

public interface AdopcionService {
	
	Adopcion registrarAdopcion(Adopcion adopcion);
	
	List<Adopcion> consultarAdopciones();
	
	Adopcion actualizarAdopcion(Long id, Adopcion adopcion);
	
	void eliminarAdopcion(Long id);

}
