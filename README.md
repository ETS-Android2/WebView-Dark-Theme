# WebView Dark Theme
## Get start
Works on Android 8 and higher. You will find the results below. Detailed instructions in English.
### Build gradle (app module)
```gradle
implementation 'androidx.webkit:webkit:1.2.0'
```
### Create premissions in your manifest
```xml
    <uses-permission
        android:name="android.permission.INTERNET"/>
    <uses-permission
        android:name="android.permission.ACCESS_NETWORK_STATE"/>
    <uses-permission
        android:name="android.permission.ACCESS_WIFI_STATE"/>
```
### Create simple WebView in your java file
```java
private WebView mWeb;

    private class WebViewer extends WebViewClient {
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            view.loadUrl(url);
            return true;
        }
    }
    
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mWeb = findViewById(R.id.web);
        mWeb.getSettings().setJavaScriptEnabled(true);
        mWeb.loadUrl("http://github.com/dmitrylaas");
        mWeb.setWebViewClient(new WebViewer());

    }
    
    @Override
    public void onBackPressed() {
        if (mWeb.canGoBack()) {
            mWeb.goBack();
        } else {
            super.onBackPressed();
        }
    }
```
### Paste in your layout
```xml
    <WebView
        android:id="@+id/web"
        android:layout_below="@+id/dark"
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        android:layout_margin="10dp"/>
```
### Create two buttons in your layout
```xml
    <Button
        android:id="@+id/light"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:layout_marginLeft="10dp"
        android:layout_marginRight="10dp"
        android:text="light" />

    <Button
        android:id="@+id/dark"
        android:layout_below="@+id/light"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:layout_marginLeft="10dp"
        android:layout_marginRight="10dp"
        android:text="dark" />
```
### Paste in your activity
```java
    private Button button;
    // Insert the code below in onCreate
    // Processing LIGHT button clicks
        button = findViewById(R.id.light);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Don't delete this piece of code!
                if (WebViewFeature.isFeatureSupported(WebViewFeature.FORCE_DARK)) {
                    // Turning on the light mode
                    WebSettingsCompat.setForceDark(mWeb.getSettings(), WebSettingsCompat.FORCE_DARK_OFF);
                }
            }

        });
        // Processing DARK button clicks
        button = findViewById(R.id.dark);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Don't delete this piece of code!
                if (WebViewFeature.isFeatureSupported(WebViewFeature.FORCE_DARK)) {
                    // Turning on the dark mode
                    WebSettingsCompat.setForceDark(mWeb.getSettings(), WebSettingsCompat.FORCE_DARK_ON);
                }
            }

        });
```
### Result
![GIF](https://github.com/dmitrylaas/WebView-Dark-Theme/blob/master/art/result.gif)
### Demo application
[Download apk](https://github.com/dmitrylaas/WebView-Dark-Theme/releases/download/1.0/WebTheme-Example.apk)
