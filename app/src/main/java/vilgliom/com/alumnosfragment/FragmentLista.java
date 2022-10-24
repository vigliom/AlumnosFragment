package vilgliom.com.alumnosfragment;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class FragmentLista extends Fragment {
    private Student[] students;
    private IClickListener listener;

    public FragmentLista(){
        super(R.layout.fragment_lista);
    }
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ParserStudents parserStudents = new ParserStudents(getContext());
        if(parserStudents.Parse()) {
            this.students = parserStudents.getStudents();
        }
        RecyclerView rv = view.findViewById(R.id.FrgLista_rv);
        rv.setAdapter(new AdaptadorLista(students,listener));
        rv.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false));
    }
    public Student[] getStudents(){
        return this.students;
    }
    public void setStudentsListener(IClickListener listener){
        this.listener = listener;

    }

}