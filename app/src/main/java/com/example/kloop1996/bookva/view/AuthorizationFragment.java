package com.example.kloop1996.bookva.view;

import android.app.Fragment;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.databinding.tool.Binding;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.kloop1996.bookva.R;
import com.example.kloop1996.bookva.databinding.AuthorizationFragmentBinding;
import com.example.kloop1996.bookva.viewmodel.AuthorizationViewModel;

/**
 * Created by kloop1996 on 12.05.2016.
 */
public class AuthorizationFragment extends Fragment {
    private AuthorizationViewModel authorizationViewModel;
    AuthorizationFragmentBinding authorizationFragmentBinding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        authorizationFragmentBinding = DataBindingUtil.inflate(inflater,R.layout.authorization_fragment,container,false);
        authorizationViewModel = new AuthorizationViewModel(getActivity());
        authorizationFragmentBinding.setViewModel(authorizationViewModel);

        return authorizationFragmentBinding.getRoot();

    }



}
