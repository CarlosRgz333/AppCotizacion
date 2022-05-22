package com.example.appcotizacion;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private EditText txtNumCotizacion, txtDescripcion, txtPrecio, txtPInicial, txtPlazo;
    private TextView lblResultado;
    private Button btnCalcular, btnLimpiar;
    private Cotizaciones cotizacion = new Cotizaciones();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtNumCotizacion = (EditText) findViewById(R.id.txtNumCotizacion);
        txtDescripcion = (EditText) findViewById(R.id.txtDescripcion);
        txtPrecio = (EditText) findViewById(R.id.txtPrecio);
        txtPInicial = (EditText) findViewById(R.id.txtPInicial);
        txtPlazo = (EditText) findViewById(R.id.txtPlazo);
        btnCalcular = (Button) findViewById(R.id.btnCalcular);
        btnLimpiar = (Button) findViewById(R.id.btnLimpiar);
        lblResultado = (TextView) findViewById(R.id.lblResultado);

        btnCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(txtNumCotizacion.getText().toString().matches("")||txtDescripcion.getText().toString().matches("")||txtPrecio.getText().toString().matches("")||txtPlazo.getText().toString().matches("")||txtPInicial.getText().toString().matches("")){
                    Toast.makeText(MainActivity.this, "Capture todos los datos", Toast.LENGTH_SHORT).show();
                }else{
                    cotizacion = new Cotizaciones(Integer.parseInt(txtNumCotizacion.getText().toString()), txtDescripcion.getText().toString(), Float.parseFloat(txtPrecio.getText().toString()), Integer.parseInt(txtPInicial.getText().toString()), Integer.parseInt(txtPlazo.getText().toString()));
                    lblResultado.setText(cotizacion.imprimirCotizacion());
                }
            }
        });

        btnLimpiar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                txtNumCotizacion.setText("");
                txtDescripcion.setText("");
                txtPrecio.setText("");
                txtPInicial.setText("");
                txtPlazo.setText("");
                lblResultado.setText("");
            }
        });
    }
}