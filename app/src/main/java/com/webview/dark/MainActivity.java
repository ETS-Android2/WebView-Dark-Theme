package com.webview.dark;

import androidx.appcompat.app.AppCompatActivity;
import androidx.webkit.WebSettingsCompat;
import androidx.webkit.WebViewFeature;

import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private WebView mWeb;
    private Button button;
    // Настройка WebView клиента
    private class WebViewer extends WebViewClient {
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            view.loadUrl(url);
            return true;
        }
    }
    // onCreate
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Отображение контента на экране
        setContentView(R.layout.activity_main);
        // "Находим" WebView
        mWeb = findViewById(R.id.web);
        // Включаем Java Script
        mWeb.getSettings().setJavaScriptEnabled(true);
        // агружаем URL-страницы
        mWeb.loadUrl("http://github.com/dmitrylaas");
        // Настраиваем WebView клиент
        mWeb.setWebViewClient(new WebViewer());
        // Обработка нажатия на кнопку LIGHT
        button = findViewById(R.id.light);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Не удалять этот кусок кода!
                if (WebViewFeature.isFeatureSupported(WebViewFeature.FORCE_DARK)) {
                    // Включаем светлый режим
                    WebSettingsCompat.setForceDark(mWeb.getSettings(), WebSettingsCompat.FORCE_DARK_OFF);
                }
            }

        });
        // Обработка нажатия на кнопку DARK
        button = findViewById(R.id.dark);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Не удалять этот кусок кода!
                if (WebViewFeature.isFeatureSupported(WebViewFeature.FORCE_DARK)) {
                    // Включаем тёмный режим
                    WebSettingsCompat.setForceDark(mWeb.getSettings(), WebSettingsCompat.FORCE_DARK_ON);
                }
            }

        });

    }
    // Обработка нажатия на кнопку "Назад"
    @Override
    public void onBackPressed() {
        if (mWeb.canGoBack()) {
            mWeb.goBack();
        } else {
            super.onBackPressed();
        }
    }
}
