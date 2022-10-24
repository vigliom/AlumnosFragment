package vilgliom.com.alumnosfragment;

import java.io.Serializable;

public class Asignaturas implements Serializable {
    private final String siglas;
    private final String asignatura;

    public String getSiglas() {
        return siglas;
    }
    public String getAsignatura() {
        return asignatura;
    }
    public Asignaturas(String siglas, String asignatura) {
        this.siglas = siglas;
        this.asignatura = asignatura;
    }
}
