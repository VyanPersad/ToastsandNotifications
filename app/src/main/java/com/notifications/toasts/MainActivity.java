package com.notifications.toasts;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.toast).setOnClickListener(this);
        findViewById(R.id.toast1).setOnClickListener(this);
        findViewById(R.id.snckbar).setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch(view.getId()){
            case R.id.toast:
                showToast();
                break;
            case R.id.toast1:
                showCustomToast();
                break;
            case R.id.snckbar:
                showSnckbar();
                break;
        }
    }

    public void showToast(){
        int toastDuration;
        RadioButton shrt = findViewById(R.id.shrt);
        if (shrt.isChecked())
            toastDuration = Toast.LENGTH_SHORT;
        else
            toastDuration = Toast.LENGTH_LONG;
        Toast toast = Toast.makeText(this, "This is a toast", toastDuration);
        toast.show();
    }

    public void showCustomToast(){
        int toastDuration;
        RadioButton shrt = findViewById(R.id.shrt);
        if (shrt.isChecked())
            toastDuration = Toast.LENGTH_SHORT;
        else
            toastDuration = Toast.LENGTH_LONG;
        // Get the custom layout and inflate it
        //It seems that this layout works best (if at all) with a LinearLayout, Constraint doesn't work
        LayoutInflater inflater = getLayoutInflater();
        View layout = inflater.inflate(R.layout.toast_layout, (ViewGroup)findViewById(R.id.customLayout));
        // Build a toast message that uses the custom layout
        TextView tV1 = layout.findViewById(R.id.tV1);
        tV1.setText("This is a custom toast");
        Toast toast = new Toast(getApplicationContext());
        toast.setDuration(toastDuration);
        toast.setGravity(Gravity.BOTTOM | Gravity.START, 100, 100);
        toast.setView(layout);
        toast.show();
    }

    public void showSnckbar(){
        Snackbar sb = Snackbar.make(findViewById(R.id.myLayout), "This is a snackbar", Snackbar.LENGTH_LONG);
        sb.setAction("Some Action", view -> {
            //Your code here
            showToast();
        });
        sb.setActionTextColor(Color.BLUE);
        sb.show();
    }

}