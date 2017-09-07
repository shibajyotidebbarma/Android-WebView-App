package com.example.shiv.webviewapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {


    Button view_btn_facebook;
    Button view_btn_google;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        view_btn_facebook=(Button) findViewById(R.id.btn_facebook);
        view_btn_google=(Button) findViewById(R.id.btn_google);

        view_btn_facebook.setOnClickListener(this);
        view_btn_google.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {

        switch (v.getId()){
            case R.id.btn_facebook:
                Intent faceIntent=new Intent(MainActivity.this, WebActivity.class);
                faceIntent.putExtra("uri", "https://www.facebook.com");
                startActivity(faceIntent);
                break;

            case R.id.btn_google:
                Intent googleIntent=new Intent(MainActivity.this, WebActivity.class);
                googleIntent.putExtra("uri", "https://www.google.com");
                startActivity(googleIntent);
                break;

        }


    }
}
