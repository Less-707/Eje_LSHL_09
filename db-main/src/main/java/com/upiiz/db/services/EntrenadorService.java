package com.upiiz.db.services;

import com.upiiz.db.entities.EntrenadorEntity;

import java.util.List;

public interface EntrenadorService {
     List<EntrenadorEntity> listarEntrenadores();
     EntrenadorEntity guardarEntrenador(EntrenadorEntity entrenador);
     EntrenadorEntity obtenerEntrenadorPorId(Long id);
     void eliminarEntrenador(Long id);
}
