package com.example.salil.aroundme;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.speech.RecognizerIntent;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Locale;

public class discover extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
public void findmap(View view)
{
    Intent intent=new Intent(getApplicationContext(),MapsActivity.class);
    int  tag=Integer.parseInt(view.getTag().toString());
    intent.putExtra("tag",tag);

    startActivity(intent);
}
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_discover);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }
//code for speech to text
public void speech(View view)
{
    Intent intent=new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
    intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL,RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);
    intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE, Locale.getDefault());
    if(intent.resolveActivity(getPackageManager())!=null)
    {
        startActivityForResult(intent,10);
    }
    else {
        Toast.makeText(this, "your device doesnt support speech input", Toast.LENGTH_SHORT).show();
    }
}

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode)
        {
            case 10:
                if(resultCode==RESULT_OK && data!=null)
                {
                  ArrayList<String> result= data.getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS);
                    Toast.makeText(this,result.get(0), Toast.LENGTH_SHORT).show();
               if(result.get(0).equalsIgnoreCase("nearby banks")||result.get(0).equalsIgnoreCase("nearby bank"))
               {
                   Intent intent=new Intent(getApplicationContext(),MapsActivity.class);
                   intent.putExtra("tag",1);

                   startActivity(intent);
               }
               if(result.get(0).equalsIgnoreCase("nearby atm")||result.get(0).equalsIgnoreCase("nearby atms"))
                    {
                        Intent intent=new Intent(getApplicationContext(),MapsActivity.class);
                        intent.putExtra("tag",2);

                        startActivity(intent);
                    }if(result.get(0).equalsIgnoreCase("nearby bakery")||result.get(0).equalsIgnoreCase("nearby bakeries"))
                {
                    Intent intent=new Intent(getApplicationContext(),MapsActivity.class);
                    intent.putExtra("tag",3);

                    startActivity(intent);               }
                    if(result.get(0).equalsIgnoreCase("nearby airport")||result.get(0).equalsIgnoreCase("nearby airports"))
                    {
                        Intent intent=new Intent(getApplicationContext(),MapsActivity.class);
                        intent.putExtra("tag",4);

                        startActivity(intent);
                    }
                    if(result.get(0).equalsIgnoreCase("nearby cafe"))
                    {
                        Intent intent=new Intent(getApplicationContext(),MapsActivity.class);
                        intent.putExtra("tag",5);

                        startActivity(intent);
                    }if(result.get(0).equalsIgnoreCase("nearby hospital")||result.get(0).equalsIgnoreCase("nearby hospitals"))
                {
                    Intent intent=new Intent(getApplicationContext(),MapsActivity.class);
                    intent.putExtra("tag",6);

                    startActivity(intent);               }
                    if(result.get(0).equalsIgnoreCase("nearby hotel")||result.get(0).equalsIgnoreCase("nearby hotels"))
                    {
                        Intent intent=new Intent(getApplicationContext(),MapsActivity.class);
                        intent.putExtra("tag",7);

                        startActivity(intent);
                    }
                    if(result.get(0).equalsIgnoreCase("nearby restaurants")||result.get(0).equalsIgnoreCase("nearby restaurant"))
                    {
                        Intent intent=new Intent(getApplicationContext(),MapsActivity.class);
                        intent.putExtra("tag",8);

                        startActivity(intent);
                    }if(result.get(0).equalsIgnoreCase("nearby schools")||result.get(0).equalsIgnoreCase("nearby school"))
                {
                    Intent intent=new Intent(getApplicationContext(),MapsActivity.class);
                    intent.putExtra("tag",9);

                    startActivity(intent);               }
                    if(result.get(0).equalsIgnoreCase("nearby museum")||result.get(0).equalsIgnoreCase("nearby museums"))
                    {
                        Intent intent=new Intent(getApplicationContext(),MapsActivity.class);
                        intent.putExtra("tag",10);

                        startActivity(intent);
                    } if(result.get(0).equalsIgnoreCase("nearby zoo"))
                {
                    Intent intent=new Intent(getApplicationContext(),MapsActivity.class);
                    intent.putExtra("tag",11);

                    startActivity(intent);
                }if(result.get(0).equalsIgnoreCase("nearby dentist")||result.get(0).equalsIgnoreCase("nearby dentists"))
                {
                    Intent intent=new Intent(getApplicationContext(),MapsActivity.class);
                    intent.putExtra("tag",12);

                    startActivity(intent);               }
                    if(result.get(0).equalsIgnoreCase("nearby saloon")||result.get(0).equalsIgnoreCase("nearby spa"))
                    {
                        Intent intent=new Intent(getApplicationContext(),MapsActivity.class);
                        intent.putExtra("tag",13);

                        startActivity(intent);
                    } if(result.get(0).equalsIgnoreCase("nearby gyms")||result.get(0).equalsIgnoreCase("nearby gym"))
                {
                    Intent intent=new Intent(getApplicationContext(),MapsActivity.class);
                    intent.putExtra("tag",14);

                    startActivity(intent);
                }if(result.get(0).equalsIgnoreCase("nearby pharmacy"))
                {
                    Intent intent=new Intent(getApplicationContext(),MapsActivity.class);
                    intent.putExtra("tag",15);

                    startActivity(intent);               }

                }
                }
                }




//code for speech to text ended
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.login) {

            Intent intent=new Intent(getApplicationContext(),login.class);
            startActivity(intent);
        } else if (id == R.id.register) {
            Intent intent=new Intent(getApplicationContext(),register.class);
            startActivity(intent);

        } else if (id == R.id.rating) {
            Intent intent=new Intent(getApplicationContext(),rating.class);
            startActivity(intent);


        } else if (id == R.id.exit) {
            new AlertDialog.Builder(this)
                    .setIcon(android.R.drawable.ic_dialog_alert)
                    .setMessage("do you want to quit the app")
                    .setPositiveButton("yes", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            finishAffinity();
                            Toast.makeText(discover.this, "app closed", Toast.LENGTH_SHORT).show();
                        }


                    })
                    .setNegativeButton("no",null)
                    .show();

        } else if (id == R.id.nav_share) {

            try{
                Intent n=new Intent(Intent.ACTION_SEND);
                n.setType("text/plain");
                n.putExtra(Intent.EXTRA_SUBJECT,"my application name");
                String saux="\n let me recommend you this application\n\n";
                saux=saux+"http://play.google.com/store/apps/details?id=the.package.id\n\n";
                n.putExtra(Intent.EXTRA_TEXT,saux);
                startActivity(Intent.createChooser(n,"choose one"));
            }
            catch(Exception e)
            {
                System.out.print(e);
            }
        } else if (id == R.id.feedback) {

Intent intent=new Intent(getApplicationContext(),feedback.class);
startActivity(intent);

        }
        else if(id==R.id.favourite_places)
        {
            new AlertDialog.Builder(this)
                    .setTitle("about us")
                    .setMessage("copyright by \n salil5chhabra@gmail.com")
                    .setPositiveButton("ok",null)
                    .show();
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

}
