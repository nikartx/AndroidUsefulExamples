package ru.nikartm.androidusefulexamples;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ImageView view = (ImageView) findViewById(R.id.img_scale);
        view.setImageDrawable(getResources().getDrawable(R.drawable.its_alive));
        view.setOnTouchListener(new MultiTouchImageListener());
    }
}
