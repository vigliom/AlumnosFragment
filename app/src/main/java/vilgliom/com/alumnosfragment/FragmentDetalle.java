package vilgliom.com.alumnosfragment;

import android.content.Context;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class FragmentDetalle extends Fragment {
//    public static final String EXTRATEXTO = "com.jorpelu.fragments.EXTRA_TEXTO";
    public static final String EXTRASTUDENT = "com.jorpelu.fragmentStudents.EXTRA_STUDENT";
    private Student student;


    public FragmentDetalle(){
        super(R.layout.fragment_detalle);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if(getArguments() != null){
            student = (Student) getArguments().getSerializable(EXTRASTUDENT);

        }
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        if (student != null)
            mostrarDetalle(student, view);

    }
    public void mostrarDetalle(Student student, View view){
        Nota[] notas = student.getNotas();
        RecyclerView rv = view.findViewById(R.id.frgDetalle_rvLista);
        rv.setAdapter(new AdaptadorDetalle(notas));
        rv.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));

    }



}
