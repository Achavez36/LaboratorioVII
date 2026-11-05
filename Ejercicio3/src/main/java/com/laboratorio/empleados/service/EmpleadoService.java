package com.laboratorio.empleados.service;

import com.laboratorio.empleados.model.Empleado;
import com.laboratorio.empleados.exception.ResourceNotFoundException;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmpleadoService {
    
    private final List<Empleado> empleados = new ArrayList<>();
    private long idCounter = 1;

    public Empleado crear(Empleado empleado) {
        empleado.setId(idCounter++);
        empleados.add(empleado);
        return empleado;
    }

    public List<Empleado> obtenerTodos(String especialidad) {
        if (especialidad != null && !especialidad.isEmpty()) {
            return empleados.stream()
                .filter(e -> e.getEspecialidad().equalsIgnoreCase(especialidad))
                .collect(Collectors.toList());
        }
        return empleados;
    }

    public Empleado obtenerPorId(Long id) {
        return empleados.stream()
            .filter(e -> e.getId().equals(id))
            .findFirst()
            .orElseThrow(() -> new ResourceNotFoundException("Empleado no encontrado con ID: " + id));
    }
}