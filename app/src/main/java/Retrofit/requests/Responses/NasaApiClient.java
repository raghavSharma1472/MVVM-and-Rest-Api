package Retrofit.requests.Responses;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.baseactivity.AppExecutors;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

import Retrofit.requests.ServiceGenerator;
import Retrofit.requests.models.NasaSearchModel;
import Retrofit.requests.util.Constants;
import retrofit2.Call;
import retrofit2.Response;

import static Retrofit.requests.util.Constants.NETWORK_TIMEOUT;

public class NasaApiClient {
    private static final String TAG = "NasaApiClient";

    private static NasaApiClient instance;
    private MutableLiveData<List<NasaSearchModel>> listMutableLiveData;
    private RetrieveNasaRunnable retrieveNasaRunnable;

    public static NasaApiClient getInstance(){
        if(instance==null){
            instance= new NasaApiClient();
        }
        return instance;
    }

    public NasaApiClient() {
        listMutableLiveData = new MutableLiveData<>();
    }

    public LiveData<List<NasaSearchModel>> getSearchModel(){
        return listMutableLiveData;
    }

    public void searchNasaApi(int sol){
        if(retrieveNasaRunnable !=null){
            retrieveNasaRunnable = null;
        }
        retrieveNasaRunnable = new RetrieveNasaRunnable(sol);
        final Future handler = AppExecutors.getInstance().networkIO().submit(retrieveNasaRunnable);

        AppExecutors.getInstance().networkIO().schedule(new Runnable() {
            @Override
            public void run() {
                //let the user know its timed out
                handler.cancel(true);
            }
        },NETWORK_TIMEOUT, TimeUnit.MILLISECONDS);
    }

    class RetrieveNasaRunnable implements Runnable{
        private int sol;
        boolean cancelRequest;

        public RetrieveNasaRunnable(int sol) {
            this.sol = sol;
            cancelRequest = false;
        }

        @Override
        public void run() {

            try {
            Response response = null;
            response = getNasaSearchModelList(sol).execute();

            Log.d(TAG, "run: Inside try");
                if(cancelRequest){
                    return;
                }
                if(response.code()==200){
                    List<NasaSearchModel> list = new ArrayList<>(((NasaSearchResponse)response.body()).getNasaSearchModelList());
                    Log.d(TAG, "run: if response went 200");
                    if(sol == 1000){
                        listMutableLiveData.postValue(list);
                    }else{
                        List<NasaSearchModel> newlist = listMutableLiveData.getValue();
                        newlist.addAll(list);
                        listMutableLiveData.postValue(newlist);
                    }
                }else{
                    //String string = response.errorBody().string();
                    Log.e(TAG, "run: "+response.errorBody().string());
                    listMutableLiveData.postValue(null);
                }
            } catch (IOException e) {
                e.printStackTrace();
                listMutableLiveData.postValue(null);
                Log.d(TAG, "run: Inside Catch ... exception occured");
            }

        }

        private Call<NasaSearchResponse> getNasaSearchModelList(int sol){
            return ServiceGenerator.getNasaApi().searchNasa(
                    sol,
                    Constants.API_Key
            );
        }

        private void CancelRequest(){
            Log.d(TAG, "CancelRequest: Cancelling the search Request");
            cancelRequest = true;
        }
    }



}
