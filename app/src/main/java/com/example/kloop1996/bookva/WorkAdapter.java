package com.example.kloop1996.bookva;

import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.example.kloop1996.bookva.databinding.ItemWorkBinding;
import com.example.kloop1996.bookva.model.entity.Work;
import com.example.kloop1996.bookva.viewmodel.ItemWorkViewModel;

import java.util.Collections;
import java.util.List;

/**
 * Created by kloop1996 on 12.05.2016.
 */
public class WorkAdapter extends RecyclerView.Adapter<WorkAdapter.WorkViewHolder> {
    private List<Work> works;

    public WorkAdapter() {
        this.works = Collections.emptyList();
    }
    public void setWorks(List<Work> works){this.works=works;}

    @Override
    public WorkViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        ItemWorkBinding binding = DataBindingUtil.inflate(
                LayoutInflater.from(parent.getContext()),
                R.layout.item_work,
                parent,
                false);
        return new WorkViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(WorkViewHolder holder, int position) {
        holder.bindRepository(works.get(position));
    }

    @Override
    public int getItemCount() {
        return works.size();
    }

    public WorkAdapter(List<Work> works) {
        this.works = works;
    }


    public static class WorkViewHolder extends RecyclerView.ViewHolder {
        final ItemWorkBinding binding;

        public WorkViewHolder(ItemWorkBinding binding) {
            super(binding.cardView);
            this.binding = binding;
        }

        void bindRepository(Work work) {
            if (binding.getViewModel() == null) {
                binding.setViewModel(new ItemWorkViewModel(itemView.getContext(), work));
            } else {
                binding.getViewModel().setWork(work);
            }
        }
    }
}
