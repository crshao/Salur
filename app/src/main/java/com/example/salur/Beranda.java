package com.example.salur;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.salur.API.ApiService;
import com.example.salur.API.RetrofitBuilder;
import com.example.salur.Adapter.HomeAdapter;
import com.example.salur.Models.HomePostData;

import java.lang.reflect.Array;
import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class Beranda extends Fragment {

    private static final String TAG ="Beranda";

    @BindView(R.id.gerak)
    TextView xD;

    @BindView(R.id.recyclerHome)
    RecyclerView recyclerHome;

    Call<ArrayList<HomePostData>> call;
    ApiService service;
    HomeAdapter adapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_beranda,container,false);
        ButterKnife.bind(this,view);

        service = RetrofitBuilder.createService(ApiService.class);
        call = service.getPostData();
        call.enqueue(new Callback<ArrayList<HomePostData>>() {
            @Override
            public void onResponse(Call<ArrayList<HomePostData>> call, Response<ArrayList<HomePostData>> response) {
                Log.w(TAG, response.body().toString());

                if(response.isSuccessful())
                {
                    ArrayList<HomePostData> arrayList = response.body();
                    adapter = new HomeAdapter(getContext(), arrayList);
                    recyclerHome.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));
                    recyclerHome.setAdapter(adapter);
                }
            }

            @Override
            public void onFailure(Call<ArrayList<HomePostData>> call, Throwable t) {

            }
        });

        xD.setSelected(true);
        return view;
    }
}
