package com.laboratorio.proveedores.service;

import com.laboratorio.proveedores.model.Proveedor;
import com.laboratorio.proveedores.exception.ResourceNotFoundException;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProveedorService {
    
    private final List<Proveedor> proveedores = new ArrayList<>();
    private long idCounter = 1;

    public Proveedor crear(Proveedor proveedor) {
        proveedor.setId(idCounter++);
        proveedores.add(proveedor);
        return proveedor;
    }

    public List<Proveedor> obtenerTodos(String categoria) {
        if (categoria != null && !categoria.isEmpty()) {
            return proveedores.stream()
                .filter(p -> p.getCategoria().equalsIgnoreCase(categoria))
                .collect(Collectors.toList());
        }
        return proveedores;
    }

    public Proveedor obtenerPorId(Long id) {
        return proveedores.stream()
            .filter(p -> p.getId().equals(id))
            .findFirst()
            .orElseThrow(() -> new ResourceNotFoundException("Proveedor no encontrado con ID: " + id));
    }
}