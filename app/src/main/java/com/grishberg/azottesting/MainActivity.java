package com.grishberg.azottesting;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.webkit.WebView;

public class MainActivity extends AppCompatActivity {
    public static final String BASE_URL = "http://abiesys.ru";
    public static final String HTTP_ABIESYS_RU_AZOT = BASE_URL + "/@azot";

    private WebView wv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        wv = (WebView) findViewById(R.id.wvContent);
        if (wv == null) {
            return;
        }
        DenieWebClient webClient = new DenieWebClient(BASE_URL);
        wv.setWebViewClient(webClient);
        wv.loadUrl(HTTP_ABIESYS_RU_AZOT);

        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) { //this method is used for handling menu items' events
        // Handle item selection
        switch (item.getItemId()) {

            case R.id.goBack:
                if(wv.canGoBack()) {
                    wv.goBack();
                }
                return true;

            case R.id.goForward:
                if(wv.canGoForward()) {
                    wv.goForward();
                }
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }
    /**
     * Событие при нажатии на кнопку Up в App Bar
     *
     * @return
     */
    @Override
    public boolean onSupportNavigateUp() {
        finish();
        return true;
    }
}
