package com.example.baseactivity.Repositories;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import java.util.List;

import Retrofit.requests.Responses.NasaApiClient;
import Retrofit.requests.models.NasaSearchModel;

public class NasaRepository {

    private NasaApiClient nasaApiClient;
    private static NasaRepository instance;
    public static NasaRepository getInstance(){
        if(instance==null){
            instance = new NasaRepository();
        }
        return instance;
    }

    public NasaRepository() {
        nasaApiClient = NasaApiClient.getInstance();
    }
    public LiveData<List<NasaSearchModel>> getSearchModel(){
        return nasaApiClient.getSearchModel();
    }
    public void searchNasaApi(int sol){
        if(sol<1000){
            sol=1000;
        }
        nasaApiClient.searchNasaApi(sol);
    }
}
