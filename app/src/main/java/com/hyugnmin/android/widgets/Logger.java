package com.hyugnmin.android.widgets;

import android.util.Log;

/**
 * Created by besto on 2017-01-26.
 */

public class Logger {

    public final static boolean DEBUG_MODE = true;

    public static void print(String str, String className) {
        if(DEBUG_MODE)
            Log.d(className, str);
    }


}
