package com.bsuir.kloop1996.bookva.ui.view.fragment;

import android.app.Fragment;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bsuir.kloop1996.bookva.R;
import com.bsuir.kloop1996.bookva.databinding.AuthorPreviewFragmentBinding;
import com.bsuir.kloop1996.bookva.model.entity.AuthorPreview;
import com.bsuir.kloop1996.bookva.ui.view.adapter.AuthorPreviewAdapter;
import com.bsuir.kloop1996.bookva.ui.view.adapter.WorkAdapter;
import com.bsuir.kloop1996.bookva.viewmodel.AuthorPreviewViewModel;
import com.bsuir.kloop1996.bookva.viewmodel.WorkListViewModel;

import java.util.List;

/**
 * Created by kloop1996 on 18.05.2016.
 */
public class AuthorPreviewFragment extends Fragment implements AuthorPreviewViewModel.DataListener {
    private AuthorPreviewFragmentBinding authorPreviewBinding;
    private WorkListViewModel workListViewModel;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        authorPreviewBinding = DataBindingUtil.inflate(inflater, R.layout.author_preview_fragment,container,false);
        authorPreviewBinding.setViewModel(new AuthorPreviewViewModel(getActivity(),this));

        setupRecyclerView(authorPreviewBinding.authorsRecyclerView);

        return authorPreviewBinding.getRoot();
    }

    private void setupRecyclerView(RecyclerView recyclerView) {
        AuthorPreviewAdapter adapter = new AuthorPreviewAdapter();
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        adapter.notifyDataSetChanged();
    }

    @Override
    public void onAuthorPreviewsChanged(List<AuthorPreview> authorPreviews) {
        AuthorPreviewAdapter adapter = (AuthorPreviewAdapter) authorPreviewBinding.authorsRecyclerView.getAdapter();
        adapter.setAuthorPreviews(authorPreviews);
        adapter.notifyDataSetChanged();
    }
}
