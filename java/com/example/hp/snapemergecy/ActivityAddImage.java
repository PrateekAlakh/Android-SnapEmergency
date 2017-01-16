package com.example.hp.snapemergecy;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class ActivityAddImage extends AppCompatActivity {
    Bitmap thumbnail;
    private static final int CAMERA_PIC_REQUEST = 0;
    File pic;
    String email = "", str4 = "";
//    DatabaseHelper helper = new DatabaseHelper(this);
    String username = "";
    byte[] im = new byte[0];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_image);
//        str4 = getIntent().getStringExtra("userNAME");
//        username = getIntent().getStringExtra("username");
//        email += getIntent().getStringExtra("email");
//        TextView tv = (TextView)findViewById(R.id.username);
//        tv.setText(username);

        Button camera = (Button) findViewById(R.id.button);
        camera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(i, CAMERA_PIC_REQUEST);
            }
        });

    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == CAMERA_PIC_REQUEST) {
            thumbnail = (Bitmap) data.getExtras().get("data");
            ImageView image = (ImageView) findViewById(R.id.image);
            image.setImageBitmap(thumbnail);


            try {
                File root = Environment.getExternalStorageDirectory();
                if (root.canWrite()) {
                    pic = new File(root, "pic.png");
                    FileOutputStream out = new FileOutputStream(pic);
                    thumbnail.compress(Bitmap.CompressFormat.PNG, 100, out);
                    out.flush();
                    out.close();
                }
            } catch (IOException e) {
                Log.e("BROKEN", "Could not write file " + e.getMessage());
            }
        }
    }

    public void addValues(View view) {
        Toast.makeText(getApplicationContext(), "DataBase nhi banaya abhi ", Toast.LENGTH_SHORT).show();
    }

    public void showme(View view) {
        Toast.makeText(getApplicationContext(), "Bhai Jab Database he nhi banaya toh kya SHOW kru", Toast.LENGTH_LONG).show();
    }
}
