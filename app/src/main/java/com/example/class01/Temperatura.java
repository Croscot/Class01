package com.example.class01;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import org.w3c.dom.Text;

public class Temperatura extends AppCompatActivity {

    Spinner tipotemp;
    EditText temp;
    TextView resultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_temperatura);

        resultado = (TextView) findViewById(R.id.txtresultado3);
        tipotemp = (Spinner) findViewById(R.id.spinnerTemp);
        temp = (EditText) findViewById(R.id.edtTemp);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(
                this,
                R.array.escalas_temperaturas,
                android.R.layout.simple_spinner_item
        );

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_item);
        tipotemp.setAdapter(adapter);

        tipotemp.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String itemSeleccionado = parent.getItemAtPosition(position).toString(),
                        escala = "", textoEntrada = temp.getText().toString();
                if (!textoEntrada.isEmpty()) {
                    try {
                        double inputCelsius = Double.parseDouble(textoEntrada);
                        double valorConvertido;

                        switch (itemSeleccionado) {
                            case "Fahrenheit":
                                valorConvertido = celsiusAFahrenheit(inputCelsius);
                                escala = "°F";
                                break;
                            case "Kelvin":
                                valorConvertido = celsiusAKelvin(inputCelsius);
                                escala = "°K";
                                break;
                            case "Rankine":
                                valorConvertido = celsiusARankine(inputCelsius);
                                escala = "°R";
                                break;
                            default:
                                valorConvertido = inputCelsius;
                                break;
                        }

                        mostrarResultado(valorConvertido, escala);
                    } catch (NumberFormatException e) {
                        temp.setError("Por favor. ingrese un número válido");
                    }
                } else {
                    temp.setError("Este campo no puede estar vacio");
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    public double celsiusAFahrenheit(double celsius) {
        return (celsius * 9/5) + 32;
    }

    public double celsiusAKelvin(double celsius) {
        return celsius + 273.15;
    }

    public double celsiusARankine(double celsius) {
        return (celsius * 9/5) + 491.67;
    }

    public void mostrarResultado(double valorConvertido, String escala) {
        resultado.setText(valorConvertido + escala);
    }
}
