package com.example.baseactivity.viewmodels;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.baseactivity.Repositories.NasaRepository;

import java.util.List;

import Retrofit.requests.models.NasaSearchModel;

public class NasaListViewModel extends ViewModel {

    NasaRepository mnasarepository;

    public NasaListViewModel() {
        mnasarepository = NasaRepository.getInstance();
    }

    public LiveData<List<NasaSearchModel>> getListMutableLiveData(){
        return mnasarepository.getSearchModel() ;
    }

    public void searchNasaApi(int sol){
        mnasarepository.searchNasaApi(sol);
    }
}
