package com.trios.android.admin1;


import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        Button btn = (Button) findViewById(R.id.web);
        //az

       btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent launchIntent = getPackageManager().getLaunchIntentForPackage("im.delight.android.examples.webview");
                if (launchIntent != null) {
                    startActivity(launchIntent);//null pointer check in case package name was not found
                }

                //   startActivity(new Intent(MainActivity.this, Main2Activity.class));
           }
       });




        Button btn1 = (Button) findViewById(R.id.screen1ekm);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, Main4Activity.class));
            }
        });
        Button btn3 = (Button) findViewById(R.id.screen2tsr);

        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, Main5Activity.class));
            }
        });
        Button btn4 = (Button) findViewById(R.id.screen3pkd);

        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, Main3Activity.class));
            }
        });


    }










    // public void webopen(View view) {
    //    Intent intent = new Intent(MainActivity.this, Main2Activity.class);
    //    startActivity(intent);
    //}
    //public void pkdopen(View view1) {
      //  Intent intentk = new Intent(MainActivity.this, Main3Activity.class);
        //startActivity(intentk);
    //}
    //public void tsropen(View view2) {
     //   Intent intentj = new Intent(MainActivity.this, Main5Activity.class);
      //  startActivity(intentj);
    //}
    //public void kocopen(View view3) {
      //  Intent intentm = new Intent(MainActivity.this, Main4Activity.class);
        //startActivity(intentm);
    //}


}