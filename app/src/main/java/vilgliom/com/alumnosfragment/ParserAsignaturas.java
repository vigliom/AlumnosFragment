package vilgliom.com.alumnosfragment;

import android.content.Context;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;

import java.io.InputStream;

public class ParserAsignaturas {
    private Asignaturas[] asignaturas;
    private final InputStream fileAsignaturas;
    private String json;

    public ParserAsignaturas(Context context){
        this.fileAsignaturas = context.getResources().openRawResource(R.raw.asignaturas);
    }

    public boolean Parse(){
        boolean parsed = false;
        asignaturas = null;
        try {
                byte[] buffer = new byte[fileAsignaturas.available()];
                fileAsignaturas.read(buffer);
                json = new String(buffer, "UTF-8");
                JSONTokener tokener = new JSONTokener(json);
                JSONArray jsonArray = new JSONArray(tokener);
                asignaturas = new Asignaturas[jsonArray.length()];
                for (int i = 0; i < jsonArray.length(); i++){
                    JSONObject object= jsonArray.getJSONObject(i);
                    Asignaturas asignatura;
                    String asignatura1= object.getString("nomAsig");
                    String siglas = object.getString("codAsig");
                    asignatura = new Asignaturas(siglas,asignatura1);
                    this.asignaturas[i] = asignatura;
                }

                parsed = true;

        }catch (Exception e){
            Log.e("Uknown Exception: " ,e.getLocalizedMessage());
        }
        return parsed;
    }
    public Asignaturas[] getAsignaturas(){
        return asignaturas;
    }
}
