package com.ifsc.tacoapp.model;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

public class TacoDao {
    private Context context;
    private SQLiteDatabase database;
    private String TACO_TABLE = "taco";

    public TacoDao(Context context) {
        this.context = context;
        database = context.openOrCreateDatabase("taco_db", Context.MODE_PRIVATE, null);

        createTacoTable();
        TacoDataImporter.initializeData(database, TACO_TABLE);
    }

    public ArrayList<Taco> getTacos() {
        Cursor cursor = database.rawQuery("SELECT * FROM " + TACO_TABLE, null);
        cursor.moveToFirst();

        ArrayList<Taco> tacoItems = new ArrayList<>();
        while (!cursor.isAfterLast()) {
            Taco taco = new Taco(
                    cursor.getInt(0),
                    cursor.getString(1),
                    cursor.getString(2),
                    cursor.getString(3),
                    cursor.getString(4),
                    cursor.getString(5),
                    cursor.getString(6),
                    cursor.getString(7),
                    cursor.getString(8),
                    cursor.getString(9),
                    cursor.getString(10),
                    cursor.getString(11),
                    cursor.getString(12),
                    cursor.getString(13),
                    cursor.getString(14),
                    cursor.getString(15),
                    cursor.getString(16),
                    cursor.getString(17),
                    cursor.getString(18),
                    cursor.getString(19),
                    cursor.getString(20),
                    cursor.getString(21),
                    cursor.getString(22),
                    cursor.getString(23),
                    cursor.getString(24),
                    cursor.getString(25),
                    cursor.getString(26),
                    cursor.getString(27),
                    cursor.getString(28)
            );
            tacoItems.add(taco);
            cursor.moveToNext();
        }

        return tacoItems;
    }

    public Taco getTacoById(Integer id) {
        Cursor cursor = this.database.rawQuery(
                "SELECT * FROM " + TACO_TABLE + " WHERE id=?",
                new String [] {Integer.toString(id)}
        );
        cursor.moveToFirst();

        return new Taco(
                cursor.getInt(0),
                cursor.getString(1),
                cursor.getString(2),
                cursor.getString(3),
                cursor.getString(4),
                cursor.getString(5),
                cursor.getString(6),
                cursor.getString(7),
                cursor.getString(8),
                cursor.getString(9),
                cursor.getString(10),
                cursor.getString(11),
                cursor.getString(12),
                cursor.getString(13),
                cursor.getString(14),
                cursor.getString(15),
                cursor.getString(16),
                cursor.getString(17),
                cursor.getString(18),
                cursor.getString(19),
                cursor.getString(20),
                cursor.getString(21),
                cursor.getString(22),
                cursor.getString(23),
                cursor.getString(24),
                cursor.getString(25),
                cursor.getString(26),
                cursor.getString(27),
                cursor.getString(28)
        );
    }

    private void createTacoTable() {
        database.execSQL(
                "CREATE TABLE IF NOT EXISTS " + TACO_TABLE + "(\n" +
                        "  id INTEGER PRIMARY KEY AUTOINCREMENT,\n" +
                        "  Categoria varchar(37) DEFAULT NULL,\n" +
                        "  Alimento varchar(64) DEFAULT NULL,\n" +
                        "  Umidade varchar(4) DEFAULT NULL,\n" +
                        "  Energiakcal varchar(3) DEFAULT NULL,\n" +
                        "  kJ varchar(4) DEFAULT NULL,\n" +
                        "  Proteonag varchar(4) DEFAULT NULL,\n" +
                        "  Lipodeosg varchar(5) DEFAULT NULL,\n" +
                        "  Colesterolmg varchar(4) DEFAULT NULL,\n" +
                        "  Carboidratosg varchar(4) DEFAULT NULL,\n" +
                        "  FibraAlimentarg varchar(4) DEFAULT NULL,\n" +
                        "  Cinzasg varchar(4) DEFAULT NULL,\n" +
                        "  Calciomg varchar(4) DEFAULT NULL,\n" +
                        "  Magnesiomg varchar(3) DEFAULT NULL,\n" +
                        "  Manganesmg varchar(5) DEFAULT NULL,\n" +
                        "  Fosforomg varchar(4) DEFAULT NULL,\n" +
                        "  Ferromg varchar(4) DEFAULT NULL,\n" +
                        "  Sodiomg varchar(5) DEFAULT NULL,\n" +
                        "  Potassiomg varchar(5) DEFAULT NULL,\n" +
                        "  Cobremg varchar(5) DEFAULT NULL,\n" +
                        "  Zincomg varchar(4) DEFAULT NULL,\n" +
                        "  Retinolmcg varchar(5) DEFAULT NULL,\n" +
                        "  REmcg varchar(5) DEFAULT NULL,\n" +
                        "  RAEmcg varchar(5) DEFAULT NULL,\n" +
                        "  Tiaminamg varchar(4) DEFAULT NULL,\n" +
                        "  Riboflavinamg varchar(4) DEFAULT NULL,\n" +
                        "  Piridoxinamg varchar(5) DEFAULT NULL,\n" +
                        "  Niacinamg varchar(5) DEFAULT NULL,\n" +
                        "  VitaminaCmg varchar(5) DEFAULT NULL\n" +
                        ")"
        );
    }
}
