package com.example.class01;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class HomePrincipal extends AppCompatActivity {

    Button math, physic, text, exit;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_principal);

        math = (Button) findViewById(R.id.btnmatematica);
        physic = (Button) findViewById(R.id.btnfisica);
        text = (Button) findViewById(R.id.btntexto);
        exit = (Button) findViewById(R.id.btnsalir);

        math.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), Matematica.class);
                startActivity(i);
            }
        });

        physic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), Fisica.class);
                startActivity(i);
            }
        });

        text.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), Texto.class);
                startActivity(i);
            }
        });

        exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_home, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        Intent i;
        switch(item.getItemId()){
            case R.id.menutemperatura:
                i = new Intent(getApplicationContext(), Temperatura.class);
                startActivity(i);
                                    return true;
            case R.id.menucambiocolor:
                i = new Intent(getApplicationContext(), CambiarColor.class);
                startActivity(i);
                                   return true;
           default:    return super.onOptionsItemSelected(item);
       }

    }
}