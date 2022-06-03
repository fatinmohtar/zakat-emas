package com.fatin.zakat;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity2 extends AppCompatActivity {


    SharedPreferences sharedPref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        Button getValue = (Button) findViewById(R.id.getValue);
        getValue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                EditText Weight = (EditText) findViewById(R.id.Weight);
                float w = Float.parseFloat(Weight.getText().toString());

                RadioGroup rg = (RadioGroup) findViewById(R.id.radioGroup);
                RadioButton Keep = (RadioButton) findViewById(R.id.Keep);
                RadioButton Wear = (RadioButton) findViewById(R.id.Wear);

                EditText currentValue = (EditText) findViewById(R.id.currentValue);
                float cv = Float.parseFloat(currentValue.getText().toString());

                if (w == 0) {
                    Toast.makeText(MainActivity2.this, "please fill the weight", Toast.LENGTH_LONG).show();
                } else if (!Keep.isChecked() && !Wear.isChecked()) {
                    Toast.makeText(MainActivity2.this, "please select the types", Toast.LENGTH_LONG).show();
                } else if (cv == 0) {
                    Toast.makeText(MainActivity2.this, "please fill the current value", Toast.LENGTH_LONG).show();
                }

                float checked = 0;
                if (Keep.isChecked()) {
                    checked = 1;
                } else if (Wear.isChecked()) {
                    checked = 2;
                }

                //pas value
                Intent intent = new Intent(getApplicationContext(), MainActivity3.class);
                intent.putExtra("weight", w);
                intent.putExtra("checked", checked);
                intent.putExtra("currentValue", cv);
                startActivity(intent);
            }
        });
    }


    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);

        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.about:
                //page link
                Intent i = new Intent(this, MainActivity4.class);
                startActivity(i);

                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
