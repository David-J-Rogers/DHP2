package com.example.dhp2;

import android.content.Context;
import android.content.SharedPreferences;

public class ExerciseManager {
    private static ExerciseManager instance;
    private Context context;
    private static SharedPreferences sharedPreferences;

    private ExerciseManager(Context context) {
        this.context = context;
        sharedPreferences = context.getSharedPreferences("ExerciseManager", Context.MODE_PRIVATE);

        for (int i = 2; i <= 4; i++) {
            sharedPreferences.edit().putBoolean("exercise" + i, false).apply();
        }
    }

    public static synchronized ExerciseManager getInstance(Context context) {
        if (instance == null) {
            instance = new ExerciseManager(context);
        }
        return instance;
    }

    public boolean isExerciseUnlocked(int exerciseNumber) {
        return sharedPreferences.getBoolean("exercise" + exerciseNumber, false);
    }

    public static void unlockExercise(int exerciseNumber) {
        sharedPreferences.edit().putBoolean("exercise" + exerciseNumber, true).apply();
    }
}
