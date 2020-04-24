package Retrofit.requests;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import Retrofit.requests.util.Constants;

public class ServiceGenerator {
    private static Retrofit.Builder retrofitbuilder =
            new Retrofit.Builder()
                    .baseUrl(Constants.Base_URL)
                    .addConverterFactory(GsonConverterFactory.create());

    private static  Retrofit retrofit = retrofitbuilder.build();
    private static NasaApi nasaApi = retrofit.create(NasaApi.class);
    public static NasaApi getNasaApi(){
        return nasaApi;
    }

}
