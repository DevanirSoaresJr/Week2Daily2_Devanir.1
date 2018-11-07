package com.example.deva_.week2daily3;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class SaveActivity extends AppCompatActivity {
    private static String TAG = "SaveActivity";
    private EditText etSave, etKey;
    private Button btnSave;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_save);

        etSave = findViewById(R.id.etSave);
        btnSave = findViewById(R.id.btnSave);
        etKey = findViewById(R.id.etKey);
    }

    public void doActivity(View view) {

        SharedPreferences sharedPreferences = getSharedPreferences("sp", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("Save", etSave.getText().toString());
        editor.commit();
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);

    }
}
