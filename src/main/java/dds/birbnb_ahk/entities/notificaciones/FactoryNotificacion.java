package dds.birbnb_ahk.entities.notificaciones;

import dds.birbnb_ahk.entities.reservas.EstadoReserva;
import dds.birbnb_ahk.entities.reservas.Reserva;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class FactoryNotificacion {
    private String crearMensaje(EstadoReserva estado, Reserva reserva){
        return switch(estado){
            case PENDIENTE ->  "Tenes una reserva de " + reserva.getHuesped() + ", para el alojamiento " + reserva.getAlojamiento().getNombre() + ", desde el día " + reserva.getRangoFechas().getFechaInicio().toString() + " hasta el día " + reserva.getRangoFechas().getFechaFin().toString() + ".";
            case CONFIRMADA -> "La reserva para el alojamiento " + reserva.getAlojamiento().getNombre() + ", desde el día " + reserva.getRangoFechas().getFechaInicio().toString() + " hasta el día " + reserva.getRangoFechas().getFechaFin().toString() + " fue confirmada.";
            case CANCELADA -> "La reserva de " + reserva.getHuesped() + ", para el alojamiento " + reserva.getAlojamiento().getNombre() + ", desde el día " + reserva.getRangoFechas().getFechaInicio().toString() + " hasta el día " + reserva.getRangoFechas().getFechaFin().toString() + ", fue CANCELADA.";
        };
    }

    public Notificacion crearSegunReserva(Reserva reserva){
        Notificacion noti = new Notificacion();

        if(reserva.getEstado().equals(EstadoReserva.PENDIENTE)){
            noti.setUsuario(reserva.getAlojamiento().getAnfitrion());
        } else if (reserva.getEstado().equals(EstadoReserva.CONFIRMADA)) {
            noti.setUsuario(reserva.getHuesped());
        }else if(reserva.getEstado().equals(EstadoReserva.CANCELADA)){
            noti.setUsuario(reserva.getAlojamiento().getAnfitrion());
        }

        noti.setMensaje(this.crearMensaje(reserva.getEstado(), reserva));

        return noti;
    }
}
