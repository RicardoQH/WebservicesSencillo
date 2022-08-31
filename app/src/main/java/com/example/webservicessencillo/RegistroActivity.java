package com.example.webservicessencillo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

public class RegistroActivity extends AppCompatActivity {

    EditText e1,e2,e3;
    Button btningresar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);
    }
    public void relacionamosVistas(){
        e1=(EditText)findViewById(R.id.edtnombre_re);
        e2=(EditText)findViewById(R.id.edtemail_re);
        e3=(EditText)findViewById(R.id.edtpass_re);

        btningresar=(Button) findViewById(R.id.btn_ir_crearCuenta);

    }

    public void validar(View v){

        final String nombre=e1.getText().toString();
        final String email=e2.getText().toString();
        final String pass=e3.getText().toString();

        String url="http://192.168.1.76/login_/ingreso.php?nombre="+nombre+"&email="+email+"&pass="+pass;
        RequestQueue servicio= Volley.newRequestQueue(this);
        StringRequest respuesta=new StringRequest(
                Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Toast.makeText(getApplicationContext(),
                        response,Toast.LENGTH_LONG).show();


            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(getApplicationContext(),
                        "Error comunicación",Toast.LENGTH_SHORT).show();
            }
        });
        servicio.add(respuesta);
    }
    public void Iniciar(View view){
        Intent i = new Intent(this, LoginActivity.class);
        startActivity(i);
    }

}