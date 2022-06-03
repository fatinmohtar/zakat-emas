package com.fatin.zakat;

import android.content.Intent;
import android.support.annotation.Keep;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity3 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        float tv = 0, tgv = 0, r=0 , cv = 0, w= 0;
        double  zp = 0,tz = 0;

        Intent intent = getIntent();
        w = intent.getFloatExtra("weight", 0);
        r = intent.getFloatExtra("checked",0);
        cv = intent.getFloatExtra("currentValue", 0);

        if (r == 1){
            tgv = w - 85;
        }else if(r == 2){
            tgv = w - 200;
        }

        //total value
        tv = w * cv;
        //zakat payable
        zp = tgv * cv;
        //total zakat
        tz = zp * 0.025;


        TextView totalValue = (TextView) findViewById(R.id.totalValue);
        TextView zakatPayable = (TextView) findViewById(R.id.zakatPayable);
        TextView totalZakat = (TextView) findViewById(R.id.totalZakat);

        totalValue.setText("TOTAL VALUE : RM" + tv);
        zakatPayable.setText("ZAKAT PAYABLE : RM" + zp);
        totalZakat.setText("TOTAL ZAKAT : RM" + tz);
    }
}
