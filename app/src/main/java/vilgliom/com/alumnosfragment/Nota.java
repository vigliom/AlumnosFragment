package vilgliom.com.alumnosfragment;

import java.io.Serializable;

public class Nota implements Serializable {
    private final float nota;
    private final String siglasNota;

    public Nota(float nota, String siglasNota) {
        this.nota = nota;
        this.siglasNota = siglasNota;
    }

    public float getNota() {
        return nota;
    }
    public String getSiglasNota() {
        return siglasNota;
    }
}
