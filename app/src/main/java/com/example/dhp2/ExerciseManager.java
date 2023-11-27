package com.example.dhp2;

import android.content.Context;
import android.content.SharedPreferences;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ExerciseManager {
    private static ExerciseManager instance;
    private Context context;
    private static SharedPreferences sharedPreferences;
    private static final int[][] milestoneRanges = {
            {1, 7},    // Milestone 1: Exercises 1-7
            {8, 16},   // Milestone 2: Exercises 8-16
            {17, 21},  // Milestone 3: Exercises 17-21
            {22, 27}   // Milestone 4: Exercises 22-27
    };

    private ExerciseManager(Context context) {
        this.context = context;
        sharedPreferences = context.getSharedPreferences("ExerciseManager", Context.MODE_PRIVATE);

        for (int i = 2; i <= 3; i++) {
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

    public int generateRandomExerciseForMilestone(int milestoneId) {
        List<Integer> allExercises = new ArrayList<>();
        for (int i = milestoneRanges[milestoneId - 1][0]; i <= milestoneRanges[milestoneId - 1][1]; i++) {
            allExercises.add(i);
        }

        Random random = new Random();

        int exercisesSize = allExercises.size();
        if (exercisesSize == 0) {
            return -1; // Return -1 if there are no exercises in the milestone
        }

        int randomIndex = random.nextInt(exercisesSize);
        return allExercises.get(randomIndex);
    }
}
