package com.upgrade.erp.app.controllers.admin;

import javax.validation.Valid;

import com.upgrade.erp.app.controllers.CommonController;
import com.upgrade.erp.app.models.entity.erp3.Persona;
import com.upgrade.erp.app.services.admin.PersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admin/persona")
public class PersonaController extends CommonController<Persona, PersonaService> {

    @Autowired
    private PersonaService personaService;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody String user, @RequestBody String password) {

        Persona p = personaService.login(user, password);
        Persona aux = new Persona();

        if (p != null) {
            System.out.println("HERE if");
            return ResponseEntity.ok(p);
        } else {
            System.out.println("HERE else");

            return ResponseEntity.ok("Error");
        }

    }

    @Override
    public ResponseEntity<?> crear(@Valid @RequestBody Persona persona, BindingResult result) {
        if (result.hasErrors()) {
            return this.validar(result);
        }

        Persona p = personaService.login(persona.getDNI(), persona.getPassword());
        Persona aux = persona;

        if (p != null) {
            // System.out.println("HERE if");
            return ResponseEntity.ok(p);
        } else {
            // System.out.println("HERE else");
            personaService.save(aux);
            return ResponseEntity.ok(aux);
        }

    }

    @GetMapping("/list")
    // @PreAuthorize("hasAuthority('ADMIN_MTTO') or hasAuthority('ADMIN_MTTO')")
    public ResponseEntity<?> listar() {
        return ResponseEntity.ok(personaService.getAll());
    }

    @PostMapping("/update")
    // @PreAuthorize("hasAuthority('ADMIN_MTTO') or hasAuthority('ADMIN_MTTO')")
    public ResponseEntity<?> update(@RequestBody Persona persona) {
        return ResponseEntity.ok(personaService.update(persona));
    }

    @PostMapping("/delete")
    // @PreAuthorize("hasAuthority('ADMIN_MTTO') or hasAuthority('ADMIN_MTTO')")
    public ResponseEntity<?> eliminar(@RequestBody Persona persona) {
        return ResponseEntity.ok(personaService.delete(persona));
    }
}
