package co.edu.poli.examen2.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import co.edu.poli.examen2.model.Producto;
import co.edu.poli.examen2.services.ProductoService;

@RestController
@RequestMapping("/api/v1/productos")
public class ProductoController {

    @Autowired
    private ProductoService productoService;

    @GetMapping
    public ResponseEntity<List<Producto>> getAllProductos() {
        List<Producto> productos = productoService.getAllProductos();
        return ResponseEntity.ok(productos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Producto> getProductoById(@PathVariable String id) {
        Producto producto = productoService.getProductoById(id);
        if (producto != null) {
            return ResponseEntity.ok(producto);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<Producto> saveProducto(@RequestBody Producto producto) {
        Producto savedProducto = productoService.saveProducto(producto);
        return ResponseEntity.ok(savedProducto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Producto> updateProducto(@PathVariable String id, @RequestBody Producto producto) {
        producto.setId(id); // aseguramos que el id sea correcto
        Producto updatedProducto = productoService.updateProducto(producto);
        if (updatedProducto != null) {
            return ResponseEntity.ok(updatedProducto);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Producto> deleteProducto(@PathVariable String id) {
        Producto deletedProducto = productoService.deleteProducto(id);
        if (deletedProducto != null) {
            return ResponseEntity.ok(deletedProducto);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
