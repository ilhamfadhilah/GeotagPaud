package com.nufaza.geotagpaud.model;
/*
import com.dbflow5.annotation.Column;
import com.dbflow5.annotation.PrimaryKey;
import com.dbflow5.annotation.Table;
import com.dbflow5.structure.BaseModel;

 */
import com.nufaza.geotagpaud.GeotagAplication;
import com.nufaza.geotagpaud.GeotagDatabase;

import com.raizlabs.android.dbflow.annotation.Column;
import com.raizlabs.android.dbflow.annotation.PrimaryKey;
import com.raizlabs.android.dbflow.annotation.Table;
import com.raizlabs.android.dbflow.structure.BaseModel;



@Table(database = GeotagDatabase.class)
public class Sekolah_Table extends BaseModel {
    @PrimaryKey
    public String NIPSN;
    @Column
    public String bentuk_pendidikan;
    @Column
    public String alamat_sekolah;
    @Column
    public String nama_kotkab;
    @Column
    public String nama_kepsek;
    @Column
    public String nip;
    @Column
    public String noHP;
    @Column
    public String notelephon;
    @Column
    public int jumlah_Siswa;

    @Column
    public int jumlah_guru;

    @Column
    public int jumlah_ruang_kelas;

    @Column
    public int jumlah_prasana_lain;

    @Column
    public int jumlah_rombel;

    @Column
    public int luas_lahan_miliksekolah;

    @Column
    public int luas_lahan_bukan_milik_sekolah;

    public String getNIPSN() {
        return NIPSN;
    }

    public void setNIPSN(String NIPSN) {
        this.NIPSN = NIPSN;
    }

    public String getBentuk_pendidikan() {
        return bentuk_pendidikan;
    }

    public void setBentuk_pendidikan(String bentuk_pendidikan) {
        this.bentuk_pendidikan = bentuk_pendidikan;
    }

    public String getAlamat_sekolah() {
        return alamat_sekolah;
    }

    public void setAlamat_sekolah(String alamat_sekolah) {
        this.alamat_sekolah = alamat_sekolah;
    }

    public String getNama_kepsek() {
        return nama_kepsek;
    }

    public void setNama_kepsek(String nama_kepsek) {
        this.nama_kepsek = nama_kepsek;
    }

    public String getNip() {
        return nip;
    }

    public void setNip(String nip) {
        this.nip = nip;
    }

    public String getNoHP() {
        return noHP;
    }

    public void setNoHP(String noHP) {
        this.noHP = noHP;
    }

    public String getNotelephon() {
        return notelephon;
    }

    public void setNotelephon(String notelephon) {
        this.notelephon = notelephon;
    }

    public int getJumlah_Siswa() {
        return jumlah_Siswa;
    }

    public void setJumlah_Siswa(int jumlah_Siswa) {
        this.jumlah_Siswa = jumlah_Siswa;
    }

    public int getJumlah_guru() {
        return jumlah_guru;
    }

    public void setJumlah_guru(int jumlah_guru) {
        this.jumlah_guru = jumlah_guru;
    }

    public int getJumlah_ruang_kelas() {
        return jumlah_ruang_kelas;
    }

    public void setJumlah_ruang_kelas(int jumlah_ruang_kelas) {
        this.jumlah_ruang_kelas = jumlah_ruang_kelas;
    }

    public int getJumlah_prasana_lain() {
        return jumlah_prasana_lain;
    }

    public void setJumlah_prasana_lain(int jumlah_prasana_lain) {
        this.jumlah_prasana_lain = jumlah_prasana_lain;
    }

    public int getJumlah_rombel() {
        return jumlah_rombel;
    }

    public void setJumlah_rombel(int jumlah_rombel) {
        this.jumlah_rombel = jumlah_rombel;
    }

    public int getLuas_lahan_miliksekolah() {
        return luas_lahan_miliksekolah;
    }

    public void setLuas_lahan_miliksekolah(int luas_lahan_miliksekolah) {
        this.luas_lahan_miliksekolah = luas_lahan_miliksekolah;
    }

    public int getLuas_lahan_bukan_milik_sekolah() {
        return luas_lahan_bukan_milik_sekolah;
    }

    public void setLuas_lahan_bukan_milik_sekolah(int luas_lahan_bukan_milik_sekolah) {
        this.luas_lahan_bukan_milik_sekolah = luas_lahan_bukan_milik_sekolah;
    }

    public String getNama_kotkab() {
        return nama_kotkab;
    }

    public void setNama_kotkab(String nama_kotkab) {
        this.nama_kotkab = nama_kotkab;
    }
}
