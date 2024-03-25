package com.example.class01;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Matematica extends AppCompatActivity {

    Button calcular;
    EditText A, B;
    TextView resultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_matematica);

        A = (EditText) findViewById(R.id.edtpunto1);
        B = (EditText) findViewById(R.id.edtpunto2);
        calcular = (Button) findViewById(R.id.btncalcular1);
        resultado = (TextView) findViewById(R.id.txtresultado1);

        calcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calcularDistanciaEntreDosPuntos();
            }
        });
    }

    public void calcularDistanciaEntreDosPuntos() {
        boolean validarA = validarCampoNumerico(A, "Este campo no puede estar vacio",
                "El punto A tiene un formato inválido. Formato esperado: 'x,y'");
        boolean validarB = validarCampoNumerico(B, "Este campo no puede estar vacio",
                "El punto B tiene un formato inválido. Formato esperado: 'x,y'");

        if (validarA && validarB) {
            String[] coordenadasPunto1 = A.getText().toString().split(",");
            String[] coordenadasPunto2 = B.getText().toString().split(",");
            double x1 = Double.parseDouble(coordenadasPunto1[0]);
            double y1 = Double.parseDouble(coordenadasPunto1[1]);
            double x2 = Double.parseDouble(coordenadasPunto2[0]);
            double y2 = Double.parseDouble(coordenadasPunto2[1]);

            String mensaje = getResources().getString(R.string.resultadoOperacion1);
            double distancia = Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
            resultado.setText(mensaje + " " + distancia);
        }
    }


    private boolean validarCampoNumerico(EditText campo, String errorVacio, String errorFormato) {
        String texto = campo.getText().toString();
        if (texto.isEmpty()) {
            campo.setError(errorVacio);
            return false;
        }

        if (!validarEntradaCoordenadas(texto)) {
            campo.setError(errorFormato);
            return false;
        }

        return true;
    }

    public boolean validarEntradaCoordenadas(String entrada) {
        // Verificar que la entrada siga el patrón "número,número"
        return entrada.matches("^-?\\d+(\\.\\d+)?,-?\\d+(\\.\\d+)?$");
    }
}