package vilgliom.com.alumnosfragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class AdaptadorLista extends RecyclerView.Adapter<AdaptadorLista.ListaViewHolder> {
    private final Student[] students;
    private final IClickListener listener;

    public AdaptadorLista(Student[] students, IClickListener listener) {
        this.students = students;
        this.listener = listener;
    }

    @NonNull
    @Override
    public ListaViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        final View item = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_lista, parent, false);
        return new ListaViewHolder(item, listener);

    }

    @Override
    public void onBindViewHolder(@NonNull ListaViewHolder holder, int position) {
        Student student = students[position];
        holder.bindLista(student);
    }


    @Override
    public int getItemCount() {

        return students.length;
    }

    public static class ListaViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        private final TextView tvName;
        private final TextView tvEmail;
        private final TextView tvEdad;
        private final IClickListener listener;

        public ListaViewHolder(@NonNull View itemView, IClickListener listener){
            super(itemView);
            tvName = itemView.findViewById(R.id.itemLista_tvName);
            tvEmail = itemView.findViewById(R.id.itemLista_tvEmail);
            tvEdad = itemView.findViewById(R.id.itemLista_tvEdad);
            this.listener = listener;
            itemView.setOnClickListener(this);
        }

        public void bindLista(Student student){
            String name = student.getName().concat(" ").concat(student.getApellido1()).concat(" ").concat(student.getApellido2());
            tvName.setText(name);
            tvEmail.setText(student.getEmail());
            tvEdad.setText(student.getEdad());
        }


        @Override
        public void onClick(View view) {
            if(listener!=null){

                listener.onClick(getAdapterPosition(), view);
            }
        }
    }
}
