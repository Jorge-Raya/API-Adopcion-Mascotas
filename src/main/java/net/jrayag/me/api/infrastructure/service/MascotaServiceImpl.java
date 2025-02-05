package net.jrayag.me.api.infrastructure.service;

import java.util.List;

import org.springframework.stereotype.Service;

import net.jrayag.me.api.core.model.Mascota;
import net.jrayag.me.api.core.service.MascotaService;
import net.jrayag.me.api.infrastructure.persistence.MascotaRepository;

@Service
public class MascotaServiceImpl implements MascotaService {
	
	private final MascotaRepository mascotaRepository;

	public MascotaServiceImpl(MascotaRepository mascotaRepository) {
		this.mascotaRepository = mascotaRepository;
	}
	
	@Override
	public Mascota registraMascota(Mascota mascota) {
		return mascotaRepository.save(mascota);
	}
	
	@Override
    public List<Mascota> consultarMascotasDisponibles() {
        return mascotaRepository.findByDisponibleTrue(); // Metodo especifico del repositorio
    }
	
	@Override
    public Mascota actualizarMascota(Long id, Mascota mascota) {
        return mascotaRepository.findById(id).map(mascotaExistente -> {
            mascotaExistente.setNombre(mascota.getNombre());
            mascotaExistente.setTipomascota(mascota.getTipomascota());
            mascotaExistente.setEdad(mascota.getEdad());
            mascotaExistente.setDisponible(mascota.getDisponible());
            return mascotaRepository.save(mascotaExistente);
        }).orElseThrow(() -> new RuntimeException("Mascota con ID " + id + " no encontrada."));
    }
	
	@Override
    public void eliminarMascota(Long id) {
        if (mascotaRepository.existsById(id)) {
            mascotaRepository.deleteById(id);
        } else {
            throw new RuntimeException("Mascota con ID " + id + " no encontrada.");
        }
    }

}
