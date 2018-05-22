package inc0n3ck.hw1_activitiesandintents;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class SummaryActivity extends AppCompatActivity {

    Button btnMaps;
    Intent intent;
    String name;
    String years;
    String city;
    String address;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_summary);

        intent = getIntent();
        name = intent.getStringExtra("name");
        years = intent.getStringExtra("years");
        city = intent.getStringExtra("city");
        address = intent.getStringExtra("address");

        TextView textView = findViewById(R.id.txt_details);
        String output = name + ", " + years + ", " + address + ", " + city;

        textView.setText(output);

        btnMaps = findViewById(R.id.btn_go_to_maps);
        btnMaps.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToMaps();
            }
        });
    }

    public void goToMaps() {
        Uri gmmIntentUri = Uri.parse("google.navigation:q=" + address + ", " + city);
        Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
        mapIntent.setPackage("com.google.android.apps.maps");
        startActivity(mapIntent);
    }
}
