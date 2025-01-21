// MainActivity.java
package com.example.calculatorapp;

import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Tạo WebView làm giao diện chính
        WebView webView = new WebView(this);
        setContentView(webView);

        // Cấu hình WebView
        webView.setWebViewClient(new WebViewClient());
        WebSettings webSettings = webView.getSettings();
        webSettings.setJavaScriptEnabled(true); // Kích hoạt JavaScript

        // Giao tiếp giữa Java và JavaScript
        webView.addJavascriptInterface(new Object() {
            @android.webkit.JavascriptInterface
            public double calculate(String operator, double a, double b) {
                switch (operator) {
                    case "+":
                        return a + b;
                    case "-":
                        return a - b;
                    case "*":
                        return a * b;
                    case "/":
                        if (b != 0) return a / b;
                        else {
                            Toast.makeText(MainActivity.this, "Không thể chia cho 0!", Toast.LENGTH_SHORT).show();
                            return 0;
                        }
                    default:
                        return 0;
                }
            }
        }, "Android");

        // Load file HTML từ thư mục assets
        webView.loadUrl("file:///android_asset/index.html");
    }
}