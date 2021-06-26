package com.app.yildizalisveris.adapter;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.app.yildizalisveris.R;
import com.app.yildizalisveris.models.AlisverisListe;
import com.app.yildizalisveris.utils.Util;

import java.util.List;

public class AlisverisAdapter extends RecyclerView.Adapter<AlisverisAdapter.ViewHolder> {

    private List<AlisverisListe> alisverisListesi;
    private LayoutInflater mInflater;
    private ItemClickListener mClickListener;
    Context context;

    public AlisverisAdapter(Context context, List<AlisverisListe> alisverisListesi) {
        this.context = context;
        this.mInflater = LayoutInflater.from(context);
        this.alisverisListesi = alisverisListesi;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.item_alisveris, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.itemtarih.setText(alisverisListesi.get(position).getTarih());
        holder.itemisim.setText(alisverisListesi.get(position).getUrunadi());
        holder.itemfiyatı.setText(alisverisListesi.get(position).getUrunfiyati().toString());
        holder.itemadedi.setText(alisverisListesi.get(position).getUrunadedi()+"");
        holder.itemkonumu.setText(alisverisListesi.get(position).getAlisverisyapilacakyer()+"");
        holder.itemlokasyon1.setText(alisverisListesi.get(position).getLatitude().toString());
        holder.itemlokasyon2.setText(alisverisListesi.get(position).getLongitude().toString());
        holder.itemnot.setText(alisverisListesi.get(position).getNot());
    }

    @Override
    public int getItemCount() {
        return alisverisListesi.size();
    }

    // stores and recycles views as they are scrolled off screen
    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView itemtarih, itemisim, itemfiyatı, itemadedi, itemkonumu, itemlokasyon1, itemlokasyon2, itemnot;
        Button btnupdate, btndelete;

        ViewHolder(View itemView) {
            super(itemView);
            itemtarih = itemView.findViewById(R.id.itemtarih);
            itemisim = itemView.findViewById(R.id.itemisim);
            itemfiyatı = itemView.findViewById(R.id.itemfiyatı);
            itemadedi = itemView.findViewById(R.id.itemadedi);
            itemkonumu = itemView.findViewById(R.id.itemkonumu);
            itemlokasyon1 = itemView.findViewById(R.id.itemlokasyon1);
            itemlokasyon2 = itemView.findViewById(R.id.itemlokasyon2);
            itemnot = itemView.findViewById(R.id.itemnot);
            btnupdate = itemView.findViewById(R.id.btnupdate);
            btndelete = itemView.findViewById(R.id.btndelete);
            btndelete.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    AlertDialog.Builder dialog = new AlertDialog.Builder(btndelete.getContext());
                    dialog.setTitle("Dikkat")
                            .setMessage("Silmek İstediğinizden Emin Misiniz?")
                            .setPositiveButton("Evet", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface paramDialogInterface, int paramInt) {
                                    Log.e("KONUM", String.valueOf(getAdapterPosition()));
                                    Util.alisverislistesi.remove(getAdapterPosition());
                                    notifyDataSetChanged();
                                    AlertDialog.Builder dialog = new AlertDialog.Builder(btndelete.getContext());
                                    dialog.setTitle("Başarılı")
                                            .setMessage("Silme İşlemi Başarılı")
                                            .setPositiveButton("Tamam", new DialogInterface.OnClickListener() {
                                                @Override
                                                public void onClick(DialogInterface paramDialogInterface, int paramInt) {
                                                }
                                            });
                                    dialog.show();
                                }
                            })
                            .setNegativeButton("Hayır", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface paramDialogInterface, int paramInt) {
                                }
                            });
                    dialog.show();
                }
            });
            btnupdate.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    //GÜNCELLEME SAYFASI AÇILACAK
                }
            });
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            if (mClickListener != null) mClickListener.onItemClick(view, getAdapterPosition());
            int position = getAdapterPosition();
        }
    }

    void setClickListener(ItemClickListener itemClickListener) {
        this.mClickListener = itemClickListener;
    }

    public interface ItemClickListener {
        void onItemClick(View view, int position);
    }

}