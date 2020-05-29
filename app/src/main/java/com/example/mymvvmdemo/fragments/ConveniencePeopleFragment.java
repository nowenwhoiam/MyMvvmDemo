package com.example.mymvvmdemo.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import com.example.mymvvmdemo.R;
import com.example.mymvvmdemo.databinding.FragmentConveniencePeopleBinding;

import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

/**
 * Created by Vishal Patolia on 18-Feb-18.
 */

public class ConveniencePeopleFragment extends Fragment {
    FragmentConveniencePeopleBinding mBinding;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_convenience_people, container, false);
        return mBinding.getRoot();
    }
}
