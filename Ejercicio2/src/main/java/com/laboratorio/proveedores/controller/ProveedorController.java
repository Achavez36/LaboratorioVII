package com.laboratorio.proveedores.controller;

import com.laboratorio.proveedores.model.Proveedor;
import com.laboratorio.proveedores.service.ProveedorService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/proveedores")
public class ProveedorController {

    private final ProveedorService service;

    public ProveedorController(ProveedorService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<Proveedor> crear(@Valid @RequestBody Proveedor proveedor) {
        return new ResponseEntity<>(service.crear(proveedor), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Proveedor>> obtenerTodos(@RequestParam(required = false) String categoria) {
        return ResponseEntity.ok(service.obtenerTodos(categoria));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Proveedor> obtenerPorId(@PathVariable Long id) {
        return ResponseEntity.ok(service.obtenerPorId(id));
    }
}