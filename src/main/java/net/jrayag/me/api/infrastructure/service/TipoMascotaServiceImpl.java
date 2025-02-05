package net.jrayag.me.api.infrastructure.service;

import java.util.List;

import org.springframework.stereotype.Service;

import net.jrayag.me.api.core.model.Tipo_Mascota;
import net.jrayag.me.api.core.service.TipoMascotaService;
import net.jrayag.me.api.infrastructure.persistence.TipoMascotaRepository;

@Service
public class TipoMascotaServiceImpl implements TipoMascotaService {
	
	private final TipoMascotaRepository tipoMascotaRepository;
	

	public TipoMascotaServiceImpl(TipoMascotaRepository tipoMascotaRepository) {
		this.tipoMascotaRepository = tipoMascotaRepository;
	}

	@Override
	public Tipo_Mascota registrarTipoMascota(Tipo_Mascota tipoMascota) {
		return tipoMascotaRepository.save(tipoMascota);
	}

	@Override
	public List<Tipo_Mascota> consultarTiposMascota() {
		return tipoMascotaRepository.findAll();
	}

	@Override
	public Tipo_Mascota actualizarTipoMascota(Long id, Tipo_Mascota tipoMascota) {
		return tipoMascotaRepository.findById(id).map(tipoExistente -> {
            tipoExistente.setNombre(tipoMascota.getNombre());
            return tipoMascotaRepository.save(tipoExistente);
        }).orElseThrow(() -> new RuntimeException("Tipo de Mascota con ID " + id + " no encontrado."));
	}

	@Override
	public void eliminarTipoMascota(Long id) {
		if (tipoMascotaRepository.existsById(id)) {
            tipoMascotaRepository.deleteById(id);
        } else {
            throw new RuntimeException("Tipo de Mascota con ID " + id + " no encontrado.");
        }

	}

}
