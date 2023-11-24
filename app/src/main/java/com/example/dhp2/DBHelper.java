package com.example.dhp2;
import android.database.sqlite.SQLiteOpenHelper;

import android.database.sqlite.SQLiteDatabase;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;

    public class DBHelper extends SQLiteOpenHelper {
        private static final String DATABASE_NAME = "PatientData.db";
        private static final int DATABASE_VERSION = 1;

        public DBHelper(Context context) {
            super(context, DATABASE_NAME, null, DATABASE_VERSION);
        }

        @Override
        public void onCreate(SQLiteDatabase db) {
            String CREATE_TABLE = "CREATE TABLE PatientData (" +
                    "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                    "age INTEGER," +
                    "time_of_surgery TEXT," +
                    "milestone_one_completion_factor REAL," +
                    "milestone_two_completion_factor REAL," +
                    "milestone_three_completion_factor REAL," +
                    "milestone_four_completion_factor REAL" +
                    ")";
            db.execSQL(CREATE_TABLE);
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            db.execSQL("DROP TABLE IF EXISTS PatientData");
            onCreate(db);
        }

        //insert
        public void addPatient(int age, String timeOfSurgery, double m1, double m2, double m3, double m4) {
            SQLiteDatabase db = this.getWritableDatabase();
            ContentValues values = new ContentValues();
            values.put("age", age);
            values.put("time_of_surgery", timeOfSurgery);
            values.put("milestone_one_completion_factor", m1);
            values.put("milestone_two_completion_factor", m2);
            values.put("milestone_three_completion_factor", m3);
            values.put("milestone_four_completion_factor", m4);

            db.insert("PatientData", null, values);
            db.close();
        }

        //read
        public Cursor getPatient(int id) {
            SQLiteDatabase db = this.getReadableDatabase();
            Cursor cursor = db.query("PatientData", new String[]{"age", "time_of_surgery", "milestone_one_completion_factor", "milestone_two_completion_factor", "milestone_three_completion_factor", "milestone_four_completion_factor"}, "id = ?", new String[]{String.valueOf(id)}, null, null, null);
            if (cursor != null)
                cursor.moveToFirst();
            return cursor;
        }

        //update
        public int updatePatient(int id, int age, String timeOfSurgery, double m1, double m2, double m3, double m4) {
            SQLiteDatabase db = this.getWritableDatabase();
            ContentValues values = new ContentValues();
            values.put("age", age);
            values.put("time_of_surgery", timeOfSurgery);
            values.put("milestone_one_completion_factor", m1);
            values.put("milestone_two_completion_factor", m2);
            values.put("milestone_three_completion_factor", m3);
            values.put("milestone_four_completion_factor", m4);

            return db.update("PatientData", values, "id = ?", new String[]{String.valueOf(id)});
        }

        //delete
        public void deletePatient(int id) {
            SQLiteDatabase db = this.getWritableDatabase();
            db.delete("PatientData", "id = ?", new String[]{String.valueOf(id)});
            db.close();
        }

    }

