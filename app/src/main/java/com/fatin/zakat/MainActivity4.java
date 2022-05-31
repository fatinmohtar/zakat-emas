package com.fatin.zakat;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
//import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
//import android.provider.CalendarContract;
import android.view.Gravity;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity4 extends AppCompatActivity {

    ImageView studId, group, ws, link;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);

        studId = findViewById(R.id.studId);
        group = findViewById(R.id.group);
        ws = findViewById(R.id.ws);
        link = findViewById(R.id.link);


        studId.setOnClickListener(v -> Toast.makeText(getApplicationContext(),
                "Student number",Toast.LENGTH_LONG).show());


        group.setOnClickListener(v -> Toast.makeText(getApplicationContext(),
                "Group",Toast.LENGTH_LONG).show());

        ws.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gotoUrl("https://wa.link/25dve5");
            }
        });

        link.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gotoUrl("");
            }
        });

    }

    private void gotoUrl(String s) {
        Uri uri = Uri.parse(s);
        startActivity(new Intent(Intent.ACTION_VIEW,uri));
    }

}