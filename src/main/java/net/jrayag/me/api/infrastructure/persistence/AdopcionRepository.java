package net.jrayag.me.api.infrastructure.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

import net.jrayag.me.api.core.model.Adopcion;

public interface AdopcionRepository extends JpaRepository<Adopcion, Long> {

}
