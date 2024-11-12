package com.example.pruebaandroid;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import org.jetbrains.annotations.Nullable;

public class DataHelper extends SQLiteOpenHelper {

    public DataHelper(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE ventas_autos (" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT, " +  // ID de la venta
                "nombre_comprador TEXT, " +                 // Nombre del comprador
                "telefono_comprador TEXT, " +               // Teléfono del comprador
                "direccion_comprador TEXT, " +              // Dirección del comprador
                "modelo_auto TEXT" +                        // Modelo del auto
                ")");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS ventas_autos");
        onCreate(db);
    }
}
