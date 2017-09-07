package com.example.shiv.webviewapplication;

import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class WebActivity extends AppCompatActivity {

    WebView view_webView;
    ProgressDialog view_progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web);
        view_webView=(WebView) findViewById(R.id.webView);
        WebSettings param = view_webView.getSettings();
        param.setJavaScriptEnabled(true);
        Intent link = getIntent();
        String uri= link.getStringExtra("uri");
        view_webView.setWebViewClient(new MyWebViewClient());
        view_webView.loadUrl(uri);

    }
    private class MyWebViewClient extends WebViewClient{

        public MyWebViewClient(){}
        public void OnPageFinished(WebView paramWebView, String paramString ){

        super.onPageFinished(paramWebView,paramString);
            WebActivity.this.view_progressDialog.dismiss();


        }



        public void OnPageStarted(WebView paramWebView, String paramString, Bitmap paramBitmap){

            super.onPageStarted(paramWebView, paramString,paramBitmap);
            WebActivity.this.view_progressDialog= new ProgressDialog(WebActivity.this);
            WebActivity.this.view_progressDialog.setMessage("Loading...");
            WebActivity.this.view_progressDialog.show();


        }

        public boolean shouldOverrideUriLoading(WebView paramWebView, String paramString){

        paramWebView.loadUrl(paramString);
            return true;

        }



    }




}
