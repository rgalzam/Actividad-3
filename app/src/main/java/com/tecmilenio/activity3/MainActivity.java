package com.tecmilenio.activity3;

import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        //onClick
        Button Clickme_button = findViewById(R.id.Clickme_button);

        //onLongClick
        Button LClickme_button = findViewById(R.id.LClickme_button);

        //onFocusChange()
        EditText edit_text_focus = findViewById(R.id.edit_text_focus);

        //onKey()
        EditText press_text = findViewById(R.id.press_text);

        //onTouch
        Button button_touch = findViewById(R.id.button_touch);

        ImageView imageView = findViewById(R.id.imageView);
        Button zoomInButton = findViewById(R.id.btnZoomIn);
        Button zoomOutButton = findViewById(R.id.btnZoomOut);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        //onClick
        Clickme_button.setOnClickListener(v -> {

            Toast.makeText(MainActivity.this, "Button click", Toast.LENGTH_SHORT).show();
            System.out.println("Clic"); // true indica que el evento ha sido manejado

        });

        //onLongClick
        LClickme_button.setOnLongClickListener(v -> {

            Toast.makeText(MainActivity.this, "Button Long Clicked", Toast.LENGTH_SHORT).show();
            return true;
        });

        //onFocusChange
        edit_text_focus.setOnFocusChangeListener((v, hasFocus)->{

          if(hasFocus){
                  Toast.makeText(MainActivity.this, "EditText Focused", Toast.LENGTH_SHORT).show();
          } else {
              Toast.makeText(MainActivity.this, "EditText Lost Focused", Toast.LENGTH_SHORT).show();
          }
        });

        //onKey()
        press_text.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if(keyCode == KeyEvent.KEYCODE_0){
                    Toast.makeText(MainActivity.this, "Enter key pressed", Toast.LENGTH_SHORT).show();
                    return true;
                }
                return false;
            }
        });

        //onTouch()
        button_touch.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if(event.getAction()== MotionEvent.ACTION_DOWN){
                    Toast.makeText(MainActivity.this, "Button Touched", Toast.LENGTH_SHORT).show();
                    return true;
                }
                return false;
            }
        });

        zoomInButton.setOnClickListener(v -> {
            float x = imageView.getScaleX();
            float y = imageView.getScaleY();
            imageView.setScaleX(x + 1);
            imageView.setScaleY(y + 1);
        });

        zoomOutButton.setOnClickListener(v -> {
            float x = imageView.getScaleX();
            float y = imageView.getScaleY();
            if (x > 1 && y > 1) {
                imageView.setScaleX(x - 1);
                imageView.setScaleY(y - 1);
            }
        });
    }
}