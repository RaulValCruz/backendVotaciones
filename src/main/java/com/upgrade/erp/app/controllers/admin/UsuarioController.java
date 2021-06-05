package com.upgrade.erp.app.controllers.admin;

import javax.validation.Valid;
import com.upgrade.erp.app.controllers.CommonController;
import com.upgrade.erp.app.models.entity.erp3.Persona;
import com.upgrade.erp.app.models.entity.erp3.Usuario;
import com.upgrade.erp.app.services.UsuarioService;
import com.upgrade.erp.app.services.admin.PersonaService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admin/usuario")
public class UsuarioController extends CommonController<Usuario, UsuarioService> {

    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private PersonaService personaService;

    @GetMapping("/list")
    public ResponseEntity<?> listar() {
        return ResponseEntity.ok(usuarioService.getAll());
    }

    @PostMapping("/update")
    public ResponseEntity<?> update(@RequestBody Usuario usuario) {
        return ResponseEntity.ok(usuarioService.update(usuario));
    }

    @PostMapping("/delete")
    public ResponseEntity<?> eliminar(@RequestBody Usuario usuario) {
        return ResponseEntity.ok(usuarioService.delete(usuario));
    }

    @Override
    public ResponseEntity<?> crear(@Valid @RequestBody Usuario usuario, BindingResult result) {
        if (result.hasErrors()) {
            return this.validar(result);
        }
        Usuario upd = usuario;

        upd.setPassword(passwordEncoder.encode(usuario.getPassword()));

        // crear persona al momento de ingresar por primera vez
        Persona p = new Persona();
        p.setDNI(upd.getUsername());
        personaService.save(p);

        // upd.setPersona_id(personaService.findByDNI(upd.getUsername()).getId());

        // upd.setrol_id(Long.valueOf("1"));
        return super.crear(upd, result);

        // return ResponseEntity.ok(usuarioService.crear(usuario));
    }

    @GetMapping("/list-id")
    public ResponseEntity<?> listar_id(@RequestBody Usuario obj) {
        // return ResponseEntity.ok(rolService.getAll());
        return ResponseEntity.ok(usuarioService.findById(obj.getId()));

    }

}
