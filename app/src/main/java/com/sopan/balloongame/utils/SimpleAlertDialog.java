package com.sopan.balloongame.utils;

import android.app.Dialog;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.DialogFragment;

/**
 * Created by Sopan on 22-May-17.
 */

public class SimpleAlertDialog extends DialogFragment {

    private static final String TITLE_KEY = "title_key";
    private static final String MESSAGE_KEY = "message_key";

    public SimpleAlertDialog() {
    }

    public static SimpleAlertDialog newInstance(String title, String message) {

        Bundle args = new Bundle();
        args.putString(TITLE_KEY, title);
        args.putString(MESSAGE_KEY, message);

        SimpleAlertDialog fragment = new SimpleAlertDialog();
        fragment.setArguments(args);
        return fragment;
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        Bundle args = getArguments();
        if (args == null) throw new AssertionError();

        String title = args.getString(TITLE_KEY);
        String prompt = args.getString(MESSAGE_KEY);

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity())
                .setTitle(title)
                .setMessage(prompt)
                .setCancelable(false);

        builder.setPositiveButton(android.R.string.ok, null);
        return builder.create();

    }

}