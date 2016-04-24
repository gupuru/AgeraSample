package gupuru.agerasample;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.IOException;
import java.util.ArrayList;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * "https://raw.githubusercontent.com/gupuru/AgeraSample/asset/data.json"データ取得
 */
public class FruitsGetApiRequest {

    private OkHttpClient client;
    private Request request;
    private FruitsCallback fruitsCallback;

    public FruitsGetApiRequest(FruitsCallback fruitsCallback){
        super();
        this.fruitsCallback = fruitsCallback;
        this.client = new OkHttpClient();
        this.request = new Request.Builder()
                .url("https://raw.githubusercontent.com/gupuru/AgeraSample/asset/data.json")
                .build();
    }

    public void run(){
        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                fruitsCallback.setError();
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                ArrayList<Fruits> fruitsArrayList = new Gson().fromJson(response.body().string(),
                        new TypeToken<ArrayList<Fruits>>(){}.getType());

                fruitsCallback.setFruits(fruitsArrayList);
            }
        });
    }

    public interface FruitsCallback {
        void setError();
        void setFruits(ArrayList<Fruits> fruitsArrayList);
    }

}
