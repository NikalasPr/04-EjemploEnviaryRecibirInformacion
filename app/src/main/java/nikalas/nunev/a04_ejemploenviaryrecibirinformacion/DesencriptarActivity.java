package nikalas.nunev.a04_ejemploenviaryrecibirinformacion;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NavUtils;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import nikalas.nunev.a04_ejemploenviaryrecibirinformacion.modelos.Usuario;

public class DesencriptarActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_desencriptar);

        //recibir el intent en la ventana junto a la info del bundle
        Intent intent = getIntent();
        //sacar
        Bundle bundle = intent.getExtras();
        //si el bundle recibe informacion
        if (bundle != null){
            //sacar info usando una key -- uno a uno
            //String email = bundle.getString("EMAIL");
            //String password = bundle.getString("PASS");
            //Usuario usuario = new Usuario(email,password);
            //Sacar el objeto de golpe
            Usuario usuario = (Usuario) bundle.getSerializable("USER");
            //mostrarla por pantalla
            Toast.makeText(this, usuario.toString(), Toast.LENGTH_SHORT).show();
        }

    }
}