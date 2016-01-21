package com.example.a15alejandroog.ud_a2a_a15alejandroog;

import android.app.DialogFragment;
import android.media.MediaRecorder;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Chronometer;

public class Record extends DialogFragment {

    private MediaRecorder mediaRecorder;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        final View rootView = inflater.inflate(R.layout.activity_record, container, false);
        getDialog().setTitle(getTag());

        final Button BTN_STOP = (Button) rootView.findViewById(R.id.btn_stop_record);
        final Chronometer CHRONO = (Chronometer) rootView.findViewById(R.id.chrono_record);

        mediaRecorder = new MediaRecorder();

        CHRONO.start();
        mediaRecorder.setAudioSource(MediaRecorder.AudioSource.MIC);

        BTN_STOP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CHRONO.stop();
                dismiss();
            }
        });


        return rootView;
    }


}
