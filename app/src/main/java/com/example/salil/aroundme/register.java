package com.example.salil.aroundme;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;
import java.util.Map;

public class register extends AppCompatActivity {
    EditText e1,e2;


    DatabaseReference databaseReference;
public void signup(View view)
{

    databaseReference= FirebaseDatabase.getInstance().getReference();
    Map<String,String> values=new HashMap<>();
    if(e1.getText().toString().isEmpty()||e2.getText().toString().isEmpty())
    {
        Toast.makeText(this, "both fields are required", Toast.LENGTH_SHORT).show();
    }
    else {
        values.put("username", e1.getText().toString());
        values.put("password", e2.getText().toString());
        databaseReference.push().setValue(values, new DatabaseReference.CompletionListener() {
            @Override
            public void onComplete(DatabaseError databaseError, DatabaseReference databaseReference) {
                if (databaseError == null) {
                    Log.i("info", "save success");

                } else {
                    Log.i("info", "save unsuccess");

                }
            }
        });
        Toast.makeText(this, "user is registered", Toast.LENGTH_SHORT).show();
        Intent intent=new Intent(getApplicationContext(),login.class);
        startActivity(intent);
    }


}
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        e1=(EditText)findViewById(R.id.e1);
        e2=(EditText)findViewById(R.id.e2);

    }
}
