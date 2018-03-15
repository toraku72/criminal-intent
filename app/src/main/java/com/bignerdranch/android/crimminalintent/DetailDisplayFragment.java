package com.bignerdranch.android.crimminalintent;

import android.app.Dialog;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;
import android.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;

import java.io.File;

public class DetailDisplayFragment extends DialogFragment {
    private static final String ARG_FILE = "file";

    private ImageView mPhoto;

    public static DetailDisplayFragment newInstance(File photoFile) {
        Bundle args = new Bundle();
        args.putSerializable(ARG_FILE, photoFile);

        DetailDisplayFragment fragment = new DetailDisplayFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        File photoFile = (File) getArguments().getSerializable(ARG_FILE);

        View v = LayoutInflater.from(getActivity()).inflate(R.layout.dialog_detail_photo, null);
        mPhoto = (ImageView) v.findViewById(R.id.detail_photo);

        Bitmap bitmap = PictureUtils.getScaledBitmap(photoFile.getPath(), getActivity());
        mPhoto.setImageBitmap(bitmap);

        return new AlertDialog.Builder(getActivity(), R.style.ThemeOverlay_AppCompat_Dialog)
                .setView(v)
                .create();
    }
}
