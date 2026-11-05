package com.laboratorio.profesores.service;

import com.laboratorio.profesores.model.Profesor;
import com.laboratorio.profesores.exception.ResourceNotFoundException;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProfesorService {
    
    private final List<Profesor> profesores = new ArrayList<>();
    private long idCounter = 1;

    public Profesor crear(Profesor profesor) {
        profesor.setId(idCounter++);
        profesores.add(profesor);
        return profesor;
    }

    public List<Profesor> obtenerTodos(String especialidad) {
        if (especialidad != null && !especialidad.isEmpty()) {
            return profesores.stream()
                .filter(p -> p.getEspecialidad().equalsIgnoreCase(especialidad))
                .collect(Collectors.toList());
        }
        return profesores;
    }

    public Profesor obtenerPorId(Long id) {
        return profesores.stream()
            .filter(p -> p.getId().equals(id))
            .findFirst()
            .orElseThrow(() -> new ResourceNotFoundException("Profesor no encontrado con ID: " + id));
    }
}