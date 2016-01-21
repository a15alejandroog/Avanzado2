package com.example.a15alejandroog.ud_a2a_a15alejandroog;

import android.app.Fragment;
import android.app.FragmentManager;
import android.content.Intent;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Spinner;

import java.io.File;

public class UD_A2A_a15alejandroog extends AppCompatActivity {

    final String RESOURCE_FOLDER = "UD-A2A";
    private Record fragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ud__a2_a_a15alejandroog);

        final Spinner SPINNER = (Spinner) findViewById(R.id.spin_music);
        final Button BTN_PLAY = (Button) findViewById(R.id.btn_play);
        final Button BTN_RECORD = (Button) findViewById(R.id.btn_record);
        final Button BTN_PICTURE = (Button) findViewById(R.id.btn_picture);

        final File AUDIO_FOLDER = new File(String.format("%s%s%s%sMUSICA", Environment.getExternalStorageDirectory().toString(), File.separator, RESOURCE_FOLDER, File.separator));
        final File PICTURE_FOLDER= new File(String.format("%s%s%s%sFOTO", Environment.getExternalStorageDirectory().toString(), File.separator, RESOURCE_FOLDER, File.separator));

        if(!AUDIO_FOLDER.exists()){
            AUDIO_FOLDER.mkdirs();
            Log.i("AUDIO", "CREATED");
        }

        if(!PICTURE_FOLDER.exists()){
            PICTURE_FOLDER.mkdirs();
            Log.i("PICTURE", "CREATED");
        }

        Log.i("AUDIO", AUDIO_FOLDER.getAbsolutePath());
        Log.i("PICTURE", PICTURE_FOLDER.getAbsolutePath());

        BTN_RECORD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager fm = getFragmentManager();
                fragment = new Record();
                fragment.show(fm, getString(R.string.title_activity_record));
            }
        });

    }
}
