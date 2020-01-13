package com.example.proyecto704;

import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    //onClick
    public void mostrar(View view)
	{
        TextView tv1 = (TextView)findViewById(R.id.tv1);
        tv1.setText("");
        try
        {
            //Abre un flujo desde la carpeta raw donde se encuentra un fichero.txt
            BufferedReader fichero = new BufferedReader(new InputStreamReader(getResources().openRawResource(R.raw.fichero)));
			String lectura = fichero.readLine();

            //Le su contenido y lo mete en un StringBuilder
            StringBuilder sb = new StringBuilder();
            while(lectura != null)
            {
                sb.append(lectura + "\n");
                lectura = fichero.readLine();
            }

            //muestra el stringBuilder
			tv1.setText(sb);
            //Cierrra el flujo/fichero
            fichero.close();
        }
        catch (IOException e)
        {
            Toast.makeText(this, e.getMessage(), Toast.LENGTH_LONG).show();
        }
    }
}
