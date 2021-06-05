package com.upgrade.erp.app.controllers.admin;

import com.upgrade.erp.app.controllers.CommonController;
import com.upgrade.erp.app.models.entity.erp3.Rol;
import com.upgrade.erp.app.services.admin.RolService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/admin/rol")
public class RolController extends CommonController<Rol, RolService> {

    @Autowired
    private RolService rolService;

    @GetMapping("/list")
    public ResponseEntity<?> listar() {
        return ResponseEntity.ok(rolService.getAll());
    }

    @PostMapping("/update")
    public ResponseEntity<?> update(@RequestBody Rol rol) {
        return ResponseEntity.ok(rolService.update(rol));
    }

    @PostMapping("/delete")
    public ResponseEntity<?> eliminar(@RequestBody Rol rol) {
        return ResponseEntity.ok(rolService.delete(rol));
    }

    @GetMapping("/list-id")
    public ResponseEntity<?> listar(@RequestBody Rol obj) {
        return ResponseEntity.ok(rolService.findById(obj.getId()));

    }

}