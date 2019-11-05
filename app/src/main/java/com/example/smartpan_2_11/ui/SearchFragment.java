package com.example.smartpan_2_11.ui;


import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import com.example.smartpan_2_11.R;
import com.example.smartpan_2_11.model.DataInterface;
import com.example.smartpan_2_11.model.DataPresenter;
import com.example.smartpan_2_11.model.ResponseEntity;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class SearchFragment extends Fragment implements DataInterface {

    private DataPresenter dataPresenter;
    private RecyclerView rv_search;
    private SearchAdapter searchAdapter;
    private EditText et_search;
    private ArrayList<ResponseEntity> responseEntityArrayList;

    public SearchFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_search, container, false);

        dataPresenter = new DataPresenter(getContext(), this);
        dataPresenter.setData();
        rv_search = view.findViewById(R.id.rv_search);
        rv_search.setLayoutManager(new LinearLayoutManager(getContext()));
        rv_search.setHasFixedSize(false);

        et_search = view.findViewById(R.id.et_search);

        et_search.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                filter(editable.toString());
            }
        });

        return view;
    }

    @Override
    public void getData(ArrayList<ResponseEntity> responseEntities) {
        for (ResponseEntity responseEntity: responseEntities){
            Log.d("Response Entity", responseEntity.getTitle());
        }
        responseEntityArrayList = responseEntities;
        searchAdapter = new SearchAdapter(getContext(), responseEntityArrayList);
        rv_search.setAdapter(searchAdapter);

    }

    private void filter(String text){
        ArrayList<ResponseEntity> filterList = new ArrayList<>();

        for (ResponseEntity responseEntity: responseEntityArrayList){
            if (responseEntity.getTitle().toLowerCase().contains(text.toLowerCase())){
                filterList.add(responseEntity);
            }
        }
        searchAdapter.filterList(filterList);
    }
}
