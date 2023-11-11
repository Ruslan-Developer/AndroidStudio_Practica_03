package com.example.proyecto03;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private int num1;

    private int num2;

    private EditText tvNum1;
    private EditText tvNum2;

    private CheckBox checkBoxSuma, checkBoxResta;
    private TextView resultado;
    private Button btnCalcular;
    private TextView resultadoTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvNum1 = findViewById(R.id.tvNum1);
        tvNum2 = findViewById(R.id.tvNum2);
        checkBoxSuma = findViewById(R.id.checkBoxSuma);
        checkBoxResta = findViewById(R.id.checkBoxResta);
        btnCalcular = findViewById(R.id.btnCalcular);
        resultadoTextView = findViewById(R.id.textViewResultado);

        btnCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calcularResultado();
            }
        });


    }
    private void calcularResultado() {
        boolean sumaSelected = checkBoxSuma.isChecked();
        boolean restaSelected = checkBoxResta.isChecked();
        String num1 = tvNum1.getText().toString();
        String num2 = tvNum2.getText().toString();


        if (sumaSelected && restaSelected) {
            resultadoTextView.setText("Seleccione solo una operación a la vez.");
        } else if (!sumaSelected && !restaSelected) {
            resultadoTextView.setText("Seleccione al menos una operación.");
        } else {
            int resultado = 0;

            if (sumaSelected) {
                // Realizar la suma
                resultado = Integer.parseInt(num1 )+Integer.parseInt( num2); // Cambia esto según tus valores reales
            } else if (restaSelected) {
                // Realizar la resta
                resultado = Integer.parseInt(num1) - Integer.parseInt(num2 ); // Cambia esto según tus valores reales
            }

            resultadoTextView.setText("Resultado: " + resultado);
        }
    }
}