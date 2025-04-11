package dds.birbnb_ahk.repositories;

import dds.birbnb_ahk.entities.ubicaciones.Pais;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaisRepository extends JpaRepository<Pais, Long>{

}
