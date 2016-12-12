package com.rejoice.rejoice;

        import android.support.v7.app.AppCompatActivity;
        import android.os.Bundle;
        import android.view.View;
        import android.widget.ImageView;
        import android.widget.TextView;

public class FAQ extends AppCompatActivity implements View.OnClickListener {
    TextView rl1txtview, rl2txtview, rl3txtview, rl4txtview, rl5txtview, rl6txtview,
            rl1txtview_pands, rl2txtview_pands, rl3txtview_pands, rl4txtview_pands;
    ImageView rl1img, rl2img, rl3img, rl4img, rl5img, rl6img, rl1img_pands, rl2img_pands, rl3img_pands, rl4img_pands;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_faq);
        findViewById(R.id.rl1).setOnClickListener(this);
        findViewById(R.id.rl2).setOnClickListener(this);
        findViewById(R.id.rl3).setOnClickListener(this);
        findViewById(R.id.rl4).setOnClickListener(this);
        findViewById(R.id.rl5).setOnClickListener(this);
        findViewById(R.id.rl6).setOnClickListener(this);

        findViewById(R.id.rl1_pands).setOnClickListener(this);
        findViewById(R.id.rl2_pands).setOnClickListener(this);
        findViewById(R.id.rl3_pands).setOnClickListener(this);
        findViewById(R.id.rl4_pands).setOnClickListener(this);

        rl1img = (ImageView) findViewById(R.id.imgview_arrow1);
        rl2img = (ImageView) findViewById(R.id.imgview_arrow2);
        rl3img = (ImageView) findViewById(R.id.imgview_arrow3);
        rl4img = (ImageView) findViewById(R.id.imgview_arrow4);
        rl5img = (ImageView) findViewById(R.id.imgview_arrow5);
        rl6img = (ImageView) findViewById(R.id.imgview_arrow6);

        rl1img_pands = (ImageView) findViewById(R.id.imgview_arrow1__pands);
        rl2img_pands = (ImageView) findViewById(R.id.imgview_arrow2_pands);
        rl3img_pands = (ImageView) findViewById(R.id.imgview_arrow3_pands);
        rl4img_pands = (ImageView) findViewById(R.id.imgview_arrow4_pands);

        rl1txtview = (TextView) findViewById(R.id.txtview_rl1);
        rl2txtview = (TextView) findViewById(R.id.txtview_rl2);
        rl3txtview = (TextView) findViewById(R.id.txtview_rl3);
        rl4txtview = (TextView) findViewById(R.id.txtview_rl4);
        rl5txtview = (TextView) findViewById(R.id.txtview_rl5);
        rl6txtview = (TextView) findViewById(R.id.txtview_rl6);

        rl1txtview_pands = (TextView) findViewById(R.id.txtview_rl1_pands);
        rl2txtview_pands = (TextView) findViewById(R.id.txtview_rl2_pands);
        rl3txtview_pands = (TextView) findViewById(R.id.txtview_rl3_pands);
        rl4txtview_pands = (TextView) findViewById(R.id.txtview_rl4_pands);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.rl1:
                openLayout(findViewById(R.id.rl1));
                break;
            case R.id.rl2:
                openLayout(findViewById(R.id.rl2));
                break;
            case R.id.rl3:
                openLayout(findViewById(R.id.rl3));
                break;
            case R.id.rl4:
                openLayout(findViewById(R.id.rl4));
                break;
            case R.id.rl5:
                openLayout(findViewById(R.id.rl5));
                break;
            case R.id.rl6:
                openLayout(findViewById(R.id.rl6));
                break;
            case R.id.rl1_pands:
                openLayout(findViewById(R.id.rl1_pands));
                break;
            case R.id.rl2_pands:
                openLayout(findViewById(R.id.rl2_pands));
                break;
            case R.id.rl3_pands:
                openLayout(findViewById(R.id.rl3_pands));
                break;
            case R.id.rl4_pands:
                openLayout(findViewById(R.id.rl4_pands));
                break;
        }
    }

    public void openLayout(View view) {
        rl4img_pands.setRotation(0);
        rl4txtview_pands.setVisibility(View.GONE);
        rl1img_pands.setRotation(0);
        rl1txtview_pands.setVisibility(View.GONE);
        rl1img.setRotation(0);
        rl1txtview.setVisibility(View.GONE);
        rl2img.setRotation(0);
        rl2txtview.setVisibility(View.GONE);
        rl3img.setRotation(0);
        rl3txtview.setVisibility(View.GONE);
        rl4img.setRotation(0);
        rl4txtview.setVisibility(View.GONE);
        rl5img.setRotation(0);
        rl5txtview.setVisibility(View.GONE);
        rl6img.setRotation(0);
        rl6txtview.setVisibility(View.GONE);
        rl2img_pands.setRotation(0);
        rl2txtview_pands.setVisibility(View.GONE);
        rl3img_pands.setRotation(0);
        rl3txtview_pands.setVisibility(View.GONE);

        if (view.getId() == R.id.rl1) {
            rl1img.setRotation(90);
            rl1txtview.setVisibility(View.VISIBLE);

        } else if (view.getId() == R.id.rl2) {
            rl2img.setRotation(90);
            rl2txtview.setVisibility(View.VISIBLE);
        }
        else if (view.getId() == R.id.rl3) {
            rl3img.setRotation(90);
            rl3txtview.setVisibility(View.VISIBLE);
        }
        else if (view.getId() == R.id.rl4) {
            rl4img.setRotation(90);
            rl4txtview.setVisibility(View.VISIBLE);
        }
        else if (view.getId() == R.id.rl5) {
            rl5img.setRotation(90);
            rl5txtview.setVisibility(View.VISIBLE);
        }
        else if (view.getId() == R.id.rl6) {
            rl6img.setRotation(90);
            rl6txtview.setVisibility(View.VISIBLE);
        }

        if (view.getId() == R.id.rl1_pands) {
            rl1img_pands.setRotation(90);
            rl1txtview_pands.setVisibility(View.VISIBLE);

        } else if (view.getId() == R.id.rl2_pands) {
            rl2img_pands.setRotation(90);
            rl2txtview_pands.setVisibility(View.VISIBLE);
        }
        else if (view.getId() == R.id.rl3_pands) {
            rl3img_pands.setRotation(90);
            rl3txtview_pands.setVisibility(View.VISIBLE);
        }
        else if (view.getId() == R.id.rl4_pands) {
            rl4img_pands.setRotation(90);
            rl4txtview_pands.setVisibility(View.VISIBLE);
        }
    }
}
