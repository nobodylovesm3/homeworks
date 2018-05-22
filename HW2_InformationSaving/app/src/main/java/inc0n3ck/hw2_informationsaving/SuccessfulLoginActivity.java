package inc0n3ck.hw2_informationsaving;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class SuccessfulLoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_successful_login);

        SharedPreferences preferences = getSharedPreferences("MYPREFS", MODE_PRIVATE);
        String display = preferences.getString("display", "");

        TextView displayInfo = findViewById(R.id.txt_success);
        String output = "Hello, " + display;
        displayInfo.setText(output);

    }
}
