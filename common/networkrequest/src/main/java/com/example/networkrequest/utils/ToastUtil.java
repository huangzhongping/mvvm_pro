package com.example.networkrequest.utils;

import android.content.Context;
import android.widget.Toast;

/**
 * Created by Eric on 16/9/5.
 */
public class ToastUtil {
    public static void showToast(Context context, String msg) {
        Toast.makeText(context, msg, Toast.LENGTH_SHORT).show();
    }

    public static void showToast(String msg) {
        showToast(Utils.getContext(), msg);
    }

}
