package com.example.salil.aroundme;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class login extends AppCompatActivity {
    EditText e1,e2;
    public static final String PREFS_NAME = "MyPrefsFile";
    DatabaseReference databaseReference,databaseReference1;
    List<String> list=new ArrayList<String>();
public  void register(View view)
{
    Intent intent=new Intent(getApplicationContext(),register.class);
    startActivity(intent);
}



    public void login(View view)
{
   databaseReference = FirebaseDatabase.getInstance().getReference();
    //Query namequery=databaseReference.orderByChild().equalTo()
    databaseReference.addValueEventListener(new ValueEventListener() {
        @Override
        public void onDataChange(DataSnapshot dataSnapshot) {
            String de=null,de1=null;
            for(DataSnapshot dataSnapshot1:dataSnapshot.getChildren())
            {
                de=(String) dataSnapshot1.child("username").getValue();
                 de1=(String) dataSnapshot1.child("password").getValue();

             if(de.equals(e1.getText().toString())&&de1.equals(e2.getText().toString()))
             {
                 SharedPreferences settings = getSharedPreferences(login.PREFS_NAME, 0); // 0 - for private mode
                 SharedPreferences.Editor editor = settings.edit();

//Set "hasLoggedIn" to true
                 editor.putBoolean("hasLoggedIn", true);

// Commit the edits!
                 editor.commit();

                 Intent intent=new Intent(getApplicationContext(),MainActivity.class);
                startActivity(intent);
break;

             }
             else {
                 de=null;
                 de1=null;
             }


        }
        if(de==null&&de1==null)
        {
            Toast.makeText(login.this, "invalid username and password", Toast.LENGTH_SHORT).show();
        }
        }


        @Override
        public void onCancelled(DatabaseError databaseError) {

        }
    });

}
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        e1=(EditText)findViewById(R.id.e11);
        e2=(EditText)findViewById(R.id.e22);

    }

}
