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

public class login extends AppCompatActivity {
    private EditText email,password;
    public Button log;
    private FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        email=findViewById(R.id.emaill);
        password=findViewById(R.id.passwordl);
        log=findViewById(R.id.loginl);
        auth=FirebaseAuth.getInstance();
        log.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String txt_email=email.getText().toString();
                String txt_password=password.getText().toString();
                login_user(txt_email,txt_password);
            }
        });
    }

    private void login_user(String email, String password) {
        if (TextUtils.isEmpty(email)||(TextUtils.isEmpty(password))) {
            Toast.makeText(getApplicationContext(),
                    "Please enter email!!",
                    Toast.LENGTH_LONG)
                    .show();
            return;
        }
        auth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(login.this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        // If sign in fails, display a message to the user. If sign in succeeds
                        // the auth state listener will be notified and logic to handle the
                        // signed in user can be handled in the listener.
                       // progressBar.setVisibility(View.GONE);
                        if (!task.isSuccessful()) {
                            Toast.makeText(login.this, "true", Toast.LENGTH_LONG).show();
                            // there was an error
//                            if (password.length() < 6) {
//                                inputPassword.setError(getString(R.string.minimum_password));
//                            } else {
//                                Toast.makeText(LoginActivity.this, getString(R.string.auth_failed), Toast.LENGTH_LONG).show();
//                            }
                        } else {
                            Intent intent = new Intent(login.this, dashboard.class);
                            startActivity(intent);
                            finish();
                        }
                    }
                });



    }
}