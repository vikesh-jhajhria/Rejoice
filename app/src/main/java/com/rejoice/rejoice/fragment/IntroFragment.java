package com.rejoice.rejoice.fragment;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.rejoice.rejoice.R;

public class IntroFragment extends Fragment {
    private static final String ARG_PARAM1 = "showNextBtn";

    private boolean IsShowNextBtn;
    private Button nextBtn;

    private OnFragmentInteractionListener mListener;

    public IntroFragment() {
    }
    public static IntroFragment newInstance(boolean showNextBtn) {
        IntroFragment fragment = new IntroFragment();
        Bundle args = new Bundle();
        args.putBoolean(ARG_PARAM1, showNextBtn);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            IsShowNextBtn = getArguments().getBoolean(ARG_PARAM1);
        }

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view   =   inflater.inflate(R.layout.fragment_intro, container, false);
        nextBtn     =   (Button) view.findViewById(R.id.get_started_btn);
        nextBtn.setVisibility(IsShowNextBtn ? View.VISIBLE : View.INVISIBLE);
        nextBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mListener != null) {
                    mListener.onFragmentInteraction("GET_STARTED");
                }
            }
        });
        return view;
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    public interface OnFragmentInteractionListener {
        void onFragmentInteraction(String command);
    }
}
