package com.example.logintest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    EditText etName, etUsername, etAge;
    Button bLogout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etUsername = findViewById(R.id.etUsername);
        etName = findViewById(R.id.etName);
        etAge = findViewById(R.id.etAge);
        bLogout = findViewById(R.id.bLogout);

        bLogout.setOnClickListener(this);

        etUsername.addTextChangedListener(logoutTextWatcher);
        etName.addTextChangedListener(logoutTextWatcher);

            }
private TextWatcher logoutTextWatcher = new TextWatcher() {
    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {
String usernameInput = etUsername.getText().toString().trim();
String nameInput = etName.getText().toString().trim();
bLogout.setEnabled(!usernameInput.isEmpty() && !nameInput.isEmpty());
    }

    @Override
    public void afterTextChanged(Editable s) {

    }
};



    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.bLogout:
                startActivity(new Intent(this, Login.class));
                break;
        }
    }
}