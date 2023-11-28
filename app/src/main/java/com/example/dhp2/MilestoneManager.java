package com.example.dhp2;

import android.content.Context;
import android.content.SharedPreferences;

public class MilestoneManager {
    private static MilestoneManager instance;
    private Context context;
    private static SharedPreferences sharedPreferences;

    private MilestoneManager(Context context) {
        this.context = context;
        sharedPreferences = context.getSharedPreferences("MilestoneManager", Context.MODE_PRIVATE);

        for (int i = 2; i <= 4; i++) {
            sharedPreferences.edit().putBoolean("milestone" + i, false).apply();
        }
    }

    public static synchronized MilestoneManager getInstance(Context context) {
        if (instance == null) {
            instance = new MilestoneManager(context);
        }
        return instance;
    }

    public boolean isMilestoneUnlocked(int milestoneNumber) {
        return sharedPreferences.getBoolean("milestone" + milestoneNumber, false);
    }

    public void unlockMilestone(int milestoneNumber) {
        sharedPreferences.edit().putBoolean("milestone" + milestoneNumber, true).apply();
    }
}
