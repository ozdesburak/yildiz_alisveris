package com.app.yildizalisveris;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;

import com.app.yildizalisveris.R;
import com.app.yildizalisveris.fragment.AlisverisKaydet;
import com.app.yildizalisveris.fragment.AlisverisListesiFragment;
import com.app.yildizalisveris.utils.Util;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Util.alisverislistesi=new ArrayList<>();
        Fragment fragment = new AlisverisKaydet();
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragment_frame, fragment, fragment.getClass().getSimpleName()).addToBackStack(null).commit();
    }

    @Override
    public void onBackPressed() {

    }
}