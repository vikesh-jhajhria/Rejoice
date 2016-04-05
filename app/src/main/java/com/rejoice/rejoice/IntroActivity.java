package com.rejoice.rejoice;

import android.content.Intent;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.RadioButton;

import com.rejoice.rejoice.adapter.PagerAdapter;
import com.rejoice.rejoice.fragment.IntroFragment;

public class IntroActivity extends AppCompatActivity implements IntroFragment.OnFragmentInteractionListener{

    private RadioButton rb1,rb2,rb3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro);

        rb1 = (RadioButton) findViewById(R.id.rb1);
        rb2 = (RadioButton) findViewById(R.id.rb2);
        rb3 = (RadioButton) findViewById(R.id.rb3);
        ViewPager viewPager = (ViewPager) findViewById(R.id.id_viewpager);

        PagerAdapter adapter = new PagerAdapter(getSupportFragmentManager());
        adapter.addFragment(IntroFragment.newInstance(false),"");
        adapter.addFragment(IntroFragment.newInstance(false),"");
        adapter.addFragment(IntroFragment.newInstance(true),"");
        viewPager.setAdapter(adapter);



        viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                if (position == 0) {
                    rb1.setChecked(true);
                }
                if (position == 1) {
                    rb2.setChecked(true);
                }
                if (position == 2) {
                    rb3.setChecked(true);
                }
            }

            @Override
            public void onPageSelected(int position) {

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

    }

    @Override
    public void onFragmentInteraction(String command) {
        if(command.equalsIgnoreCase("GET_STARTED"))
        {
            Intent i = new Intent(IntroActivity.this, HomeActivity.class);
            startActivity(i);
            finish();
        }
    }
}
