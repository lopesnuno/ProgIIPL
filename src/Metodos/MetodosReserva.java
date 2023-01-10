package Metodos;

import Entidades.Reserva;
import Repositorio.Repositorio;

public class MetodosReserva {
    public static Reserva selectReservaPorMatricula(String matricula) {
        for (Reserva r : Repositorio.getInstance().getReservas()) {
            if (r.getCarro().getMatricula().equals(matricula)) {
                return r;
            }
        }
        return null;
    }

    public static void removeReserva(Reserva reserva) {
        Repositorio.getInstance().getReservas().removeIf(r -> r.getCarro().getMatricula()
                .equals(reserva.getCarro().getMatricula()));
    }
}
