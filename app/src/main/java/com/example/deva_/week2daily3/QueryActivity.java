package com.example.deva_.week2daily3;


import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class QueryActivity extends AppCompatActivity {
    private static final String TAG = "QueryActivity";
    private EditText etQuery;
    private Button btnQuery;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_query);

        etQuery = findViewById(R.id.etQuery);
        btnQuery = findViewById(R.id.btnQuery);

    }

    @Override
    protected void onResume() {

        super.onResume();
    }

    public void doActivity(View view) {
        switch (view.getId()) {
            case R.id.btnQueried:

                Intent intent = new Intent(this, MainActivity.class);
                //intent.setAction("displayQuery");
                intent.putExtra("query", etQuery.getText().toString());
                setResult(RESULT_OK, intent);

                finish();
                break;
        }
    }
}
