package net.jrayag.me.api.infrastructure.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

import net.jrayag.me.api.core.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

}
