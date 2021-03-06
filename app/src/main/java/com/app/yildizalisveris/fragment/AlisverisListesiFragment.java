package com.app.yildizalisveris.fragment;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.app.yildizalisveris.R;
import com.app.yildizalisveris.adapter.AlisverisAdapter;
import com.app.yildizalisveris.utils.Util;

public class AlisverisListesiFragment extends Fragment {
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private String mParam1;
    private String mParam2;
    Button btnaddnew,btnShare,btnMap;
    RecyclerView RecyclerViewAlisverisListele;
    AlisverisAdapter adapter;
    TextView txtTamamlanan;
    int count =0;

    public AlisverisListesiFragment() {

    }

    public static AlisverisListesiFragment newInstance(String param1, String param2) {
        AlisverisListesiFragment fragment = new AlisverisListesiFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_alisveris_listesi, container, false);
        btnaddnew = v.findViewById(R.id.btnaddnew);
        btnShare = v.findViewById(R.id.btnShare);
        btnMap = v.findViewById(R.id.btnMap);
        RecyclerViewAlisverisListele = v.findViewById(R.id.RecyclerViewAlisverisListele);
        RecyclerViewAlisverisListele.setLayoutManager(new LinearLayoutManager(getContext()));
        adapter = new AlisverisAdapter(getContext(), Util.alisverislistesi);
        RecyclerViewAlisverisListele.setAdapter(adapter);
        txtTamamlanan = v.findViewById(R.id.txtTamamlanan);
        for (int i=0;i<Util.alisverislistesi.size();i++) {
            if (Util.alisverislistesi.get(i).getTamamlandi()){
                count++;
            }
        }
        txtTamamlanan.setText(count + " / " + Util.alisverislistesi.size()); //S??LME ????LEM?? OLDU??UNDA SAYFANIN G??NCELLENMES?? GEREK??YOR.
        btnaddnew.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Fragment fragment = new AlisverisKaydet();
                getActivity().getSupportFragmentManager().beginTransaction()
                        .replace(R.id.fragment_frame, fragment, fragment.getClass().getSimpleName()).addToBackStack(null).commit();
            }
        });
        btnShare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent mailIntent = new Intent(Intent.ACTION_SEND);
                mailIntent.setType("text/Message");
                mailIntent.putExtra(Intent.EXTRA_SUBJECT, "ALI??VER???? L??STES??");
                for (int i=0; i<Util.alisverislistesi.size();i++) {
                    mailIntent.putExtra(Intent.EXTRA_TEXT   , "TAR??H : " +Util.alisverislistesi.get(i).getTarih()+ "\n"+ "ADI :" + Util.alisverislistesi.get(i).getUrunadi() + "\n"+ "ADED?? :" + Util.alisverislistesi.get(i).getUrunadedi() + "\n"+ "F??YATI :" + Util.alisverislistesi.get(i).getUrunfiyati() + "\n"+ "ALI??VER???? YAPILACAK YER :" + Util.alisverislistesi.get(i).getAlisverisyapilacakyer() + "\n"+ "NOT : " + Util.alisverislistesi.get(i).getNot() + "\n"+ "TAMAMLANDI MI : " + Util.alisverislistesi.get(i).getTamamlandi() );
                }
                mailIntent.putExtra(Intent.EXTRA_STREAM, "config.txt");
                startActivity(Intent.createChooser(mailIntent, "Dosyay?? payla????n"));
            }
        });

        btnMap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Fragment fragment = new HaritaFragment();
                getActivity().getSupportFragmentManager().beginTransaction()
                        .replace(R.id.fragment_frame, fragment, fragment.getClass().getSimpleName()).addToBackStack(null).commit();
            }
        });
        return v;
    }
}