package net.jrayag.me.api.infrastructure.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

import net.jrayag.me.api.core.model.Tipo_Mascota;

public interface TipoMascotaRepository extends JpaRepository<Tipo_Mascota, Long> {

}
