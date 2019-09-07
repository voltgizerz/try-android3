package com.example.gd3_9455_e_1;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class SharedPreferencesActivity extends AppCompatActivity {

    private SharedPreferences sp;
    private final String name= "myShared";
    public static final int mode= Activity.MODE_PRIVATE;

    private String email="";
    private String username="";
    private String password="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shared_preferences);
        loadPreferences();
        setForm();
    }

    private void setForm()
    {
        EditText txtEmail=(EditText) findViewById(R.id.txtEmail);
        EditText txtUsername=(EditText) findViewById(R.id. txtUsername);
        EditText txtPassword=(EditText) findViewById(R.id.txtPassword);

        txtUsername.setText(username);
        txtPassword.setText(password);
        txtEmail.setText(email);
    }

    private void loadPreferences()
    {
        sp=getSharedPreferences(name,mode);
        if(sp!=null)
        {
            username=sp.getString( "username",  "");
            password=sp.getString(  "password",  "");
            email=sp.getString( "email", "");
        }
    }

    private void savePreferences()
    {
        EditText txtEmail=(EditText) findViewById(R.id.txtEmail);
        EditText txtUsername=(EditText) findViewById(R.id. txtUsername);
        EditText txtPassword=(EditText) findViewById(R.id.txtPassword);

        SharedPreferences.Editor editor=sp.edit();
        editor.putString("username",txtUsername.getText().toString());
        editor.putString("password",txtPassword.getText().toString());
        editor.putString("email",txtEmail.getText().toString());
        editor.apply();
    }

    public void buttonSimpan(View v)
    {
        savePreferences();
    }

}

