package com.cs.myapp.lms;
import android.app.Activity;
import android.os.Bundle;
import java.util.Calendar;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.FragmentActivity;
import android.text.format.DateFormat;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.DatePicker;
import java.util.Date;
import android.widget.Toast;
import android.widget.AdapterView.OnItemSelectedListener;

public class Issue extends FragmentActivity{
TextView tv;
   static TextView et;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_issue);
        tv = (TextView)findViewById(R.id.emp_id);
        tv.setText(getIntent().getStringExtra("empid"));
        Spinner spinner = (Spinner) findViewById(R.id.bname);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.bnames, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        et=(TextView) findViewById(R.id.et);
        et.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDatePickerDialog(v);
            }
        });
    }
    public void showDatePickerDialog(View v) {
        DialogFragment newFragment = new DatePickerFragment();
        newFragment.show(getSupportFragmentManager(), "datePicker");
    }

    public static class DatePickerFragment extends DialogFragment implements
            DatePickerDialog.OnDateSetListener {

        @Override
        public Dialog onCreateDialog(Bundle savedInstanceState) {
            // Use the current date as the default date in the picker
            final Calendar c = Calendar.getInstance();
            int year = c.get(Calendar.YEAR);
            int month = c.get(Calendar.MONTH);
            int day = c.get(Calendar.DAY_OF_MONTH);

            // Create a new instance of DatePickerDialog and return it
            return new DatePickerDialog(getActivity(), this, year, month, day);
        }

        public void onDateSet(DatePicker view, int year, int month, int day) {
            // Do something with the date chosen by the user
            et.setText(day + "/" + (month + 1) + "/" + year);
        }
    }

}