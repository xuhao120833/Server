package com.htc.server;

import android.os.Bundle;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.Px;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private PxScale pxScale;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        pxScale = new PxScale();
        pxScale.checkbddata("zojdoifjaoidj");
        String hello = pxScale.sayHello();
        Toast.makeText(this, hello, Toast.LENGTH_SHORT).show();
    }
}