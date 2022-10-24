package vilgliom.com.alumnosfragment;

import android.util.Log;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.chrono.ChronoLocalDate;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class Student implements Serializable {
    private final double nia;
    private final String name;
    private final String apellido1;
    private final String apellido2;
    private final String edad;
    private final Nota[] notas;
    private final String email;

    public String getEdad() {
            int age = 0;
        try {
                Calendar birth = new GregorianCalendar();
                Calendar today = new GregorianCalendar();
                int factor = 0;

                Date birthDate = new SimpleDateFormat("yyyy-MM-dd").parse(this.edad);
                Date currentDate = new Date();
                birth.setTime(birthDate);
                today.setTime(currentDate);
                if (today.get(Calendar.MONTH) <= birth.get(Calendar.MONTH)) {
                    if (today.get(Calendar.MONTH) == birth.get(Calendar.MONTH)) {
                        if (today.get(Calendar.DATE) > birth.get(Calendar.DATE)) {
                            factor = -1;
                        }
                    } else {
                        factor = -1;
                    }
                }
                age = (today.get(Calendar.YEAR) - birth.get(Calendar.YEAR)) + factor;

            } catch (ParseException e) {
                Log.e("ParseException: ", String.valueOf(e));
            }
        return String.valueOf(age);
    }
    public String getName() {
        return name;
    }
    public String getApellido1() {
        return apellido1;
    }
    public String getApellido2() {
        return apellido2;
    }
    public String getEmail() {
        return email;
    }
    public Nota[] getNotas() {
        return notas;
    }
    public Student(double nia, String name, String apellido1, String apellido2, String email, Nota[] notas, String edad) {
        this.nia = nia;
        this.name = name;
        this.apellido1 = apellido1;
        this.apellido2 = apellido2;
        this.email = email;
        this.notas = notas;
        this.edad = edad;
    }
}
