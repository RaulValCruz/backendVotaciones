package com.upgrade.erp.app.models.repository.erp3;

import com.upgrade.erp.app.models.entity.erp3.Usuario;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UsuarioRepository extends PagingAndSortingRepository<Usuario, Long> {

    @Query("select u from Usuario u where u.username=?1")
    Optional<Usuario> findByUsername(@Param("username") String username);

    @Query("select u from Usuario u where u.username=?1")
    Usuario obtenerPorUsername(String username);

    List<Usuario> getAllByActivoIsTrue();

}
