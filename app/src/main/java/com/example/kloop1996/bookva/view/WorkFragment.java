package com.example.kloop1996.bookva.view;

import android.app.Fragment;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.kloop1996.bookva.R;
import com.example.kloop1996.bookva.WorkAdapter;
import com.example.kloop1996.bookva.databinding.WorkFragmentBinding;
import com.example.kloop1996.bookva.model.entity.Work;
import com.example.kloop1996.bookva.viewmodel.AuthorizationViewModel;
import com.example.kloop1996.bookva.viewmodel.WorkListViewModel;

import java.util.List;

/**
 * Created by kloop1996 on 12.05.2016.
 */
public class WorkFragment extends Fragment implements WorkListViewModel.DataListener{
    private WorkFragmentBinding workFragmentBinding;
    private WorkListViewModel workListViewModel;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        workFragmentBinding = DataBindingUtil.inflate(inflater, R.layout.work_fragment,container,false);
        workFragmentBinding.setViewModel(new WorkListViewModel(getActivity(),this));

        setupRecyclerView(workFragmentBinding.workRecyclerView);

        return workFragmentBinding.getRoot();
    }

    private void setupRecyclerView(RecyclerView recyclerView) {
        WorkAdapter adapter = new WorkAdapter();
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        adapter.notifyDataSetChanged();
    }

    @Override
    public void onRepositoriesChanged(List<Work> works) {
        WorkAdapter adapter =
                (WorkAdapter) workFragmentBinding.workRecyclerView.getAdapter();
        adapter.setWorks(works);
        adapter.notifyDataSetChanged();
    }
}
