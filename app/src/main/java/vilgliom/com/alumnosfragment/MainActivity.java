package vilgliom.com.alumnosfragment;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentOnAttachListener;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity implements IClickListener, FragmentOnAttachListener {
    private FragmentLista frgLista;
    private FragmentDetalle frgDetalle;
    boolean tabletLayout;
    private Student[] students;

    public MainActivity (){
        super(R.layout.activity_main);
        frgLista = new FragmentLista();
        frgDetalle = new FragmentDetalle();
        tabletLayout = false;


    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        tabletLayout = findViewById(R.id.frgDetalle) != null;

        if (savedInstanceState == null) {
            FragmentManager manager = getSupportFragmentManager();
            manager.beginTransaction()
                    .setReorderingAllowed(true)
                    .add(R.id.frgLista, FragmentLista.class,null)
                    .commit();
            manager.addFragmentOnAttachListener(this);

        }
    }



    @Override
    public void onAttachFragment(@NonNull FragmentManager fragmentManager, @NonNull Fragment fragment) {
        if(fragment.getId() == R.id.frgLista){
            frgLista = (FragmentLista) fragment;
            frgLista.setStudentsListener(this);
            if(tabletLayout){
                Bundle bundle = new Bundle();
                bundle.putSerializable(FragmentDetalle.EXTRATEXTO, frgLista.getStudents()[0]);
                FragmentManager manager = getSupportFragmentManager();
                manager.beginTransaction().setReorderingAllowed(true)
                        .add(R.id.frgDetalle, FragmentDetalle.class, bundle)
                        .commit();
            }

        }
        if(fragment.getId()==R.id.frgDetalle){
            frgDetalle = (FragmentDetalle) fragment;
        }
    }

    @Override
    public void onClick(int pos, View view) {
        this.students = frgLista.getStudents();
        if(tabletLayout){
            frgDetalle.mostrarDetalle(students[pos], view);
        }else{
            Intent i = new Intent(this,DetalleActivity.class);
            i.putExtra(FragmentDetalle.EXTRATEXTO, students[pos]);
            startActivity(i);
        }
    }
}