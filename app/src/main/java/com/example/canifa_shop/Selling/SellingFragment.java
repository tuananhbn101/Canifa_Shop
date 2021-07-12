package com.example.canifa_shop.Selling;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

import com.example.canifa_shop.R;
import com.example.canifa_shop.databinding.FragmentSellingBinding;

import org.jetbrains.annotations.NotNull;

public class SellingFragment extends Fragment {
    FragmentSellingBinding binding;
    public static SellingFragment newInstance() {

        Bundle args = new Bundle();

        SellingFragment fragment = new SellingFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @org.jetbrains.annotations.Nullable
    @Override
    public View onCreateView(@NonNull @NotNull LayoutInflater inflater, @Nullable @org.jetbrains.annotations.Nullable ViewGroup container, @Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_selling,container,false);
        return binding.getRoot();
    }
}
