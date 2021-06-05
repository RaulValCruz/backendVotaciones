package com.upgrade.erp.app.services.admin;

import com.upgrade.erp.app.models.entity.erp3.Persona;
import com.upgrade.erp.app.models.repository.erp3.PersonaRepository;
import com.upgrade.erp.app.services.common.CommonServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PersonaServiceImpl extends CommonServiceImpl<Persona, PersonaRepository> implements PersonaService {

    @Override
    public List<Persona> getAll() {
        return repository.getAllByActivoIsTrue();
    }

    @Override
    public Persona update(Persona persona) {
        Optional<Persona> o = this.repository.findById(persona.getId());
        if (o.orElse(null) == null)
            return persona;
        Persona upd = o.get();
        upd.setDNI(persona.getDNI());
        upd.setPassword(persona.getPassword());
        upd.setNombres(persona.getNombres());
        upd.setApellidoMaterno(persona.getApellidoMaterno());
        upd.setApellidoPaterno(persona.getApellidoPaterno());
        upd.setDireccion(persona.getDireccion());
        upd.setTelefono(persona.getTelefono());
        upd.setRegion(persona.getRegion());
        upd.setProvincia(persona.getProvincia());
        upd.setDistrito(persona.getDistrito());
        upd.setCentroVotacion(persona.getCentroVotacion());
        upd.setMesa(persona.getMesa());
        upd.setActivo(persona.getActivo());
        return this.repository.save(upd);
    }

    @Override
    public Persona delete(Persona persona) {
        Optional<Persona> o = this.repository.findById(persona.getId());
        if (o.orElse(null) == null)
            return persona;
        Persona upd = o.get();
        upd.setActivo(false);
        return this.repository.save(upd);
    }

    /*
     * @Override public Persona findByDNI(String dni) { return
     * repository.findByDNI(dni); }
     */

    @Override
    public Persona login(String user, String password) {
        return repository.login(user, password);
    }

}
