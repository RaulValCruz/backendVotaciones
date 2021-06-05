package com.upgrade.erp.app.controllers.admin;

import com.upgrade.erp.app.controllers.CommonController;
import com.upgrade.erp.app.models.entity.erp3.Ubigeo;
import com.upgrade.erp.app.services.UbigeoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admin/ubigeo")
public class UbigeoController extends CommonController<Ubigeo, UbigeoService> {

    @Autowired
    private UbigeoService ubigeoService;

    @GetMapping("/departamentos")
    public ResponseEntity<?> listar() {
        return ResponseEntity.ok(ubigeoService.getDepartamentos());
    }

    @GetMapping("/regiones/{dpto}")
    public ResponseEntity<?> regiones(@PathVariable String dpto) {
        return ResponseEntity.ok(ubigeoService.getRegionesByDpto(dpto));
    }

    @GetMapping("/distritos/{dpto}/{prov}")
    public ResponseEntity<?> distritos(@PathVariable String dpto, @PathVariable String prov) {
        return ResponseEntity.ok(ubigeoService.getDistritosByRegion(dpto, prov));
    }

}
