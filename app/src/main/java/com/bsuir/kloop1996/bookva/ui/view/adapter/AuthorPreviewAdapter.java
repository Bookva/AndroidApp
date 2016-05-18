package com.bsuir.kloop1996.bookva.ui.view.adapter;

import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.bsuir.kloop1996.bookva.R;
import com.bsuir.kloop1996.bookva.databinding.ItemAuthorPreviewBinding;
import com.bsuir.kloop1996.bookva.model.entity.AuthorPreview;
import com.bsuir.kloop1996.bookva.viewmodel.ItemAuthorPreviewViewModel;

import java.util.Collections;
import java.util.List;

/**
 * Created by kloop1996 on 18.05.2016.
 */
public class AuthorPreviewAdapter extends RecyclerView.Adapter<AuthorPreviewAdapter.AuthorPreviewViewHolder> {
    private List<AuthorPreview> authorPreviews;

    public  AuthorPreviewAdapter()  {
        this.authorPreviews = Collections.emptyList();
    }
    public  AuthorPreviewAdapter(List<AuthorPreview> authorPreviews) {
        this.authorPreviews = authorPreviews;
    }

    public void setAuthorPreviews(List<AuthorPreview> authorPreviews){
        this.authorPreviews=authorPreviews;
    }


    @Override
    public AuthorPreviewViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        ItemAuthorPreviewBinding binding = DataBindingUtil.inflate(
                LayoutInflater.from(parent.getContext()),
                R.layout.item_author_preview,
                parent,
                false);
        return new AuthorPreviewViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(AuthorPreviewViewHolder holder, int position) {
        holder.bindRepository(authorPreviews.get(position));


    }

    @Override
    public int getItemCount() {
        return authorPreviews.size();
    }

    public static class AuthorPreviewViewHolder extends RecyclerView.ViewHolder{
        final ItemAuthorPreviewBinding binding;

        public AuthorPreviewViewHolder (ItemAuthorPreviewBinding binding) {
            super(binding.cardView);
            this.binding = binding;
        }

        void bindRepository(AuthorPreview authorPreview) {
            if (binding.getViewModel() == null) {
                binding.setViewModel(new ItemAuthorPreviewViewModel(itemView.getContext(), authorPreview));
            } else {
                binding.getViewModel();
            }
        }
    }

}
