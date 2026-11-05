package com.laboratorio.empleados.controller;

import com.laboratorio.empleados.model.Empleado;
import com.laboratorio.empleados.service.EmpleadoService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/empleados")
public class EmpleadoController {

    private final EmpleadoService service;

    public EmpleadoController(EmpleadoService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<Empleado> crear(@Valid @RequestBody Empleado empleado) {
        return new ResponseEntity<>(service.crear(empleado), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Empleado>> obtenerTodos(@RequestParam(required = false) String especialidad) {
        return ResponseEntity.ok(service.obtenerTodos(especialidad));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Empleado> obtenerPorId(@PathVariable Long id) {
        return ResponseEntity.ok(service.obtenerPorId(id));
    }
}