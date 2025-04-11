package dds.birbnb_ahk.entities;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter

public class RangoFechas {
    private LocalDate fechaInicio;
    private LocalDate fechaFin;

    public boolean haySuperposicionCon(RangoFechas rangoDeFechas) {
        return this.getFechaFin().isBefore(rangoDeFechas.getFechaFin()) &&
                rangoDeFechas.getFechaInicio().isBefore(this.getFechaFin());
    }
}
