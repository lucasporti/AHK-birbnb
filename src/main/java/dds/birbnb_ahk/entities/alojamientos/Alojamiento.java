package dds.birbnb_ahk.entities.alojamientos;

import dds.birbnb_ahk.entities.ubicaciones.Direccion;
import dds.birbnb_ahk.entities.Moneda;
import dds.birbnb_ahk.entities.reservas.RangoFechas;
import dds.birbnb_ahk.entities.reservas.Reserva;
import dds.birbnb_ahk.entities.usuarios.Usuario;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "alojamiento")
public class Alojamiento {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Getter
    @Setter
    @ManyToOne
    @JoinColumn(name = "anfitrion_id", nullable = false)
    private Usuario anfitrion;

    @Getter
    @Setter
    @Column
    private String nombre;

    @Getter
    @Setter
    @Column(columnDefinition = "TEXT")
    private String descripcion;

    @Getter
    @Setter
    @Column
    private Double precioPorNoche;

    @Getter
    @Setter
    @Enumerated(EnumType.STRING)
    private Moneda moneda;

    @Getter
    @Setter
    @Column(columnDefinition = "TIME")
    private LocalTime horarioCheckIn;

    @Getter
    @Setter
    @Column(columnDefinition = "TIME")
    private LocalTime horarioCheckOut;

    @Getter
    @Setter
    @OneToOne
    @JoinColumn(name = "direccion_id", nullable = false)
    private Direccion direccion;

    @Getter
    @Setter
    @Column
    private Double cantHuespedesMax;

    @Getter
    @CollectionTable(name = "alojamiento_caracteristica", joinColumns = @JoinColumn(name = "alojamiento_id"))
    @Enumerated(EnumType.STRING)
    @Column(name = "caracteristica")
    private List<Caracteristica> caracteristicas;

    @Getter
    @OneToMany(mappedBy = "alojamiento")
    private List<Reserva> reservas;

    @Getter
    @OneToMany
    @JoinColumn(name = "alojamiento_id")
    private List<Foto> fotos;

    public Alojamiento(){
        this.fotos = new ArrayList<>();
        this.caracteristicas = new ArrayList<>();
        this.reservas = new ArrayList<>();
    }

    public Boolean tuPrecioEstaDentroDe(Double valorMin, Double valorMax){
        return this.precioPorNoche < valorMax && this.precioPorNoche >= valorMin;
    }
    public Boolean estasDisponibleEn(RangoFechas rangoDeFechas){
        return !this.reservas.stream().anyMatch(r -> r.getRangoFechas().haySuperposicionCon(rangoDeFechas));
    }
    public Boolean tenesCaracteristicas(Caracteristica caracteristica){
        return caracteristicas.contains(caracteristica);
    }
    public Boolean puedenAlojarse(Double cantHuespedes){
        return  cantHuespedes <= this.cantHuespedesMax;
    }

}
