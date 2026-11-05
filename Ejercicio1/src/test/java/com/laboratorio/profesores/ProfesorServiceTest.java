package com.laboratorio.profesores;

import com.laboratorio.profesores.exception.ResourceNotFoundException;
import com.laboratorio.profesores.model.Profesor;
import com.laboratorio.profesores.service.ProfesorService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ProfesorServiceTest {

    private ProfesorService service;

    @BeforeEach
    void setUp() {
        service = new ProfesorService();
    }

    @Test
    void crearProfesor_Exitoso() {
        Profesor p = new Profesor(null, "Alan", "Turing", "alan@test.com", "Ciencias", "Activo");
        Profesor creado = service.crear(p);

        assertNotNull(creado.getId());
        assertEquals("Alan", creado.getNombre());
    }

    @Test
    void obtenerProfesorExistente() {
        Profesor p = new Profesor(null, "Grace", "Hopper", "grace@test.com", "Sistemas", "Activo");
        Profesor creado = service.crear(p);

        Profesor encontrado = service.obtenerPorId(creado.getId());
        assertNotNull(encontrado);
        assertEquals("Grace", encontrado.getNombre());
    }

    @Test
    void obtenerProfesorInexistente_LanzaExcepcion() {
        assertThrows(ResourceNotFoundException.class, () -> {
            service.obtenerPorId(999L);
        });
    }
}