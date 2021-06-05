package com.upgrade.erp.app.services;

import java.util.List;
import java.util.Optional;

import com.upgrade.erp.app.models.entity.erp3.Usuario;
import com.upgrade.erp.app.models.repository.erp3.UsuarioRepository;
import com.upgrade.erp.app.services.common.CommonServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UsuarioServiceImpl extends CommonServiceImpl<Usuario, UsuarioRepository> implements UsuarioService {
    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public List<Usuario> getAll() {
        return repository.getAllByActivoIsTrue();
    }

    @Override
    public Usuario update(Usuario usuario) {
        Optional<Usuario> o = this.repository.findById(usuario.getId());
        if (o.orElse(null) == null)
            return usuario;
        Usuario upd = o.get();

        upd.setActivo(usuario.getActivo());
        upd.setUsername(usuario.getUsername());

        if (!usuario.getPassword().isEmpty()) {
            // upd.setPassword(usuario.getPassword());
            upd.setPassword(passwordEncoder.encode(usuario.getPassword()));
        }
        upd.setPersona_id(usuario.getPersona_id());
        upd.setRoles(usuario.getRoles());
        return this.repository.save(upd);
    }

    @Override
    public Usuario delete(Usuario usuario) {
        Optional<Usuario> o = usuarioRepository.findById(usuario.getId());
        if (o.orElse(null) == null)
            return usuario;

        Usuario upd = o.get();
        /*
         * System.out.println(upd.getUsername()); upd.setId(usuario.getId());
         */
        upd.setActivo(false);
        return usuarioRepository.save(upd);
    }

    /*
     * 
     * @Override public Usuario setRol(Usuario usuario) {
     * 
     * 
     * Optional<Usuario> o = usuarioRepository.findById(usuario.getId());
     * if(o.orElse(null) == null) return usuario;
     * 
     * Usuario upd = o.get(); /*System.out.println(upd.getUsername());
     * upd.setId(usuario.getId()); upd.setActivo(false);
     * 
     * 
     * return usuarioRepository.setUsuarioRol(usuario.getId()); }
     */

}
