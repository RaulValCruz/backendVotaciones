package com.upgrade.erp.app.controllers.admin;

import com.upgrade.erp.app.controllers.CommonController;
import com.upgrade.erp.app.models.entity.erp3.MesaSufragio;
import com.upgrade.erp.app.services.admin.MesaSufragioService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("admin/mesa")
public class MesaSufragioController extends CommonController<MesaSufragio, MesaSufragioService> {

    @Autowired
    private MesaSufragioService mesaSufragioService;

    @GetMapping("get/{nro_mesa}")
    public ResponseEntity<?> getMesa(@PathVariable String nro_mesa) {
        return ResponseEntity.ok(mesaSufragioService.findByNroMesa(nro_mesa));
    }

}
