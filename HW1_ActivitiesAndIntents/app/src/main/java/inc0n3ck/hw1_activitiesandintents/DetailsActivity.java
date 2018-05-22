package inc0n3ck.hw1_activitiesandintents;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class DetailsActivity extends AppCompatActivity {

    EditText edtYears;
    EditText edtAddress;
    EditText edtCity;
    EditText edtBirthDate;
    Button btnForward;
    String name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        Intent intent = getIntent();
        name = intent.getStringExtra("name");
        edtYears = findViewById(R.id.edt_years);
        edtAddress = findViewById(R.id.edt_address);
        edtCity = findViewById(R.id.edt_city);
        edtBirthDate = findViewById(R.id.edt_dateOfBirth);
        btnForward = findViewById(R.id.btn_continue);

        btnForward.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!edtAddress.getText().toString().isEmpty() && !edtYears.getText().toString().isEmpty() && !edtCity.getText().toString().isEmpty() && !edtBirthDate.getText().toString().isEmpty())
                    goToSummaryActivity();
                else {
                    edtBirthDate.setError("Input your birth date!");
                    edtYears.setError("Input your years!");
                    edtAddress.setError("Input your address!");
                    edtCity.setError("Input your city!");
                }
            }
        });
    }

    public void goToSummaryActivity() {
        Intent intent = new Intent(this, SummaryActivity.class);

        intent.putExtra("years", edtYears.getText().toString());
        intent.putExtra("address", edtAddress.getText().toString());
        intent.putExtra("city", edtCity.getText().toString());
        intent.putExtra("birthDate", edtBirthDate.getText().toString());
        intent.putExtra("name", name);

        startActivity(intent);
    }

}
