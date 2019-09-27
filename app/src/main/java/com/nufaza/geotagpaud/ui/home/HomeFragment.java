package com.nufaza.geotagpaud.ui.home;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.nufaza.geotagpaud.Detail_Sekolah;
import com.nufaza.geotagpaud.R;
import com.nufaza.geotagpaud.adapter.ClickedMe;
import com.nufaza.geotagpaud.adapter.ListviewAdapter;
import com.nufaza.geotagpaud.model.Sekolah_Table;
import com.raizlabs.android.dbflow.sql.language.SQLite;

import java.util.List;

public class HomeFragment extends Fragment implements ClickedMe {

    Button tambahsekolah, deletebtm;
    Button updatesekolah, refreshsekolah;
    ImageView panah;

public     TextView tv_NPSN, tv_bentuk_p, tv_alamat, tv_nama_kota, tv_telp, tv_nama_kepsek, tv_nip_kepsek, tv_no_hp, warntrefresh ;


    private int status = 0;

    View view;
    ListView listView;

    private HomeViewModel homeViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        homeViewModel =
                ViewModelProviders.of(this).get(HomeViewModel.class);
        view = inflater.inflate(R.layout.fragment_home, container, false);
        listView = view.findViewById(R.id.list_item);
        warntrefresh = view.findViewById(R.id.warnRefresh);
        panah = view.findViewById(R.id.arrowarnt);

        populateListView();


        tambahsekolah = view.findViewById(R.id.tambahsekolah);
        tambahsekolah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                status = 1;
                refreshvisible();
                //Toast.makeText(getActivity(), "Update Gagal", Toast.LENGTH_SHORT).show();
                Intent intent2 = new Intent(getActivity(),Detail_Sekolah.class);
                intent2.putExtra("status",status);
                startActivity(intent2);


            }
        });

        deletebtm = view.findViewById(R.id.deletesekolah);
        deletebtm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                status = 2;
                refreshvisible();
                Intent intent = new Intent(getActivity(),Detail_Sekolah.class);
                intent.putExtra("status",status);
                startActivity(intent);

            }
        });

        updatesekolah = view.findViewById(R.id.updatekansekolah);
        updatesekolah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                status = 3;
                refreshvisible();
                //Toast.makeText(getActivity(), "Update Gagal", Toast.LENGTH_SHORT).show();
                Intent intent3 = new Intent(getActivity(),Detail_Sekolah.class);
                intent3.putExtra("status",status);
                startActivity(intent3);
            }
        });

        refreshsekolah = view.findViewById(R.id.refreshsekolah);
        refreshsekolah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                populateListView();
                refreshgone();
            }
        });



//        final TextView textView = root.findViewById(R.id.text_home);
//        homeViewModel.getText().observe(this, new Observer<String>() {
//            @Override
//            public void onChanged(@Nullable String s) {
//                textView.setText(s);
//            }
//        });
        return view;


    }

    void refreshgone(){
        refreshsekolah.setVisibility(View.GONE);
        warntrefresh.setVisibility(View.GONE);
        panah.setVisibility(View.GONE);

    }
    void refreshvisible(){
        refreshsekolah.setVisibility(View.VISIBLE);
        warntrefresh.setVisibility(View.VISIBLE);
        panah.setVisibility(View.VISIBLE);

    }
    void populateListView(){
        List<Sekolah_Table> sekolah_tableList = SQLite.select().from(Sekolah_Table.class).queryList();
        ListviewAdapter listViewAdapter = new ListviewAdapter(getActivity(), sekolah_tableList);
        listView.setAdapter(listViewAdapter);
    }

    @Override
    public void setData(Sekolah_Table sekolah_table) {
        Log.d("data - data",sekolah_table.toString());
        tv_NPSN.setText(""+sekolah_table.getNIPSN());
        tv_bentuk_p.setText(""+sekolah_table.getBentuk_pendidikan());
        tv_alamat.setText(""+sekolah_table.getAlamat_sekolah());
        tv_nama_kota.setText(""+sekolah_table.getNama_kotkab());
        tv_telp.setText(""+sekolah_table.getNotelephon());
        tv_nama_kepsek.setText(""+sekolah_table.getNama_kepsek());
        tv_nip_kepsek.setText(""+sekolah_table.getNip());
        tv_no_hp.setText(""+sekolah_table.getNoHP());
    }
}