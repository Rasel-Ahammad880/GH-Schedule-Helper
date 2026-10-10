package com.ghschedule.helper;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        LinearLayout layout = new LinearLayout(this);
        layout.setOrientation(LinearLayout.VERTICAL);
        layout.setPadding(40, 60, 40, 40);

        TextView title = new TextView(this);
        title.setText("GH Schedule Helper");
        title.setTextSize(26);
        layout.addView(title);

        EditText date = new EditText(this);
        date.setHint("Schedule date (YYYY-MM-DD)");
        layout.addView(date);

        EditText start = new EditText(this);
        start.setHint("Start time (HH:MM)");
        layout.addView(start);

        EditText end = new EditText(this);
        end.setHint("End time (HH:MM)");
        layout.addView(end);

        Button save = new Button(this);
        save.setText("SAVE SCHEDULE");
        layout.addView(save);

        TextView status = new TextView(this);
        status.setText("Status: Ready");
        layout.addView(status);

        save.setOnClickListener(v -> {
            String info = date.getText().toString()
                    + " | " + start.getText().toString()
                    + " - " + end.getText().toString();

            getPreferences(MODE_PRIVATE)
                .edit()
                .putString("schedule", info)
                .apply();

            status.setText("Saved: " + info);
            Toast.makeText(this, "Schedule saved locally",
                Toast.LENGTH_SHORT).show();
        });

        setContentView(layout);
    }
}
