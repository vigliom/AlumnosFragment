package vilgliom.com.alumnosfragment;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


public class AdaptadorDetalle extends RecyclerView.Adapter<AdaptadorDetalle.DetlleViewHolder> {
    private final Nota[] notas;    //<- Creanmos la variable donde vamos a guardar la lista de notas

    public AdaptadorDetalle(Nota[] notas) {
        this.notas = notas;     //<- Rellenamos nuestro Array `con los daatos enviados en el constructor
    }

    /**
     * Cojemos el layout del item y mediante el LayoutInflater lo ponemos repetidamente la pantalla
     *
     * @param parent            origen desde donde se llama al Adaptador
     * @param viewType          nose
     * @return                  Devuelve un HolderView ya relleno
     */
    @NonNull
    @Override
    public DetlleViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        final View item = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_detalle, parent, false);
        return new DetlleViewHolder(item);
    }

    /**
     * El seleccionamos la nota que vamos vamos a rellenar en el layout y la enviamos al bindNotas;
     * @param holder                Clase DetalleViewHolder, la vista a rellenar
     * @param position              posicion dentro del Array
     */
    @Override
    public void onBindViewHolder(@NonNull DetlleViewHolder holder, int position) {
        Nota nota = notas[position];
        holder.bindNotas(nota);
    }

    /**
     * Devuelve el tamaño del Array
     * @return      notas
     */
    @Override
    public int getItemCount() {
        return notas.length;
    }

    /*
     * Clase detalle ViewHolder, Sirve para enlazar los datos con la vista
     */
    public static class DetlleViewHolder extends RecyclerView.ViewHolder{
        private final TextView siglas;
        private final TextView asignatura;
        private final TextView nota;
        Asignaturas[] asignaturas;

        /**
         * Constructor de la clase, recibe el item a rellenar y les asigna a los textView una id
         * @param item      Vista a rellenar
         */
        public DetlleViewHolder (@NonNull View item){
            super(item);
            this.siglas = item.findViewById(R.id.itemDetalle_tvSiglas);
            this.asignatura = item.findViewById(R.id.itemDetalle_tvAsignatura);
            this.nota = item.findViewById(R.id.itemDetalle_tvNota);
        }

        /**
         * Recibe nota y la graba en la vista
         * @param nota      Nota a grabar
         */
        public void bindNotas(Nota nota){
            this.asignaturas = parseAsignaturas(itemView.getContext());
            siglas.setText(nota.getSiglasNota());
            /*
            Comprobacion de las siglas para rellenar los datoss
             */
            for (Asignaturas value : asignaturas) {
                if (value.getSiglas().equals(siglas.getText().toString())) {
                    this.asignatura.setText(value.getAsignatura());
                }
            }
            this.nota.setText(String.valueOf(nota.getNota()));
        }

        /**
         * Devuelve el Array de asignaturas, Llama al parser y lee los datos en el parser
         * @param context           Contexto de la actividad
         * @return                  Devuelve el Array completado
         */
        private Asignaturas[] parseAsignaturas(Context context){
            Asignaturas[] asignaturas;
            ParserAsignaturas parserAsignaturas = new ParserAsignaturas(context);
            parserAsignaturas.Parse();
            asignaturas = parserAsignaturas.getAsignaturas();
            return asignaturas;
        }

    }


}
