package Retrofit.requests.Responses;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import Retrofit.requests.models.NasaModel;

public class NasaResponse {

    @SerializedName("photos")
    @Expose()
    private NasaModel nasaModel;

    public NasaModel getNasaModel() {
        return nasaModel;
    }

    @Override
    public String toString() {
        return "NasaResponse{" +
                "nasa=" + nasaModel +
                '}';
    }
}
