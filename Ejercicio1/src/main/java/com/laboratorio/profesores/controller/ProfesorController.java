package com.laboratorio.profesores.controller;

import com.laboratorio.profesores.model.Profesor;
import com.laboratorio.profesores.service.ProfesorService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/profesores")
public class ProfesorController {

    private final ProfesorService service;

    public ProfesorController(ProfesorService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<Profesor> crear(@Valid @RequestBody Profesor profesor) {
        return new ResponseEntity<>(service.crear(profesor), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Profesor>> obtenerTodos(@RequestParam(required = false) String especialidad) {
        return ResponseEntity.ok(service.obtenerTodos(especialidad));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Profesor> obtenerPorId(@PathVariable Long id) {
        return ResponseEntity.ok(service.obtenerPorId(id));
    }
}