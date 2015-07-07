package com.mcs.assignment.utils;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.app.ProgressDialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.view.Gravity;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.RelativeLayout;
import android.widget.TextView;


/**
 * Utility class to handle activity related common functions
 *
 * @author erangaeb@gmail.com (eranga herath)
 */
public class ActivityUtils {

    private static ProgressDialog progressDialog;

    /**
     * Hide keyboard
     * Need to hide soft keyboard in following scenarios
     *  1. When starting background task
     *  2. When exit from activity
     *  3. On button submit
     */
    public static void hideSoftKeyboard(Activity activity) {
        InputMethodManager inputMethodManager = (InputMethodManager) activity.getApplicationContext().getSystemService(activity.INPUT_METHOD_SERVICE);
        inputMethodManager.hideSoftInputFromWindow(activity.getWindow().getDecorView().getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);
    }

    /**
     * Create and show custom progress dialog
     * Progress dialogs displaying on background tasks
     *
     * So in here
     *  1. Create custom layout for message dialog
     *  2, Set messages to dialog
     * @param context activity context
     * @param message message to be display
     */
    public static void showProgressDialog(Context context, String message) {
        progressDialog = ProgressDialog.show(context, null, message, true);
        progressDialog.setCancelable(true);

        progressDialog.show();
    }

    /**
     * Cancel progress dialog when background task finish
     */
    public static void cancelProgressDialog() {
        if (progressDialog!=null) {
            progressDialog.cancel();
        }
    }

    /**
     * Create custom text view for tab view
     * Set custom typeface to the text view as well
     * @param context application context
     * @param title tab title
     * @return text view
     */
    public static TextView getCustomTextView(Context context, String title) {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
        Typeface typefaceThin = Typeface.createFromAsset(context.getAssets(), "fonts/vegur_2.otf");

        TextView textView = new TextView(context);
        textView.setText(title);
        textView.setTypeface(typefaceThin);
        textView.setTextColor(Color.parseColor("#4a4a4a"));
        textView.setGravity(Gravity.CENTER);
        textView.setTextSize(18);
        textView.setLayoutParams(layoutParams);

        return textView;
    }

    /**
     * Display AlertDialog
     * @param context application context
     * @param title title message
     * @param message alert message
     */
    public static void showAlertDialog(Context context, String title, String message) {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle(title);
        builder.setMessage(message);
        builder.setCancelable(true);
        builder.setPositiveButton("Ok",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                    }
                });
        AlertDialog alert = builder.create();
        alert.show();
    }

}
