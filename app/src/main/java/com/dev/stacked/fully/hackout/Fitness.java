package com.dev.stacked.fully.hackout;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.widget.ToggleButton;

import java.io.FileInputStream;
import java.io.FileOutputStream;


public class Fitness extends Activity {
    Context context;
    EditText et_workout;
    ToggleButton toggle_edit;
    Button btn_load;
    Button btn_save;

    String FILENAME = "curr_workout_file";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fitness);
        context = getApplicationContext();
        et_workout = (EditText) findViewById(R.id.fit_workout_name);
        toggle_edit = (ToggleButton) findViewById(R.id.fit_edit_mode);
        btn_load = (Button) findViewById(R.id.fit_load);
        btn_save = (Button) findViewById(R.id.fit_save);

        btn_load.setClickable(false);
        btn_save.setClickable(false);
        btn_load.setTextColor(getResources().getColor(R.color.light_grey));
        btn_save.setTextColor(getResources().getColor(R.color.light_grey));
        et_workout.setEnabled(false);
        et_workout.setCursorVisible(false);

        toggle_edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(toggle_edit.isChecked()){
                    btn_load.setClickable(true);
                    btn_save.setClickable(true);
                    btn_load.setTextColor(getResources().getColor(R.color.black));
                    btn_save.setTextColor(getResources().getColor(R.color.black));
                    et_workout.setEnabled(true);
                    et_workout.setCursorVisible(true);
                }
                else{
                    btn_load.setClickable(false);
                    btn_save.setClickable(false);
                    btn_load.setTextColor(getResources().getColor(R.color.light_grey));
                    btn_save.setTextColor(getResources().getColor(R.color.light_grey));
                    et_workout.setEnabled(false);
                    et_workout.setCursorVisible(false);
                }
            }
        });

        btn_load.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(context, "Workout loaded.", Toast.LENGTH_SHORT).show();
                try {
                    String file_string = "";
                    FileInputStream fis = openFileInput(FILENAME);
                    int currByte = fis.read();
                    while (currByte != -1) {
                        file_string += (char) currByte;
                        currByte = fis.read();
                    }
                    et_workout.setText(file_string);
                    fis.close();
                } catch (Exception e) {
                    Log.d("fit_fos: ", e.getLocalizedMessage());
                }
            }
        });

        btn_save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(context, "Workout saved.", Toast.LENGTH_SHORT).show();
                try {
                    FileOutputStream fos = openFileOutput(FILENAME, Context.MODE_PRIVATE);
                    fos.write(et_workout.getText().toString().getBytes());
                    fos.close();
                } catch (Exception e) {
                    Log.d("fit_fos: ", e.getLocalizedMessage());
                }
            }
        });
    }
}
