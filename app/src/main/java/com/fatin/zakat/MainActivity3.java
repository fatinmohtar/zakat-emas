package com.fatin.zakat;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity3 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        Intent intent = getIntent();
        float tv = intent.getFloatExtra("TOTAL VALUE",0);
        double zp = intent.getDoubleExtra("Z PAYABLE",0);
        double tz = intent.getDoubleExtra(MainActivity2.EXTRA_NUMBER,0);

        TextView totalValue = (TextView) findViewById(R.id.totalValue);
        TextView zakatPayable = (TextView) findViewById(R.id.zakatPayable);
        TextView totalZakat = (TextView) findViewById(R.id.totalZakat);

        totalValue.setText("TOTAL VALUE : RM" + tv);
        zakatPayable.setText("ZAKAT PAYABLE : RM" + zp);
        totalZakat.setText("TOTAL ZAKAT : RM" + tz);
    }
}