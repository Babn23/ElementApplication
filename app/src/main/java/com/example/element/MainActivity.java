package com.example.element;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.TextPaint;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    //variables and components
    private EditText etName, etPassword;
    private Button btnLogIng;
    private CheckBox saveDetails;
    private TextView signUpWord;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Code Starts here
        //Connect between java class and XML components
        etName = findViewById(R.id.editTextTextPersonName);
        etPassword = findViewById(R.id.editTextTextPassword);

        saveDetails = findViewById(R.id.checkBoxSave);

        btnLogIng = findViewById(R.id.btnLogin);
        btnLogIng.setOnClickListener(this);

        mAuth = FirebaseAuth.getInstance();

        signUpWord = findViewById(R.id.GoToRegister);
        String text = "Don't have an account ? Sign up here !";
        SpannableString ss = new SpannableString(text);
        ClickableSpan ClickOnSignUp = new ClickableSpan() {
            @Override
            public void onClick(@NonNull View view) {
                Intent intent = new Intent( MainActivity.this , RegisterPage.class);
                startActivity(intent);
            }

            @Override
            public void updateDrawState(@NonNull TextPaint ds) {
                super.updateDrawState(ds);
                ds.setColor(Color.BLACK);
            }
        };
        ss.setSpan(ClickOnSignUp , 24 , 38 , Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        signUpWord.setText(ss);
        signUpWord.setMovementMethod(LinkMovementMethod.getInstance());


        SharedPreferences sharedPreferences = getSharedPreferences("sharedPrefs", MODE_PRIVATE);

        boolean isSaveDetails = (sharedPreferences.getBoolean("isSaveDetails", true));

        if(isSaveDetails){
            etName.setText(sharedPreferences.getString("name", ""));
            etPassword.setText(sharedPreferences.getString("password", ""));
        }
    }

    @Override
    public void onClick(View view) {
        if (btnLogIng == view) {
            if (etName.getText().toString().equals("") || etPassword.getText().toString().equals("")) {
                Toast.makeText(this, "Error! Empty fields...", Toast.LENGTH_LONG).show();
            }else{
                login(etName.getText().toString(),etPassword.getText().toString());

            }
        }
    }

    private void login(String email, String password) {
        mAuth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            Intent intent = new Intent(MainActivity.this,homepage.class);
                            startActivity(intent);
                            // Sign in success, update UI with the signed-in user's information

                        } else {
                            // If sign in fails, display a message to the user.
                            Toast.makeText(MainActivity.this, "Authentication failed.",
                                    Toast.LENGTH_SHORT).show();
                        }

                        // ...
                    }
                });

    }

    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        getMenuInflater().inflate(R.menu.menu_mainpage,menu);
        return true;
    }
    public boolean onOptionsItemSelected(MenuItem item) {
        switch(item.getItemId())
        {
            case R.id.menu_settings:
                Intent intent = new Intent(this,Water.class);
                startActivity(intent);
                break;
            case R.id.menu_homepage:
                Intent intent2 = new Intent(this,homepage.class);
                startActivity(intent2);
                break;
            case R.id.menu_signin:
                Intent intent3 = new Intent(this,MainActivity.class);
                startActivity(intent3);
                break;
            case R.id.menu_profile:
                Intent intent4 = new Intent(this,Profile.class);
                startActivity(intent4);
                break;
        }
        return true;
    }
}