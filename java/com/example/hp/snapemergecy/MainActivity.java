package com.example.hp.snapemergecy;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {



    Button btnShowLocation;
    GPSTracker gps;
    double latitude;
    double longitude;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnShowLocation = (Button) findViewById(R.id.getLocation);

        btnShowLocation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gps = new GPSTracker(MainActivity.this);

                if (gps.canGetLocation()){
                    latitude = gps.getLatitude();
                    longitude = gps.getLongitude();

                    Toast.makeText(getApplicationContext(), "Your Location is \nLat = "+ latitude + "\nLong = "+longitude + " ",Toast.LENGTH_LONG).show();

                }else{
                    gps.showSettingsAlert();
                }

//                try {
//                    Intent in = new Intent(MainActivity.this, GetCurrentLocation.class);
//                    startActivity(in);
//                }catch (Exception e){
//                    Toast.makeText(getApplicationContext(), "Your Location "+e,Toast.LENGTH_LONG).show();
//                }
            }
        });
    }

    public void emerge(View view) {
        Intent i = new Intent(MainActivity.this , MyLocation.class);
        i.putExtra("long",longitude);
        i.putExtra("late",latitude);

        startActivity(i);

    }


    //getLocationClick



}
