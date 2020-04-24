package Retrofit.requests;

import Retrofit.requests.Responses.NasaResponse;
import Retrofit.requests.Responses.NasaSearchResponse;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface NasaApi {

    @GET("mars-photos/api/v1/rovers/curiosity/photos")
    Call<NasaSearchResponse> searchNasa(
            @Query("sol") int sol,
            @Query("api_key") String api_key
    );

    @GET("mars-photos/api/v1/rovers/curiosity/photos")
    Call<NasaResponse> NASA_RESPONSE_CALL(
            @Query("sol") String sol,
            @Query("api_key") String api_key
    );
}
