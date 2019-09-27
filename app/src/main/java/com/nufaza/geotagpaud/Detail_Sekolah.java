package com.nufaza.geotagpaud;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.nufaza.geotagpaud.adapter.ClickedMe;
import com.nufaza.geotagpaud.adapter.ListviewAdapter;
import com.nufaza.geotagpaud.model.Sekolah_Table;
import com.nufaza.geotagpaud.ui.home.HomeFragment;
import com.raizlabs.android.dbflow.sql.language.SQLite;

import java.util.List;

public class Detail_Sekolah extends AppCompatActivity implements ClickedMe {
   // ListView listView;
    Button savebtm, updatebtm, deletebtm;
    EditText et_NPSN, et_bentuk_p, et_alamat, et_nama_kota, et_telp, et_nama_kepsek, et_nip_kepsek, et_no_hp;
  public   TextView tv_NPSN, tv_bentuk_p, tv_alamat, tv_nama_kota, tv_telp, tv_nama_kepsek, tv_nip_kepsek, tv_no_hp, NIPNwarn ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail__sekolah);

        et_NPSN = findViewById(R.id.et_npsn);
        et_bentuk_p = findViewById(R.id.et_Bentuk_Pendidikan);
        et_alamat = findViewById(R.id.et_Alamat);
        et_nama_kota = findViewById(R.id.et_nama_kabkota);
        et_telp = findViewById(R.id.et_telp);
        et_nama_kepsek = findViewById(R.id.et_Nama_Kepsek);
        et_nip_kepsek = findViewById(R.id.et_nip_kepsek);
        et_no_hp = findViewById(R.id.et_No_HP);

        savebtm = findViewById(R.id.save_btm);
        updatebtm = findViewById(R.id.update_btm) ;
        deletebtm = findViewById(R.id.delete_btm);


        tv_NPSN = findViewById(R.id.npsn);
        tv_bentuk_p = findViewById(R.id.bentuk_pendidikan_str);
        tv_alamat = findViewById(R.id.alamat_jalan);
        tv_nama_kota = findViewById(R.id.nama_kabkota);
        tv_telp = findViewById(R.id.no_telp);
        tv_nama_kepsek = findViewById(R.id.nama_kepsek);
        tv_nip_kepsek = findViewById(R.id.nip_kepsek);
        tv_no_hp = findViewById(R.id.nohp_kepsek);
        NIPNwarn = findViewById(R.id.npsnwarning);

        Intent intent = getIntent();
        int status = intent.getIntExtra("status",0);
        if (status == 1){
            et_NPSN.setVisibility(View.VISIBLE);
            et_bentuk_p.setVisibility(View.VISIBLE);
            et_alamat.setVisibility(View.VISIBLE);
            et_nama_kota.setVisibility(View.VISIBLE);
            et_telp.setVisibility(View.VISIBLE);
            et_nama_kepsek.setVisibility(View.VISIBLE);
            et_nip_kepsek.setVisibility(View.VISIBLE);
            et_no_hp.setVisibility(View.VISIBLE);
            NIPNwarn.setVisibility(View.GONE);
            savebtm.setVisibility(View.VISIBLE);
            deletebtm.setVisibility(View.GONE);
            updatebtm.setVisibility(View.GONE);
        }

        if (status == 2){
            et_NPSN.setVisibility(View.VISIBLE);
            et_bentuk_p.setVisibility(View.GONE);
            et_alamat.setVisibility(View.GONE);
            et_nama_kota.setVisibility(View.GONE);
            et_telp.setVisibility(View.GONE);
            et_nama_kepsek.setVisibility(View.GONE);
            et_nip_kepsek.setVisibility(View.GONE);
            et_no_hp.setVisibility(View.GONE);
            NIPNwarn.setVisibility(View.VISIBLE);
            NIPNwarn.setText("Input NPSN Sekolah Yang Akan Di Hapus Dibawah ini !!");
            savebtm.setVisibility(View.GONE);
            deletebtm.setVisibility(View.VISIBLE);
            updatebtm.setVisibility(View.GONE);
        }

        if (status == 3){
            et_NPSN.setVisibility(View.VISIBLE);
            et_bentuk_p.setVisibility(View.VISIBLE);
            et_alamat.setVisibility(View.VISIBLE);
            et_nama_kota.setVisibility(View.VISIBLE);
            et_nama_kepsek.setVisibility(View.VISIBLE);
            et_telp.setVisibility(View.VISIBLE);
            et_nip_kepsek.setVisibility(View.VISIBLE);
            et_no_hp.setVisibility(View.VISIBLE);
            NIPNwarn.setVisibility(View.VISIBLE);
            NIPNwarn.setText("Input NPSN Sekolah Yang Akan Di Update Dibawah ini !!");
            savebtm.setVisibility(View.GONE);
            deletebtm.setVisibility(View.GONE);
            updatebtm.setVisibility(View.VISIBLE);
        }




        savebtm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Sekolah_Table sekolah_table = new Sekolah_Table();
                sekolah_table.setNIPSN(et_NPSN.getText().toString());
                sekolah_table.setBentuk_pendidikan(et_bentuk_p.getText().toString());
                sekolah_table.setNama_kotkab(et_nama_kota.getText().toString());
                sekolah_table.setAlamat_sekolah(et_alamat.getText().toString());
                sekolah_table.setNama_kepsek(et_nama_kepsek.getText().toString());
                sekolah_table.setNotelephon(et_telp.getText().toString());
                sekolah_table.setNoHP(et_no_hp.getText().toString());
                sekolah_table.setNip(et_nip_kepsek.getText().toString());

                if (sekolah_table.save()){
                    Toast.makeText(Detail_Sekolah.this, "Save Sukses",Toast.LENGTH_SHORT).show();
                }else {
                    Toast.makeText(Detail_Sekolah.this, "Saved Gagal", Toast.LENGTH_SHORT).show();
                }
              //  sekolah_table.setNIPSN(et_NPSN.getText().toString());
            }
        });

        deletebtm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Sekolah_Table sekolah_table = new Sekolah_Table();
                sekolah_table.setNIPSN(et_NPSN.getText().toString());
                if (sekolah_table.delete()) {
                    Toast.makeText(Detail_Sekolah.this, "Record of NPSN "+et_NPSN.getText().toString()+" deleted ", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(Detail_Sekolah.this, "delete failed", Toast.LENGTH_SHORT).show();
                }
            }
        });

        updatebtm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Sekolah_Table sekolah_table = new Sekolah_Table();
                sekolah_table.setNIPSN(et_NPSN.getText().toString());
                sekolah_table.setBentuk_pendidikan(et_bentuk_p.getText().toString());
                sekolah_table.setNama_kotkab(et_nama_kota.getText().toString());
                sekolah_table.setAlamat_sekolah(et_alamat.getText().toString());
                sekolah_table.setNama_kepsek(et_nama_kepsek.getText().toString());
                sekolah_table.setNotelephon(et_telp.getText().toString());
                sekolah_table.setNoHP(et_no_hp.getText().toString());
                sekolah_table.setNip(et_nip_kepsek.getText().toString());

                if (sekolah_table.save() && et_NPSN != null){
                    Toast.makeText(Detail_Sekolah.this, "Update atau Save Sukses",Toast.LENGTH_SHORT).show();
                }else {
                    Toast.makeText(Detail_Sekolah.this, "Update Gagal", Toast.LENGTH_SHORT).show();
                }
                //  sekolah_table.setNIPSN(et_NPSN.getText().toString());

            }
        });
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
