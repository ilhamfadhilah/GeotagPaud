package com.nufaza.geotagpaud;


import com.raizlabs.android.dbflow.annotation.Database;

@Database(name = GeotagDatabase.DBName, version = GeotagDatabase.VERSION)
public class GeotagDatabase {
    public static final String DBName = "geotagDB";
    public static final int VERSION = 1;
}
