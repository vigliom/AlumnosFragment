package vilgliom.com.alumnosfragment;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import java.util.Objects;

public class DetalleActivity extends AppCompatActivity {
    public static final String EXTRATEXTO = "com.jorpelu.fragments.EXTRA_TEXTO";

    public DetalleActivity(){
        super(R.layout.activity_detalle);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if(savedInstanceState==null){
            Student student = (Student) Objects.requireNonNull(getIntent().getSerializableExtra(EXTRATEXTO));
            Bundle bundle = new Bundle();
            bundle.putSerializable(FragmentDetalle.EXTRASTUDENT, student);
            FragmentManager manager = getSupportFragmentManager();
            manager.beginTransaction()
                    .setReorderingAllowed(true)
                    .add(R.id.frgDetalle,FragmentDetalle.class, bundle)
                    .commit();
        }
    }
}
