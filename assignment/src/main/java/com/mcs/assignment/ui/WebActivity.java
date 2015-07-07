package com.mcs.assignment.ui;

import android.app.Activity;
import android.os.Bundle;
import android.view.MenuItem;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.mcs.assignment.R;
import com.mcs.assignment.utils.ActivityUtils;

public class WebActivity extends Activity {

    private WebView webView;

    /**
     * {@inheritDoc}
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_web);

        initUi();
        loadUrl();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                WebActivity.this.finish();
                WebActivity.this.overridePendingTransition(R.anim.stay_in, R.anim.right_out);
                ActivityUtils.hideSoftKeyboard(this);

                return true;
        }

        return super.onOptionsItemSelected(item);
    }

    /**
     * Initialize UI components
     */
    private void initUi() {
        getActionBar().setTitle("Browse");
        getActionBar().setDisplayHomeAsUpEnabled(true);

        webView = (WebView) findViewById(R.id.webview);
        webView.setWebViewClient(new WebViewClient());
        webView.getSettings().setJavaScriptEnabled(true);
    }

    /**
     * Load url in web view
     */
    private void loadUrl() {
        if (getIntent().getExtras() != null) {
            String url = getIntent().getExtras().getString("url").trim();
            webView.loadUrl(url);
        }
    }

}
