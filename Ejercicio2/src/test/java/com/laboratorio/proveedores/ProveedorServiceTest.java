package com.laboratorio.proveedores;

import com.laboratorio.proveedores.exception.ResourceNotFoundException;
import com.laboratorio.proveedores.model.Proveedor;
import com.laboratorio.proveedores.service.ProveedorService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ProveedorServiceTest {

    private ProveedorService service;

    @BeforeEach
    void setUp() {
        service = new ProveedorService();
    }

    @Test
    void crearProveedor_Exitoso() {
        Proveedor p = new Proveedor(null, "Bill", "Gates", "bill@microsoft.com", "Tecnologia", "Activo");
        Proveedor creado = service.crear(p);

        assertNotNull(creado.getId());
        assertEquals("Bill", creado.getNombre());
    }

    @Test
    void obtenerProveedorExistente() {
        Proveedor p = new Proveedor(null, "Steve", "Jobs", "steve@apple.com", "Hardware", "Activo");
        Proveedor creado = service.crear(p);

        Proveedor encontrado = service.obtenerPorId(creado.getId());
        assertNotNull(encontrado);
        assertEquals("Steve", encontrado.getNombre());
    }

    @Test
    void obtenerProveedorInexistente_LanzaExcepcion() {
        assertThrows(ResourceNotFoundException.class, () -> {
            service.obtenerPorId(999L);
        });
    }
}