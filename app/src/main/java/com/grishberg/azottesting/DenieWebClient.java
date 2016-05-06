package com.grishberg.azottesting;

import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.webkit.WebView;
import android.webkit.WebViewClient;

/**
 * Created by g on 06.05.16.
 */
public class DenieWebClient extends WebViewClient {
    private String currentUrl;

    public DenieWebClient(String currentUrl) {
        this.currentUrl = currentUrl;
    }

    @Override
    public boolean shouldOverrideUrlLoading(WebView view, String url) {
        if (url.startsWith(currentUrl)) {
            view.loadUrl(url);
        }
        return true;
    }
}
