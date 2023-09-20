package nikalas.nunev.a04_ejemploenviaryrecibirinformacion;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import nikalas.nunev.a04_ejemploenviaryrecibirinformacion.modelos.Usuario;

public class MainActivity extends AppCompatActivity {
    private EditText txtEmail;
    private EditText txtPassword;
    private Button btnDesencriptar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        inicializarVista();

        btnDesencriptar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = txtEmail.getText().toString();
                String password = txtPassword.getText().toString();

                if (password.isEmpty() || email.isEmpty()){
                    Toast.makeText(MainActivity.this, "Faltan Datos", Toast.LENGTH_SHORT).show();
                }else {
                    //Enviar info a la segunda actividad
                    Intent intent = new Intent(MainActivity.this,DesencriptarActivity.class);
                    //antes de iniciar la actividad hay que pasar informacion
                    //se crea un contenedor
                    Bundle bundle = new Bundle();
                    //rellenas con la info que quieras -- uno por uno
                    //bundle.putString("EMAIL",email);
                    //bundle.putString("PASS", password);

                    //de golpe
                    bundle.putSerializable("USER", new Usuario(email,password));
                    //pasar el contenedor al intent para que pase la info
                    intent.putExtras(bundle);
                    startActivity(intent);
                }
            }
        });
    }

    private void inicializarVista() {
        txtEmail = findViewById(R.id.txtEmailMain);
        txtPassword = findViewById(R.id.txtPasswordMain);
        btnDesencriptar = findViewById(R.id.btnDesencriptarMain);
    }
}