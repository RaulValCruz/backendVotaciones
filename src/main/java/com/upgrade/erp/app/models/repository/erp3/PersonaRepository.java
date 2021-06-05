package com.upgrade.erp.app.models.repository.erp3;

import com.upgrade.erp.app.models.entity.erp3.Persona;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PersonaRepository extends PagingAndSortingRepository<Persona, Long> {

    List<Persona> getAllByActivoIsTrue();

    /*
     * @Query("select p from Persona p where p.doc_identidad_num=?1") Persona
     * findByDNI(String DNI);
     */

    @Query("select p from Persona p where p.dni=?1 and p.password=?2")
    Persona login(String user, String password);

}
