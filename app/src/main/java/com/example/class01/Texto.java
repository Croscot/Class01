package com.example.class01;

import android.graphics.Typeface;
import android.os.Bundle;

import android.util.TypedValue;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

public class Texto extends AppCompatActivity {

    EditText entrada;
    ImageButton aumentar, disminuir;
    CheckBox negrita, cursiva;
    float textSize = 18;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_texto);

        entrada = (EditText) findViewById(R.id.edttexto);
        aumentar = (ImageButton) findViewById(R.id.btnaumentar);
        disminuir = (ImageButton) findViewById(R.id.btndisminuir);
        negrita = (CheckBox) findViewById(R.id.checknegrita);
        cursiva = (CheckBox) findViewById(R.id.checkcursiva);

        aumentar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textSize++;
                entrada.setTextSize(TypedValue.COMPLEX_UNIT_SP, textSize);
            }
        });

        disminuir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textSize--;
                entrada.setTextSize(TypedValue.COMPLEX_UNIT_SP, textSize);
            }
        });

        negrita.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                actualizarEstilo();
            }
        });

        cursiva.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                actualizarEstilo();
            }
        });
    }

    public void actualizarEstilo() {
        int style = Typeface.NORMAL;

        if (negrita.isChecked() && cursiva.isChecked()) {
            style = Typeface.BOLD_ITALIC;
        } else if (negrita.isChecked()) {
            style = Typeface.BOLD;
        } else if (cursiva.isChecked()) {
            style = Typeface.ITALIC;
        }

        entrada.setTypeface(null, style);
    }
}
