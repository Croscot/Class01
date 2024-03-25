package com.example.class01;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Fisica extends AppCompatActivity {

    EditText masa, aceleracion;
    TextView resultado;
    Button calcular;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fisica);

        masa = (EditText) findViewById(R.id.edtmasa);
        aceleracion = (EditText) findViewById(R.id.edtaceleracion);
        resultado = (TextView) findViewById(R.id.txtresultado2);
        calcular = (Button) findViewById(R.id.btncalcular2);

        calcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calcularFuerza();
            }
        });
    }

    public void calcularFuerza() {
        boolean masaValida = validarCampoNumerico(masa, "La masa no puede estar vacía",
                "Debe ingresar un número válido para la masa");
        boolean aceleracionValida = validarCampoNumerico(aceleracion, "La aceleración no puede estar vacía",
                "Debe ingresar un número válido para la aceleración");

        if (masaValida && aceleracionValida) {
            float valorMasa = Float.parseFloat(masa.getText().toString());
            float valorAceleracion = Float.parseFloat(aceleracion.getText().toString());
            float fuerza = valorMasa * valorAceleracion;
            String mensaje = getResources().getString(R.string.resultadoOperacion2) + " " + fuerza + "N";
            resultado.setText(mensaje);
        }
    }

    private boolean validarCampoNumerico(EditText campo, String errorVacio, String errorFormato) {
        String texto = campo.getText().toString();
        if (texto.isEmpty()) {
            campo.setError(errorVacio);
            return false;
        }

        try {
            Float.parseFloat(texto);
        } catch (NumberFormatException e) {
            campo.setError(errorFormato);
            return false;
        }

        return true;
    }
}
