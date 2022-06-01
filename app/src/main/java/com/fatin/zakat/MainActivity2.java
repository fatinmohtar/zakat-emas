package com.fatin.zakat;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class MainActivity2 extends AppCompatActivity {

    public static final String EXTRA_NUMBER = "com.fatin.zakat.EXTRA_NUMBER";
    //if need 2

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        Button getValue = (Button) findViewById(R.id.getValue);
        getValue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openMainActivity3(); //output page
            }
        });
    }

    public void openMainActivity3(){

        EditText Weight = (EditText) findViewById(R.id.Weight);
        float w = Float.parseFloat(Weight.getText().toString());

        if (w == 0){
            Toast.makeText(MainActivity2.this,"please fill the weight", Toast.LENGTH_LONG).show();
        }

        RadioButton Keep = (RadioButton) findViewById(R.id.Keep);
        RadioButton Wear = (RadioButton) findViewById(R.id.Wear);

        float tv = 0, tgv = 0;
        double  zp = 0,tz = 0;

        if (!Keep.isChecked() && !Wear.isChecked()){
            Toast.makeText(MainActivity2.this,"please select the type", Toast.LENGTH_LONG).show();
        }
        if (Keep.isChecked()){
            tgv = w - 85;
        } else if (Wear.isChecked()){
            tgv = w - 200;
        }

        EditText currentValue = (EditText) findViewById(R.id.currentValue);
        float cv = Float.parseFloat(currentValue.getText().toString());

        if (cv == 0){
            Toast.makeText(MainActivity2.this,"please fill the current value", Toast.LENGTH_LONG).show();
        }

        //total value
        tv = w * cv;
        //zakat payable
        zp = tgv * cv;
        //total zakat
        tz = zp * 0.025;

        //pas value
        Intent intent = new Intent(this,MainActivity3.class);
        intent.putExtra("TOTAL VALUE",tv);
        intent.putExtra("Z PAYABLE",zp);
        intent.putExtra(EXTRA_NUMBER,tz);
        startActivity(intent);
    }
}
