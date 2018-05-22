package inc0n3ck.hw1_activitiesandintents;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private Button btnLogin;
    private EditText edtName;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtName = findViewById(R.id.edt_name);
        btnLogin = findViewById(R.id.btn_login);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (edtName.getText().toString().isEmpty() || edtName.getText().toString().matches(".*\\d+.*")) {
                    edtName.setError("Input your nickname - text only.");
                } else {
                    goToDetailsActivity();
                }
            }
        });
    }

    public void goToDetailsActivity() {
        String name = edtName.getText().toString();
        Intent intent = new Intent(this, DetailsActivity.class);
        intent.putExtra("name", name);
        startActivity(intent);
    }

}
