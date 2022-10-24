package vilgliom.com.alumnosfragment;

import android.content.Context;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;

import java.io.InputStream;

public class ParserStudents {
    private Student[] students;
    private final InputStream fileStudents;
    private String json;

    public ParserStudents(Context context){
        fileStudents = context.getResources().openRawResource(R.raw.alumnos_notas);

    }

    public boolean Parse(){
        boolean parsed = false;
        students = null;

        try {
            byte[] buffer = new byte[fileStudents.available()];
            fileStudents.read(buffer);
            json = new String(buffer, "UTF-8");
            JSONTokener tokener = new JSONTokener(json);
            JSONArray jsonArray = new JSONArray(tokener);
            students = new Student[jsonArray.length()];
            for(int i = 0; i<jsonArray.length(); i++){
                Student student;
                JSONArray notasJSON;
                Nota[] notas;
                JSONObject jsonObject = jsonArray.getJSONObject(i);
                String nia = jsonObject.getString("nia");
                String nombre = jsonObject.getString("nombre");
                String apellido1 = jsonObject.getString("apellido1");
                String apellido2 = jsonObject.getString("apellido2");
                String nacimiento = jsonObject.getString("fechaNacimiento");
                String email = jsonObject.getString("email");
                notasJSON = jsonObject.getJSONArray("notas");
                notas = new Nota[notasJSON.length()];
                for(int j = 0; j < notasJSON.length(); j++){
                    JSONObject jsonObject1 = jsonObject.getJSONArray("notas").getJSONObject(j);
                    float calificacion = jsonObject1.getLong("calificacion");
                    String codigo = jsonObject1.getString("codAsig");
                    notas[j] = new Nota(calificacion,codigo);
                }
                students[i] = new Student(Double.parseDouble(nia), nombre, apellido1, apellido2, email, notas, nacimiento);
            }

            parsed = true;
        }catch (Exception e){
            Log.e("Excepcion: ", e.getLocalizedMessage());
        }

        return parsed;
    }

    public Student[] getStudents() {

        return students;
    }
}
