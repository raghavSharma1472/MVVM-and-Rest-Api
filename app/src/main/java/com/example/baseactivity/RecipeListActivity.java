package com.example.baseactivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;

import com.example.baseactivity.viewmodels.NasaListViewModel;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import Retrofit.requests.NasaApi;
import Retrofit.requests.Responses.NasaSearchResponse;
import Retrofit.requests.ServiceGenerator;
import Retrofit.requests.models.NasaSearchModel;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import Retrofit.requests.util.Constants;

public class RecipeListActivity extends BaseActivity {
    private static final String TAG = "RecipeListActivity";
    Button button;
    private NasaListViewModel nasaListViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipe_list);


        nasaListViewModel = new ViewModelProvider(this).get(NasaListViewModel.class); //New way for ViewModalProviders!!!!!
        //nasaListViewModel = ViewModelProviders.of(this).get(NasaListViewModel.class);


        subscribeObservers();


        button = findViewById(R.id.test);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              testRetrofitRequest();

            }
        });
    }

    private void subscribeObservers(){
        nasaListViewModel.getListMutableLiveData().observe(this, new Observer<List<NasaSearchModel>>() {
            @Override
            public void onChanged(List<NasaSearchModel> nasaSearchModels) {

                if(nasaSearchModels != null){
                    for(NasaSearchModel nasaSearchModel : nasaSearchModels){
                        Log.d(TAG, "onChanged: "+nasaSearchModel.getId());
                    }
                }
            }
        });
    }

    private void searchNasaApi(int sol){
        nasaListViewModel.searchNasaApi(sol);
    }

    private void testRetrofitRequest() {
        searchNasaApi(1000);
    }
}
