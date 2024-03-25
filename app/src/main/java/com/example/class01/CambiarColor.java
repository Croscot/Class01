package com.example.class01;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.graphics.Color;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import java.util.Random;

public class CambiarColor extends AppCompatActivity {

    ConstraintLayout layout;
    Button cambiarColor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_color);

        layout = (ConstraintLayout) findViewById(R.id.layoutColor);
        cambiarColor = (Button) findViewById(R.id.btncambiarcolor);

        layout.setBackgroundColor(generarColorAleatorio());

        cambiarColor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                layout.setBackgroundColor(generarColorAleatorio());
            }
        });

    }
    private int generarColorAleatorio() {
        Random rnd = new Random();

        int red = rnd.nextInt(256);
        int green = rnd.nextInt(256);
        int blue = rnd.nextInt(256);
        return Color.rgb(red, green, blue);
    }
}
