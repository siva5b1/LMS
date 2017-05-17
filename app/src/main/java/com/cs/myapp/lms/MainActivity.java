package com.cs.myapp.lms;

import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.widget.Button;
import android.widget.EditText;
import android.view.View;
import android.view.View.OnClickListener;
public class MainActivity extends Activity {
Button b;
    String empid;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addListenerOnButton();
    }
    public void addListenerOnButton()
    {
        final Context context = this;

        b = (Button) findViewById(R.id.i);
        b.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText editText = (EditText)findViewById(R.id.emp_id);
                String text = editText.getText().toString();
                Intent intent = new Intent(context, Issue.class);
                intent.putExtra("empid",text);
                startActivity(intent);
            }
    });
        b = (Button) findViewById(R.id.r);
        b.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText editText = (EditText)findViewById(R.id.emp_id);
                String text = editText.getText().toString();
                Intent intent = new Intent(context, Return.class);
                intent.putExtra("empid",text);
                startActivity(intent);
            }
        });
    }
}
