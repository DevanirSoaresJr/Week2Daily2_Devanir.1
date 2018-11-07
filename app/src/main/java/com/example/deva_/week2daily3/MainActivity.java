package com.example.deva_.week2daily3;


import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";
    private Button btnSave, btnQuery, btnClear;
    private EditText etSave, etQuery, etKey;
    private TextView tvQueried;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //binding views
        btnSave = findViewById(R.id.btnSavePref);
        btnQuery = findViewById(R.id.btnQuery);
        etSave = findViewById(R.id.etSave);
        etQuery = findViewById(R.id.etQuery);
        tvQueried = findViewById(R.id.tvQuery);
        etKey = findViewById(R.id.etKey);
        btnClear = findViewById(R.id.btnClear);

    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG, "onStart");
    }

    @Override
    protected void onResume() throws NullPointerException {
        SharedPreferences sharedPreferences = getSharedPreferences("sp", Context.MODE_PRIVATE);
        String en = sharedPreferences.getString("Save", "");
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("Save", en);
        editor.commit();

        tvQueried.setText(en);

        super.onResume();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == Activity.RESULT_OK && resultCode == 2) {
            tvQueried.setText(data.getStringExtra("query"));
        }
    }

    public void doActivity(View view) {
        switch (view.getId()) {
            case R.id.btnSavePref:
                Intent intent = new Intent(this, SaveActivity.class);
                startActivity(intent);
                Log.d(TAG, "onCreate");
                break;
            case R.id.btnQuery:
                tvQueried.clearComposingText();
                Intent intent1 = new Intent(this, QueryActivity.class);
                startActivity(intent1);
                Log.d(TAG, "onCreate");
                break;
            case R.id.btnClear:
                tvQueried.setText("");
                break;
        }
    }
}
