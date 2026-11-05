package com.laboratorio.empleados;

import com.laboratorio.empleados.exception.ResourceNotFoundException;
import com.laboratorio.empleados.model.Empleado;
import com.laboratorio.empleados.service.EmpleadoService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class EmpleadoServiceTest {

    private EmpleadoService service;

    @BeforeEach
    void setUp() {
        service = new EmpleadoService();
    }

    @Test
    void crearEmpleado_Exitoso() {
        Empleado e = new Empleado(null, "Linus", "Torvalds", "linus@linux.org", "Desarrollo", "Activo");
        Empleado creado = service.crear(e);

        assertNotNull(creado.getId());
        assertEquals("Linus", creado.getNombre());
    }

    @Test
    void obtenerEmpleadoExistente() {
        Empleado e = new Empleado(null, "Ada", "Lovelace", "ada@history.com", "Analisis", "Activo");
        Empleado creado = service.crear(e);

        Empleado encontrado = service.obtenerPorId(creado.getId());
        assertNotNull(encontrado);
        assertEquals("Ada", encontrado.getNombre());
    }

    @Test
    void obtenerEmpleadoInexistente_LanzaExcepcion() {
        assertThrows(ResourceNotFoundException.class, () -> {
            service.obtenerPorId(999L);
        });
    }
}