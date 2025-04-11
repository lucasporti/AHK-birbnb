package dds.birbnb_ahk.entities.reservas;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter

@Embeddable
public class RangoFechas {
    @Column(columnDefinition = "DATE")
    private LocalDate fechaInicio;
    @Column(columnDefinition = "DATE")
    private LocalDate fechaFin;

    public boolean haySuperposicionCon(RangoFechas rangoDeFechas) {
        return this.getFechaFin().isBefore(rangoDeFechas.getFechaFin()) &&
                rangoDeFechas.getFechaInicio().isBefore(this.getFechaFin());
    }
}
