package com.dev.stacked.fully.hackout;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;


public class Main extends Activity {
    Context context;
    ImageButton btnFitness;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        context = getApplicationContext();
        btnFitness = (ImageButton) findViewById(R.id.main_btn_fitness);
        btnFitness.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(context,Fitness.class));
            }
        });
    }

    /*
        String FILENAME = "hello_file";
        String string = "hello world!";
        try{
            FileOutputStream fos = openFileOutput(FILENAME,Context.MODE_PRIVATE);
            fos.write(string.getBytes());
            fos.close();
        }
        catch (Exception e){
            Log.d("main_fos:", e.getLocalizedMessage());
        }
        String s = "";
        try{
            FileInputStream fis = openFileInput(FILENAME);
            int currByte = fis.read();
            while (currByte != -1){
                s = s + (char) currByte;
                currByte = fis.read();
            }
            Toast.makeText(context,s,Toast.LENGTH_LONG).show();
            fis.close();
        }
        catch (Exception e){
            Log.d("main_fis:", e.getLocalizedMessage());
        }
     */
}
