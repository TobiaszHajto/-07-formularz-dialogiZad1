
package com.example.formularz_dialogi;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText etName, etEmail;
    private Button btnSubmit;
    private Spinner spCourse;
    private RadioGroup rgMode;
    private SeekBar sbLevel;
    private TextView tvLevelValue, tvSummary;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etName = findViewById(R.id.etName);
        etEmail = findViewById(R.id.etEmail);
        btnSubmit = findViewById(R.id.btnSubmit);
        spCourse = findViewById(R.id.spCourse);
        rgMode = findViewById(R.id.rgMode);
        sbLevel = findViewById(R.id.sbLevel);
        tvLevelValue = findViewById(R.id.tvLevelValue);
        tvSummary = findViewById(R.id.tvSummary);

        setUpCourseSpinner();

        tvLevelValue.setText(String.valueOf(sbLevel.getProgress()));

        sbLevel.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                tvLevelValue.setText(String.valueOf(progress));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });

        btnSubmit.setOnClickListener(v -> {
            String name = etName.getText().toString();
            String email = etEmail.getText().toString();

            String mode = rgMode.getCheckedRadioButtonId() == R.id.rbOnsite
                    ? "Stacjonarny" : "Zdalny";

            String summary = "Imię: " + name
                    + "\nEmail: " + email
                    + "\nKurs: " + spCourse.getSelectedItem().toString()
                    + "\nTryb: " + mode
                    + "\nPoziom: " + sbLevel.getProgress();

            tvSummary.setText(summary);
        });
    }

    private void setUpCourseSpinner() {
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(
                this, R.array.courses, android.R.layout.simple_spinner_item);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spCourse.setAdapter(adapter);
    }
}
