package com.example.application.workoutapp;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lenovo on 6/21/2017.
 */

public class WorkoutExpert {
    List<String> getWorkouts(String workouttypes)
    {
        List<String> workout=new ArrayList<String>();
        if(workouttypes.equals("Chest"))
        {
            workout.add("Bench Press");
            workout.add("Cable Flys");
        }
        else if(workouttypes.equals("Triceps"))
        {
            workout.add("Tricep Ext");
            workout.add("Tricep Push Down");
        }
        else if(workouttypes.equals("Shoulder"))
        {
            workout.add("Shoulder Press");
        }
        else if(workouttypes.equals("Biceps"))
        {
            workout.add("Bicep Curls");
        }
        return workout;
    }

}
