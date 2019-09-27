package com.nufaza.geotagpaud.adapter;

import android.content.Context;
import android.content.Intent;
import android.text.Layout;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.fragment.app.FragmentActivity;

import com.nufaza.geotagpaud.Detail_Sekolah;
import com.nufaza.geotagpaud.R;
import com.nufaza.geotagpaud.model.Sekolah_Table;
import com.nufaza.geotagpaud.ui.home.HomeFragment;
import com.raizlabs.android.dbflow.sql.language.SQLite;

import java.util.List;

public class ListviewAdapter extends BaseAdapter {


    TextView tv_NPSN, tv_bentuk_p, tv_alamat, tv_nama_kota, tv_telp, tv_nama_kepsek, tv_nip_kepsek, tv_no_hp;
    Context context;
    List<Sekolah_Table> sekolahTableList;
    ClickedMe clickedMe;

    public ListviewAdapter(Context context, List<Sekolah_Table> sekolahtabelList){
        this.context = context;
        this.sekolahTableList = sekolahtabelList;
    }



    @Override
    public int getCount() {
        return sekolahTableList.size();
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        View view = LayoutInflater.from(context).inflate(R.layout.sekolah_profil_identitas,parent,false);

        tv_NPSN = view.findViewById(R.id.npsn);
        tv_bentuk_p = view.findViewById(R.id.bentuk_pendidikan_str);
        tv_alamat = view.findViewById(R.id.alamat_jalan);
        tv_nama_kota = view.findViewById(R.id.nama_kabkota);
        tv_telp = view.findViewById(R.id.no_telp);
        tv_nama_kepsek = view.findViewById(R.id.nama_kepsek);
        tv_nip_kepsek = view.findViewById(R.id.nip_kepsek);
        tv_no_hp = view.findViewById(R.id.nohp_kepsek);

        tv_NPSN.setText(""+sekolahTableList.get(position).getNIPSN());
        tv_bentuk_p.setText(""+sekolahTableList.get(position).getBentuk_pendidikan());
        tv_alamat.setText(""+sekolahTableList.get(position).getAlamat_sekolah());
        tv_nama_kota.setText(""+sekolahTableList.get(position).getNama_kotkab());
        tv_telp.setText(""+sekolahTableList.get(position).getNotelephon());
        tv_nama_kepsek.setText(""+sekolahTableList.get(position).getNama_kepsek());
        tv_nip_kepsek.setText(""+sekolahTableList.get(position).getNip());
        tv_no_hp.setText(""+sekolahTableList.get(position).getNoHP());




        return view;
    }

}
