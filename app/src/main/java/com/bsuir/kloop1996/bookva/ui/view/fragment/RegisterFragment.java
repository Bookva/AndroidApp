package com.bsuir.kloop1996.bookva.ui.view.fragment;

import android.app.Fragment;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bsuir.kloop1996.bookva.R;
import com.bsuir.kloop1996.bookva.databinding.AuthorizationFragmentBinding;
import com.bsuir.kloop1996.bookva.databinding.RegisterFragmentBinding;
import com.bsuir.kloop1996.bookva.viewmodel.AuthorizationViewModel;
import com.bsuir.kloop1996.bookva.viewmodel.RegisterViewModel;

/**
 * Created by kloop1996 on 16.05.2016.
 */
public class RegisterFragment extends Fragment {
    private RegisterViewModel registerViewModel;
    private RegisterFragmentBinding registerFragmentBinding;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        registerFragmentBinding = DataBindingUtil.inflate(inflater, R.layout.register_fragment,container,false);
        registerViewModel = new RegisterViewModel(getActivity());
        registerFragmentBinding.setViewModel(registerViewModel);

        return registerFragmentBinding.getRoot();
    }

}
