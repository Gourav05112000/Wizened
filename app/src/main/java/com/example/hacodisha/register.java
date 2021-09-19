package com.example.hacodisha;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class register extends AppCompatActivity {
    private EditText email,password,name,confirmpass;
    private Button register;
    private FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        email=findViewById( R.id.email);
        password=findViewById(R.id.password);
        name=findViewById(R.id.name);
        confirmpass=findViewById(R.id.confirm_password);
        register=findViewById(R.id.register);
        auth=FirebaseAuth.getInstance();
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String txt_email = email.getText().toString();
                String passsword = password.getText().toString();
                String name = password.getText().toString();
                String confirmpassword = confirmpass.getText().toString();
                if (TextUtils.isEmpty(txt_email) || TextUtils.isEmpty(passsword)||TextUtils.isEmpty(name)||TextUtils.isEmpty(confirmpassword))
                {
                    Toast.makeText(register.this, "ender the datas", Toast.LENGTH_SHORT).show();

                }
                else
                {
                    registeruser(txt_email,passsword);
                }
            }

            private void registeruser(String email, String password) {
                auth.createUserWithEmailAndPassword(email, password)
                        .addOnCompleteListener(register.this, new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                Toast.makeText(register.this, "createUserWithEmail:onComplete:" + task.isSuccessful(), Toast.LENGTH_SHORT).show();
                                //progressBar.setViSignupActivitysibility(View.GONE);
                                // If sign in fails, display a message to the user. If sign in succeeds
                                // the auth state listener will be notified and logic to handle the
                                // signed in user can be handled in the listener.
                                if (!task.isSuccessful()) {
                                    Toast.makeText(register.this, "Authentication failed." + task.getException(),
                                            Toast.LENGTH_SHORT).show();
                                } else {
                                    startActivity(new Intent(register.this, dashboard.class));
                                    finish();
                                }
                            }
                        });

            }

        });
}}

