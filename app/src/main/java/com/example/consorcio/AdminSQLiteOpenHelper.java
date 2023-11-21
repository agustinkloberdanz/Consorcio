//package com.example.consorcio;
//
//import android.content.ContentValues;
//import android.content.Context;
//import android.database.sqlite.SQLiteDatabase;
//import android.database.sqlite.SQLiteOpenHelper;
//import android.database.Cursor;
//
//import androidx.annotation.Nullable;
//
//import java.util.ArrayList;
//import java.util.List;
//
//public class AdminSQLiteOpenHelper extends SQLiteOpenHelper {
//    public AdminSQLiteOpenHelper(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
//        super(context, name, factory, version);
//    }
//
//    @Override
//    public void onCreate(SQLiteDatabase db) {
//        db.execSQL("CREATE TABLE users(dni INTEGER,password TEXT, admin INTEGER DEFAULT 0)");
//        db.execSQL("CREATE TABLE deudas(id LONG PRIMARY KEY AUTOINCREMENT, dni INTEGER,valor DOUBLE, detalle TEXT, fecha TEXT)");
//
//        db.execSQL("INSERT INTO users VALUES(44860530, 44860530, 1)");
//    }
//
//
//    @Override
//    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
//    }
//
//    public User getUserData(int dni) {
//        SQLiteDatabase bd = getReadableDatabase();
//        Cursor cursor = bd.rawQuery("SELECT * FROM users WHERE dni=" + dni, null);
//
//        if(cursor.moveToFirst()) {
//            System.out.println(cursor.getInt(0));
//            System.out.println(cursor.getString(1));
//            System.out.println(cursor.getInt(2));
//
//            Boolean admin;
//            if (cursor.getInt(2) == 1) admin = true;
//            else admin = false;
//
//            User user = new User(cursor.getInt(0), cursor.getString(1), admin);
//            System.out.println(user);
//            return user;
//
//        } else {
//            return null;
//        }
//    }
//
//    public void agregarDeuda(Deuda deuda) {
//        SQLiteDatabase bd = getWritableDatabase();
//        ContentValues registro = new ContentValues();
//        registro.put("dni", deuda.getDni());
//        registro.put("valor", deuda.getValor());
//        registro.put("detalle", deuda.getDetalle());
//        registro.put("fecha", deuda.getFecha());
//        bd.insert("deudas", null, registro);
//        bd.close();
//    }
//
//    public void eliminarDeuda(long id) {
//        SQLiteDatabase bd = getWritableDatabase();
//        bd.delete("deudas", "id="+id,null);
//        bd.close();
//    }
//
//    public List<Deuda> listarDeudasPorDni(int dni) {
//        List<Deuda> list = new ArrayList<>();
//        SQLiteDatabase bd = getReadableDatabase();
//        Cursor cursor = bd.rawQuery("SELECT * FROM deudas WHERE dni=" + dni, null);
//
//        if(cursor.moveToFirst()) {
//            do {
//                list.add(new Deuda(cursor.getInt(0), cursor.getInt(1), cursor.getDouble(2), cursor.getString(3), cursor.getString(4)));
//            }while(cursor.moveToNext());
//            cursor.close();
//            return list;
//        } else {
//            return null;
//        }
//    }
//
//    public List<Deuda> listarDeudas() {
//        List<Deuda> list = new ArrayList<>();
//        SQLiteDatabase bd = getReadableDatabase();
//        Cursor cursor = bd.rawQuery("SELECT * FROM deudas ORDER BY dni ASC", null);
//
//        if(cursor.moveToFirst()) {
//            do {
//                list.add(new Deuda(cursor.getInt(0), cursor.getInt(1), cursor.getDouble(2), cursor.getString(3), cursor.getString(4)));
//            }while(cursor.moveToNext());
//            cursor.close();
//            return list;
//        }
//        else {
//            return null;
//        }
//    }
//
//
//
//}
