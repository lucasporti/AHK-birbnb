package dds.birbnb_ahk.controllers;

import dds.birbnb_ahk.entities.ubicaciones.Pais;
import dds.birbnb_ahk.repositories.PaisRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/paises")
public class PaisesController {
    @Autowired
    private PaisRepository paisRepository;

    @GetMapping
    public ResponseEntity<List<Pais>> generarPaises() {
        Pais argentina = new Pais("argentina");
        Pais brasil = new Pais("brasil");
        Pais uruguay = new Pais("uruguay");
        Pais francia = new Pais("francia");

        //esto genera un insert en la base
        this.paisRepository.save(argentina);
        this.paisRepository.save(brasil);
        this.paisRepository.save(uruguay);
        this.paisRepository.save(francia);

        // tambien podemos hacer
        //this.paisRepository.saveAll(List.of(brasil,uruguay,francia,argentina));

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(List.of(argentina,brasil,uruguay));
    }
}
