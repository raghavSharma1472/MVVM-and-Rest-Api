package Retrofit.requests.Responses;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

import Retrofit.requests.models.NasaSearchModel;

public class NasaSearchResponse {

    @SerializedName("photos")
    @Expose()
    private List<NasaSearchModel> nasaSearchModels;

    public List<NasaSearchModel> getNasaSearchModelList() {
        return nasaSearchModels;
    }

    @Override
    public String toString() {
        return "NasaSearchResponse{" +
                "nasaList=" + nasaSearchModels +
                '}';
    }
}
