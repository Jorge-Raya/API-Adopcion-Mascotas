package net.jrayag.me.api.core.service;

import java.util.List;

import net.jrayag.me.api.core.model.Tipo_Mascota;

public interface TipoMascotaService {
	
	Tipo_Mascota registrarTipoMascota(Tipo_Mascota tipoMascota); // Crear
	
    List<Tipo_Mascota> consultarTiposMascota(); // Leer
    
    Tipo_Mascota actualizarTipoMascota(Long id, Tipo_Mascota tipoMascota); // Actualizar
    
    void eliminarTipoMascota(Long id); // Eliminar

}
