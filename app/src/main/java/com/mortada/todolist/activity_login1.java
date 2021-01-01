package com.mortada.todolist;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.mortada.todolist.R;

class login1 extends AppCompatActivity {
    EditText emilUser,passwordUser;
    Button login;
    FirebaseAuth mAuth ;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login1);

        mAuth = FirebaseAuth.getInstance();

        emilUser = findViewById(R.id.editTextTextEmailAddress2);
        passwordUser= findViewById(R.id.editTextTextPassword2);
        login = findViewById(R.id.button2);


    }


    public void doSignIn(View view) {

        String email = emilUser.getText().toString();
        String pasword = passwordUser.getText().toString();

        mAuth.signInWithEmailAndPassword(email, pasword)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull final Task<AuthResult> task) {


                        if (task.isSuccessful()) {

                            Intent intent = new Intent(login1.this, listtodo.class);
                            startActivity(intent);
//
                        } else {
                            Toast.makeText(login1.this, "not login",
                                    Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(login1.this, MainActivity2.class);
                            startActivity(intent);
                        }

                    }
                });

    }
}