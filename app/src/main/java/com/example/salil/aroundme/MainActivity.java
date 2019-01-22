package com.example.salil.aroundme;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {
public void find(View view)
{
    Intent intent=new Intent(getApplicationContext(),discover.class);
    startActivity(intent);
}

    @Override
    public void onBackPressed() {
    finishAffinity();
    super.onBackPressed();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
