package com.rejoice.rejoice;

import android.content.Intent;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.util.Log;
import android.view.View;
import android.widget.RadioButton;
import android.widget.Toast;



import com.rejoice.rejoice.adapter.PagerAdapter;
import com.rejoice.rejoice.fragment.IntroFragment;
import com.rejoice.rejoice.utils.FBLoginClass;
import com.rejoice.rejoice.utils.GoogleLoginClass;
import com.rejoice.rejoice.utils.Utils;

import org.json.JSONObject;

public class RejoiceActivity extends AppCompatActivity implements IntroFragment.OnFragmentInteractionListener,
        View.OnClickListener, FBLoginClass.OnFBResultListener, GoogleLoginClass.OnGoogleResultListener{

    private RadioButton rb1,rb2,rb3,rb4,rb5;
    private CardView fbLoginBtn, gLoginBtn;
    private FBLoginClass fbLoginClass;
    private GoogleLoginClass googleLoginClass;






    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rejoice);

        fbLoginClass = new FBLoginClass();
        googleLoginClass = new GoogleLoginClass();

        Utils.printKeyHash(RejoiceActivity.this);
        rb1 = (RadioButton) findViewById(R.id.rb1);
        rb2 = (RadioButton) findViewById(R.id.rb2);
        rb3 = (RadioButton) findViewById(R.id.rb3);
        rb4 = (RadioButton) findViewById(R.id.rb4);
        rb5 = (RadioButton) findViewById(R.id.rb5);

        fbLoginBtn =   (CardView) findViewById(R.id.login_facebook);
        fbLoginBtn.setOnClickListener(this);
        gLoginBtn =   (CardView) findViewById(R.id.login_google);
        gLoginBtn.setOnClickListener(this);


        ViewPager viewPager = (ViewPager) findViewById(R.id.id_viewpager);

        PagerAdapter adapter = new PagerAdapter(getSupportFragmentManager());
        adapter.addFragment(IntroFragment.newInstance(false), "");
        adapter.addFragment(IntroFragment.newInstance(false), "");
        adapter.addFragment(IntroFragment.newInstance(false), "");
        adapter.addFragment(IntroFragment.newInstance(false), "");
        adapter.addFragment(IntroFragment.newInstance(true), "");
        viewPager.setAdapter(adapter);



        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                if (position == 0) {
                    rb1.setChecked(true);
                }
                if (position == 1) {
                    rb2.setChecked(true);
                }
                if (position == 2) {
                    rb3.setChecked(true);
                }
                if (position == 3) {
                    rb4.setChecked(true);
                }
                if (position == 4) {
                    rb5.setChecked(true);
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });






        ////////////////////////////////google login


        /*SignInButton signInButton = (SignInButton) findViewById(R.id.login_google);
        signInButton.setSize(SignInButton.SIZE_STANDARD);
        signInButton.setScopes(gso.getScopeArray());
        signInButton.setOnClickListener(this);*/

    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 11) {
            googleLoginClass.handleSignInResult(data);
        }else {
            fbLoginClass.callbackManager.onActivityResult(requestCode, resultCode, data);
        }

    }




    @Override
    public void onStop() {
        super.onStop();
        fbLoginClass.stopTracking();
    }

    @Override
    public void onResume() {
        super.onResume();

    }
    @Override
    public void onFragmentInteraction(String command) {
        if(command.equalsIgnoreCase("GET_STARTED"))
        {
            Intent i = new Intent(RejoiceActivity.this, HomeActivity.class);
            startActivity(i);
            finish();
        }
    }



    @Override
    public void onClick(View v) {
        switch (v.getId())
        {
            case R.id.login_facebook:
                fbLoginClass.setFBResultListener(this);
                fbLoginClass.sdkInitialize(getApplicationContext());
                fbLoginClass.login(this);

                break;
            case R.id.login_google:
                googleLoginClass.setOnGoogleResultListener(this);
                googleLoginClass.initialize(this);
                googleLoginClass.signIn();
                break;
        }
    }


    @Override
    public void onFBResult(JSONObject object) {

        Toast.makeText(this,object.toString(),Toast.LENGTH_LONG).show();
    }

    @Override
    public void onGoogleResult(JSONObject object) {
        Toast.makeText(this,object.toString(),Toast.LENGTH_LONG).show();
    }
}
