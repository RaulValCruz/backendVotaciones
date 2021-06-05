package com.upgrade.erp.app.controllers;

import com.upgrade.erp.app.models.entity.erp3.DocIdentidadTipo;
import com.upgrade.erp.app.services.DocIdentidadTipoService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/admin/documento-identidad-tipo")
public class DocIdentidadTipoController extends CommonController<DocIdentidadTipo, DocIdentidadTipoService> {

}
