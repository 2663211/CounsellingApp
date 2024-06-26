package com.example.couselling;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;

public class Counellor_LogIn extends AppCompatActivity {
    EditText Email,Pass;
    Button LogIn;
    String email,password,name;

    protected void onCreate(Bundle savedInstance) {
        super.onCreate(savedInstance);
        setContentView(R.layout.counsellor_login);
        Email = findViewById(R.id.Email);
        Pass = findViewById(R.id.Password);
        LogIn = findViewById(R.id.logInbtn);

        LogIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                email = String.valueOf(Email.getText());
                password = String.valueOf(Pass.getText());
                //Toast.makeText(client_logIn.this, "SignUp successful", Toast.LENGTH_SHORT).show();
                RequestQueue queue = Volley.newRequestQueue(Counellor_LogIn.this);
                String url = "https://lamp.ms.wits.ac.za/home/s2651487/Counsellor_LogIn.php";

                StringRequest stringRequest = new StringRequest(Request.Method.POST, url,
                        new Response.Listener<String>() {
                            @Override
                            public void onResponse(String response) {
                                if (response.equals("success")) {
                                    Toast.makeText(Counellor_LogIn.this, "Login Successful", Toast.LENGTH_SHORT).show();
                                    Intent intent = new Intent(Counellor_LogIn.this, MainActivity.class);
                                    startActivity(intent);
                                    //finish();

                                } else {
                                    Toast.makeText(Counellor_LogIn.this, "Check Information You Gave me", Toast.LENGTH_SHORT).show();
                                }// end of else

                            }
                        }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError volleyError) {

                    }


                }){
                    protected Map<String, String> getParams(){
                        Map<String, String> paramV = new HashMap<>();
                        paramV.put("Email", email);
                        paramV.put("Password", password);
                        return paramV;
                    }
                };
                queue.add(stringRequest);


            }
        });// end of OnClick
    }
}
