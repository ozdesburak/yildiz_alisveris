package com.app.yildizalisveris.fragment;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;

import com.app.yildizalisveris.R;
import com.app.yildizalisveris.models.AlisverisListe;
import com.app.yildizalisveris.utils.Util;

import java.util.List;

import static com.app.yildizalisveris.utils.Util.alisverislistesi;

public class AlisverisKaydet extends Fragment {

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private String mParam1;
    private String mParam2;
    EditText txtadi, txtadedi, txtfiyati, txtyerismi, txtlokasyon1,txtlokasyon2,txtnot;
    String ad,yerismi,not;
    int adet;
    double fiyat,lokasyon1,lokasyon2;
    DatePicker datePicker;
    Button btnkaydet,btnback;
    CheckBox checkBox;
    public AlisverisKaydet() {

    }

    public static AlisverisKaydet newInstance(String param1, String param2) {
        AlisverisKaydet fragment = new AlisverisKaydet();
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
        View v = inflater.inflate(R.layout.fragment_alisveris_kaydet, container, false);
        txtadi = v.findViewById(R.id.txtadi);
        txtadedi = v.findViewById(R.id.txtfiyati);
        txtfiyati = v.findViewById(R.id.txtfiyati);
        txtyerismi = v.findViewById(R.id.txtyerismi);
        txtlokasyon1 = v.findViewById(R.id.txtlokasyon1);
        txtlokasyon2 = v.findViewById(R.id.txtlokasyon2);
        txtnot = v.findViewById(R.id.txtnot);
        btnback = v.findViewById(R.id.btnback);
        datePicker = v.findViewById(R.id.datePicker1);
        int day = datePicker.getDayOfMonth();
        int month = datePicker.getMonth() + 1;
        int year = datePicker.getYear();

        checkBox = v.findViewById(R.id.checkbox);
        btnkaydet = v.findViewById(R.id.btnkaydet);
        btnkaydet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ad = txtadi.getText().toString();
                adet = Integer.parseInt(String.valueOf(txtadedi.getText()));
                fiyat = Double.parseDouble(txtfiyati.getText().toString());
                yerismi = txtyerismi.getText().toString();
                lokasyon1 = Double.parseDouble(txtlokasyon1.getText().toString());
                lokasyon2 = Double.parseDouble(txtlokasyon2.getText().toString());
                not = txtnot.getText().toString();

                alisverislistesi.add(new AlisverisListe(ad,adet,fiyat,day+"/"+month+"/"+year,yerismi,checkBox.isChecked(),lokasyon1,lokasyon2,not));
                AlertDialog.Builder dialog = new AlertDialog.Builder(getContext());
                dialog.setTitle("Başarılı")
                        .setMessage("Kayıt Başarılı")
                        .setPositiveButton("Tamam", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface paramDialogInterface, int paramInt) {
                            }
                        });
                dialog.show();

            }
        });

        btnback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Fragment fragment = new AlisverisListesiFragment();
                getActivity().getSupportFragmentManager().beginTransaction()
                        .replace(R.id.fragment_frame, fragment, fragment.getClass().getSimpleName()).addToBackStack(null).commit();
            }
        });
        return v;
    }
}