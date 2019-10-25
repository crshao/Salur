package com.example.salur.API;

import com.example.salur.BuildConfig;
import com.facebook.stetho.okhttp3.StethoInterceptor;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitBuilder {
    private static final String TAG = "RetrofitBuilder"; //DEBUG TAG
    private static final String BASE_URL = "http://192.168.100.70/salur/public/index.php/api/";

    private final static OkHttpClient client = buildClient();
    private final static Retrofit retrofit = buildRetrofit(client);


    //Fungsi ini digunakan untuk setiap request, akan meminta callback dari API dalam bentuk JSON
    private static OkHttpClient buildClient()
    {
        OkHttpClient.Builder builder = new OkHttpClient.Builder()
            .addInterceptor(new Interceptor() {
                @Override
                public Response intercept(Chain chain) throws IOException
                {
                    Request request = chain.request();
                    Request.Builder builder = request.newBuilder()
                            .addHeader("Accept", "application/json")
                            .addHeader("Connection", "close");

                    request = builder.build();

                    return chain.proceed(request);
                }
            });
        if(BuildConfig.DEBUG)
        {
            builder.addInterceptor(new StethoInterceptor());
        }

        return builder.build();
    }

    private static Retrofit buildRetrofit(OkHttpClient client)
    {
        return new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .client(client)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
    }

    public static <T> T createService(Class<T> service)
    {
        return retrofit.create(service);
    }

    //    public static <T> T createServiceWithAuth(Class<T> service, final TokenManager tokenManager){
//        OkHttpClient newClient = client.newBuilder().addInterceptor(new Interceptor() {
//            @Override
//            public TestUser intercept(Chain chain) throws IOException {
//                Request request = chain.request();
//
//                Request.Builder builder = request.newBuilder();
//
//                if(tokenManager.getToken().getAccessToken()!=null){
//                    builder.addHeader("Authorization","Bearer " + tokenManager.getToken().getAccessToken());
//                }
//
//                request = builder.build();
//                return chain.proceed(request);
//            }
//        }).build();
//
//        Retrofit newRetrofit = retrofit.newBuilder().client(newClient).build();
//        return newRetrofit.create(service);
//    }
}
