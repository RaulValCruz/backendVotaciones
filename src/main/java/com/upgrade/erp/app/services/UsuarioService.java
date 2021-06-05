package com.upgrade.erp.app.services;

import com.upgrade.erp.app.models.entity.erp3.Usuario;
import java.util.List;
import com.upgrade.erp.app.services.common.CommonService;

public interface UsuarioService extends CommonService<Usuario> {

    List<Usuario> getAll();

    Usuario update(Usuario usuario);

    Usuario delete(Usuario usuario);
    // Usuario setRol(Usuario usuario);

}
