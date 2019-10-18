package com.example.salur;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.util.Log;
import android.view.MenuItem;
import android.widget.TextView;

import java.util.List;

public class Home extends AppCompatActivity {
    private TextView mTextMessage;


    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
            Fragment fragment = null;
            String tag="";
            switch (menuItem.getItemId()){
                case R.id.beranda:
                    fragment = new Beranda();
                    tag = "Beranda";
                    break;

                case R.id.cari:
//                    fragment = new Cari();
                    tag = "Cari";
                    break;

                case R.id.tambah:
//                    fragment = new Tambah();
                    tag = "Tambah";
                    break;

                case R.id.notifikasi:
//                    fragment = new Notif();
                    tag = "Notif";
                    break;

                case R.id.profil:
//                    fragment = new Profil ()                                                          ;
                    tag = "Profil";
                    break;
            }
            return loadFrag(getVisibleFragment(),fragment,tag);
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        BottomNavigationView navView = findViewById(R.id.bottom_navigation);
        navView.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        loadFrag(null,new Beranda(), "Beranda");
    }
    public Fragment getVisibleFragment(){
        FragmentManager fragmentManager = Home.this.getSupportFragmentManager();
        List<Fragment> fragments = fragmentManager.getFragments();
        for(Fragment fragment : fragments){
            if(fragment!=null && fragment.isVisible()){
                return fragment;
            }
        }
        return null;
    }

    public boolean loadFrag(Fragment currFragment,Fragment goFragment, String tag){
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction;
        fragmentTransaction = fragmentManager.beginTransaction();
        if(currFragment!=null){
            fragmentTransaction.hide(currFragment);
        }
        if(fragmentManager.findFragmentByTag(tag)!=null){
            fragmentTransaction.show(fragmentManager.findFragmentByTag(tag));
        }
        else{
            fragmentTransaction.add(R.id.fragment_container,goFragment,tag);
        }
        fragmentTransaction.commit();
        return true;
    }
}
