package com.rejoice.rejoice;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.text.Spanned;

import uk.co.deanwild.flowtextview.FlowTextView;
import uk.co.deanwild.flowtextview.listeners.OnLinkClickListener;

public class AboutUs extends AppCompatActivity {

    private FlowTextView flowTextView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_us);

        flowTextView = (FlowTextView) findViewById(R.id.ftv);
        flowTextView.setTextColor(getResources().getColor(android.R.color.white));
        flowTextView.setTextSize(getResources().getDimension(R.dimen.font_14));
        flowTextView.setText(getString(R.string.about_text));


        // handle link behaviour
        flowTextView.setOnLinkClickListener(new OnLinkClickListener() {
            @Override
            public void onLinkClick(String url) {
                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
                startActivity(browserIntent);
            }
        });
    }
}
