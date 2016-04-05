package com.rejoice.rejoice.fragment;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.rejoice.rejoice.R;
import com.rejoice.rejoice.adapter.VegAdapter;
import com.rejoice.rejoice.vo.Item;

import java.util.ArrayList;
import java.util.List;

public class VegFragment extends Fragment {
    private static final String ARG_PARAM1 = "param1";

    private String mParam1;
    private RecyclerView vegRview;
    private List<Item> vegList;
    private OnFragmentInteractionListener mListener;

    public VegFragment() {

    }
    public static VegFragment newInstance(String param1) {
        VegFragment fragment = new VegFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_veg, container, false);

        vegList = new ArrayList<>();
        vegRview = (RecyclerView) view.findViewById(R.id.veg_rv);
        vegRview.setLayoutManager( new LinearLayoutManager(getContext()));
        VegAdapter vegAdapter = new VegAdapter(prepareList());
        vegRview.setAdapter(vegAdapter);
        return view;
    }

    private List prepareList()
    {
        for(int i = 0; i < 100; i++)
        {
            Item item = new Item();
            item.title = "Item "+i;
            item.detail = "Detail "+i;
            item.selected = false;
            vegList.add(item);
        }
        return vegList;
    }
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
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
        void onFragmentInteraction(Uri uri);
    }
}
