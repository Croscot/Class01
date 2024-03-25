package com.example.class01;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ProgressBar;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.text.InputType;
import android.view.inputmethod.EditorInfo;


public class MainActivity extends AppCompatActivity //implements View.OnClickListener
{
    EditText usuario, password;
    Button ingresar, cancelar;
    CheckBox checkPassword, termAndConditions;
    ProgressBar loading;
    boolean checkedShowPassword, checkedTermAndConditions;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        usuario = (EditText) findViewById(R.id.edtusuario);
        password = (EditText) findViewById(R.id.edtpassword);
        ingresar = (Button) findViewById(R.id.btningresar);
        cancelar = (Button) findViewById(R.id.btncancelar);
        checkPassword = (CheckBox) findViewById(R.id.showpassword);
        termAndConditions = (CheckBox) findViewById(R.id.termandconditions);
        loading = (ProgressBar) findViewById(R.id.circularProgressBar);

        ingresar.setEnabled(false);
        loading.setVisibility(View.INVISIBLE);
        ingresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loading.setVisibility(View.VISIBLE);
                loading.setProgress(0);

                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        String nombreUsuario = usuario.getText().toString().trim(),
                                contrasena = password.getText().toString().trim();
                        loading.setProgress(100);
                        if (nombreUsuario.equalsIgnoreCase("admin") && contrasena.equalsIgnoreCase("12345")) {
                            Intent i = new Intent(getApplicationContext(), HomePrincipal.class);
                            startActivity(i);
                        } else {
                            loading.setVisibility(View.INVISIBLE);
                            Toast.makeText(getApplicationContext(), "Credenciales Inválidas", Toast.LENGTH_LONG).show();
                            ingresar.setEnabled(true);
                        }
                    }
                }, 2000);
            }
        });
        cancelar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                usuario.setText("");
                password.setText("");
            }
        });
        checkPassword.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                checkedShowPassword = isChecked;
                showPassword(checkedShowPassword, password);
            }
        });
        termAndConditions.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                checkedTermAndConditions = isChecked;
                acceptTermAndConditions(checkedTermAndConditions);
            }
        });
    };

    public void showPassword(boolean check, EditText password) {
        if(check && !password.getText().toString().isEmpty()){
            password.setInputType(InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD);
        }else{
            password.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
        }
        //Colocar cursor al final del input
        password.setSelection(password.getText().length());
    };
    public void acceptTermAndConditions(boolean check) {
        if(check){
            ingresar.setEnabled(true);
        }else{
            ingresar.setEnabled(false);
        }
    };

    @Override
    protected void onResume() {
        super.onResume();
        loading.setVisibility(View.INVISIBLE);
    }
}