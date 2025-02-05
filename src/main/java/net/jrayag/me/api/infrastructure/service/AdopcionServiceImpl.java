package net.jrayag.me.api.infrastructure.service;

import java.util.List;

import org.springframework.stereotype.Service;

import net.jrayag.me.api.core.model.Adopcion;
import net.jrayag.me.api.core.service.AdopcionService;
import net.jrayag.me.api.infrastructure.persistence.AdopcionRepository;


@Service
public class AdopcionServiceImpl implements AdopcionService {
	
	private final AdopcionRepository adopcionRepository;
	
	

	public AdopcionServiceImpl(AdopcionRepository adopcionRepository) {
		this.adopcionRepository = adopcionRepository;
	}

	@Override
	public Adopcion registrarAdopcion(Adopcion adopcion) {
		return adopcionRepository.save(adopcion);
	}

	@Override
	public List<Adopcion> consultarAdopciones() {
		return adopcionRepository.findAll();
	}

	@Override
	public Adopcion actualizarAdopcion(Long id, Adopcion adopcion) {
		return adopcionRepository.findById(id).map(
					adopcionExistente -> {
						adopcionExistente.setMascota(adopcion.getMascota());
						adopcionExistente.setUsuario(adopcion.getUsuario());
						adopcionExistente.setFechaAdopcion(adopcion.getFechaAdopcion());
						return adopcionRepository.save(adopcionExistente);
					}).orElseThrow(() -> new RuntimeException("Adopcion con ID "+id+" no encontrada."));
	}

	@Override
	public void eliminarAdopcion(Long id) {
		if (adopcionRepository.existsById(id)) {
			adopcionRepository.deleteById(id);
		}else {
			throw new RuntimeException("Adopcion con ID "+id+" no encontrada.");
		}

	}

}
