package dds.birbnb_ahk.entities;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class Alojamiento {
    @Getter
    @Setter
    private Usuario anfitrion;

    @Getter
    @Setter
    private String nombre;

    @Getter
    @Setter
    private String descripcion;

    @Getter
    @Setter
    private Double precioPorNoche;

    @Getter
    @Setter
    private Moneda moneda;

    @Getter
    @Setter
    private LocalTime horarioCheckIn;

    @Getter
    @Setter
    private LocalTime horarioCheckOut;

    @Getter
    @Setter
    private Direccion direccion;

    @Getter
    @Setter
    private Double cantHuespedesMax;

    @Getter
    private List<Caracteristica> caracteristicas;

    @Getter
    private List<Reserva> reservas;

    @Getter
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
