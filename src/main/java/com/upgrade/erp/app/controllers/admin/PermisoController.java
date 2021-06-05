package com.upgrade.erp.app.controllers.admin;

import com.upgrade.erp.app.controllers.CommonController;
import com.upgrade.erp.app.models.entity.erp3.Permisos;
import com.upgrade.erp.app.services.admin.PermisoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("admin/permisos")
public class PermisoController extends CommonController<Permisos, PermisoService> {

    @Autowired
    private PermisoService permisoService;

    @GetMapping("/list")
    public ResponseEntity<?> listar() {
        return ResponseEntity.ok(permisoService.getAll());
    }

    @PostMapping("/update")
    public ResponseEntity<?> update(@RequestBody Permisos permiso) {
        return ResponseEntity.ok(permisoService.update(permiso));
    }

    @PostMapping("/delete")
    public ResponseEntity<?> eliminar(@RequestBody Permisos permiso) {
        return ResponseEntity.ok(permisoService.delete(permiso));
    }

}
