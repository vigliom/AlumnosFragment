package vilgliom.com.alumnosfragment;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

public class DetalleActivity extends AppCompatActivity {
    public static final String EXTRATEXTO = "com.jorpelu.fragments.EXTRA_TEXTO";

    public DetalleActivity(){
        super(R.layout.activity_detalle);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if(savedInstanceState==null){
            Student student = (Student) getIntent().getSerializableExtra(EXTRATEXTO);
            Bundle bundle = new Bundle();
            bundle.putSerializable(FragmentDetalle.EXTRATEXTO, student);
            FragmentManager manager = getSupportFragmentManager();
            manager.beginTransaction()
                    .setReorderingAllowed(true)
                    .add(R.id.frgDetalle,FragmentDetalle.class, bundle)
                    .commit();
        }
    }
}
