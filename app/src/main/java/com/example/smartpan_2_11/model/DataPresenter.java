package com.example.smartpan_2_11.model;

import android.content.Context;
import android.util.Log;

import com.example.smartpan_2_11.repository.Client;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DataPresenter {
    private Context context;
    private DataInterface dataInterface;
    private Api api;
    private Client client;
    private ArrayList<ResponseEntity> arrayList = new ArrayList<>();

    public DataPresenter(Context context, DataInterface dataInterface) {
        this.context = context;
        this.dataInterface = dataInterface;
        api = Client.getRetrofit().create(Api.class);
    }

    public void setData(){
        Call<ArrayList<ResponseEntity>> call = api.getResponse();

        call.enqueue(new Callback<ArrayList<ResponseEntity>>() {
            @Override
            public void onResponse(Call<ArrayList<ResponseEntity>> call, Response<ArrayList<ResponseEntity>> response) {
                if (!response.isSuccessful()) {
                    int code = response.code();
                    Log.d("Code: ", String.valueOf(code));
                    return;
                }
                else {
                    ArrayList<ResponseEntity> responseEntities = response.body();
                    for (ResponseEntity responseEntity: responseEntities){
                        arrayList.add(responseEntity);
                    }
                    dataInterface.getData(arrayList);

                }
            }

            @Override
            public void onFailure(Call<ArrayList<ResponseEntity>> call, Throwable t) {
                Log.d("Failure in request: ", t.getMessage());
            }
        });
    }


}
