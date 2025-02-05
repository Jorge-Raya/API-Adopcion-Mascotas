package net.jrayag.me.api.infrastructure.persistence;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import net.jrayag.me.api.core.model.Mascota;

public interface MascotaRepository extends JpaRepository<Mascota, Long> {
	
	List<Mascota> findByDisponibleTrue(); // Busca solo las mascotas con "disponible = true"

}
