package dds.birbnb_ahk.entities.usuarios;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "usuario")

public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    private String nombre;

    @Column
    private String email;

    @Enumerated(EnumType.STRING)
    private TipoUsuario tipo;
}
