package com.rejoice.rejoice.utils;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.util.Log;
import android.widget.Toast;

import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.auth.api.signin.GoogleSignInResult;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by Vikesh on 29-04-2016.
 */
public class GoogleLoginClass {
    private Context context;

    private OnGoogleResultListener onGoogleResultListener;
    private GoogleApiClient mGoogleApiClient;

    public GoogleLoginClass() {
    }

    public void initialize(Context context) {
        this.context = context;
        GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestEmail()
                .build();
        mGoogleApiClient = new GoogleApiClient.Builder(context)
                .enableAutoManage((FragmentActivity) context, new GoogleApiClient.OnConnectionFailedListener() {
                    @Override
                    public void onConnectionFailed(ConnectionResult connectionResult) {

                    }
                })
                .addApi(Auth.GOOGLE_SIGN_IN_API, gso)
                .build();
    }

    public void setOnGoogleResultListener(OnGoogleResultListener onGoogleResultListener) {
        this.onGoogleResultListener = onGoogleResultListener;
    }

    public void signIn() {
        Intent signInIntent = Auth.GoogleSignInApi.getSignInIntent(mGoogleApiClient);
        ((Activity) context).startActivityForResult(signInIntent, 11);
    }


    public void handleSignInResult(Intent data) {
        GoogleSignInResult result = Auth.GoogleSignInApi.getSignInResultFromIntent(data);
        Log.d("Rejoice", "handleSignInResult:" + result.isSuccess());
        if (result.isSuccess()) {
            GoogleSignInAccount acct = result.getSignInAccount();
            Toast.makeText(context, acct.getDisplayName(), Toast.LENGTH_LONG).show();
            JSONObject object = new JSONObject();
            try {
                object.put("name", acct.getDisplayName());
                object.put("email", acct.getEmail());
                object.put("id", acct.getId());
                object.put("photo_url", acct.getPhotoUrl().toString());
                if (onGoogleResultListener != null) {
                    onGoogleResultListener.onGoogleResult(object);
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        } else {
            Toast.makeText(context, "Google Login Failed!", Toast.LENGTH_LONG).show();
        }
    }

    public interface OnGoogleResultListener {
        void onGoogleResult(JSONObject object);
    }
}
