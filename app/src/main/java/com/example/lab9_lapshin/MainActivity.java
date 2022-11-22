package com.example.lab9_lapshin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    EditText etLogin, etPassword;
    Button btnSave, btnLoad;

    SharedPreferences sPref;

    final String savedLogin = "saved_login";
    final String savedPassword = "saved_password";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etLogin = (EditText) findViewById(R.id.etLogin);
        etPassword = (EditText) findViewById(R.id.etPass);
        btnSave = (Button) findViewById(R.id.btnSave);
        btnLoad = (Button) findViewById(R.id.btnLoad);
        btnSave.setOnClickListener(this);
        btnLoad.setOnClickListener(this);
    }

    @Override
    public void onClick(View v){
        switch(v.getId()) {
            case R.id.btnSave:
                saveText();
            case R.id.btnLoad:
                loadText();
        }
    }

    public void saveText(){
        sPref = getPreferences(MODE_PRIVATE);
        SharedPreferences.Editor editor = sPref.edit();
        editor.putString(savedLogin, etLogin.getText().toString());
        editor.putString(savedPassword, etPassword.getText().toString());
        editor.commit();
        Toast.makeText(this, "Data Saved!", Toast.LENGTH_SHORT).show();
    }

    public void loadText(){
        sPref = getPreferences(MODE_PRIVATE);
        String saved_login = sPref.getString(savedLogin, "");
        String saved_password = sPref.getString(savedPassword, "");
        etLogin.setText(saved_login);
        etPassword.setText(saved_password);
        Toast.makeText(this, "Data Loaded!", Toast.LENGTH_SHORT).show();
    }
}