package com.example.webviewcalismasi;

import android.app.ProgressDialog;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        webView =findViewById(R.id.webView);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.loadUrl("https://www.trendyol.com");

        final ProgressDialog progress = ProgressDialog.show(this, "Sayfa ", "Yükleniyor....", true);
        progress.show();

        webView.setWebViewClient(new WebViewClient(){

            @Override
            public void onPageFinished(WebView view, String url) {
                super.onPageFinished(view, url);

                Toast.makeText(MainActivity.this, "Sayfa Yüklendi ", Toast.LENGTH_SHORT).show();
                progress.dismiss();
            }

            @Override
            public void onReceivedError(WebView view, WebResourceRequest request, WebResourceError error) {
                super.onReceivedError(view, request, error);

                Toast.makeText(MainActivity.this, "Bir hata oluştu!", Toast.LENGTH_SHORT).show();
                progress.dismiss();
            }
        });

    }


}
