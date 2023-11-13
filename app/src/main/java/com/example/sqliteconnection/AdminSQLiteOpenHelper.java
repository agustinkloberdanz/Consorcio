package com.example.sqliteconnection;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.Cursor;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class AdminSQLiteOpenHelper extends SQLiteOpenHelper {
    public AdminSQLiteOpenHelper(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE users(dni INTEGER,password TEXT, admin BOOLEAN)");
        db.execSQL("CREATE TABLE deudas(dni INTEGER,valor DOUBLE, detalle TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
    }

    public void agregarDeuda(Deuda deuda) {
        SQLiteDatabase bd = getWritableDatabase();
        ContentValues registro = new ContentValues();
        registro.put("dni", deuda.getDni());
        registro.put("valor", deuda.getValor());
        registro.put("detalle", deuda.getDetalle());
        bd.insert("deudas", null, registro);
        bd.close();
    }

    public List<Deuda> listarDeudasPorDni(int dni) {
        List<Deuda> list = new ArrayList<>();
        SQLiteDatabase bd = getReadableDatabase();
        Cursor cursor = bd.rawQuery("SELECT * FROM deudas WHERE dni=" + dni, null);

        if(cursor.moveToFirst()) {
            do {
                list.add(new Deuda(cursor.getInt(0), cursor.getDouble(1), cursor.getString(2)));
            }while(cursor.moveToNext());
        }
        cursor.close();
        return list;
    }

    public List<Deuda> listarDeudas() {
        List<Deuda> list = new ArrayList<>();
        SQLiteDatabase bd = getReadableDatabase();
        Cursor cursor = bd.rawQuery("SELECT * FROM deudas ORDER BY dni ASC", null);

        if(cursor.moveToFirst()) {
            do {
                list.add(new Deuda(cursor.getInt(0), cursor.getDouble(1), cursor.getString(2)));
            }while(cursor.moveToNext());
        }
        cursor.close();
        return list;
    }



}
