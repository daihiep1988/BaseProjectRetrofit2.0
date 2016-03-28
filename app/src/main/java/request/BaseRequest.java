package request;


import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.Map;
import java.util.Objects;

import retrofit.Call;
import retrofit.Callback;
import retrofit.GsonConverterFactory;
import retrofit.Response;
import retrofit.Retrofit;

/**
 * Created by Nguyen Quang Hiep on 10/19/2015.
 */
public abstract class BaseRequest<T> implements Callback<T> {
    public abstract String getURL();

    Map<String, String> requesParams;

    public abstract Map<String, String> getParans();

    public abstract void onRequestSuccess(T t);

    public abstract void onRequestError(Throwable t);

    @Override
    public void onResponse(Response<T> response, Retrofit retrofit) {
        onRequestSuccess((T) (response.body()));
    }

    @Override
    public void onFailure(Throwable t) {
        onRequestError(t);
    }

//    public abstract void callApi(Call<T> tCall, Map<String, String> requesParams);

    public abstract Call<T> callApi();

    ApiRequest apiRequest;

    public void execute() {

        requesParams = getParans();
        Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd'T'HH:mm:ssZ").create();
        Retrofit retrofit = new Retrofit.Builder().baseUrl(getURL())
                .addConverterFactory(GsonConverterFactory.create(gson)).build();
        apiRequest = retrofit.create(ApiRequest.class);
        Call<T> tCall = callApi();
        tCall.enqueue(this);

    }
}
