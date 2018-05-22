package inc0n3ck.hw2_informationsaving;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText edtName = findViewById(R.id.edt_nickname);
        final EditText edtPassword = findViewById(R.id.edt_password);
        Button btnLogin = findViewById(R.id.btn_sign_in);
        Button btnRegister = findViewById(R.id.btn_sign_up);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String user = edtName.getText().toString();
                String password = edtPassword.getText().toString();
                SharedPreferences preferences = getSharedPreferences("MYPREFS", MODE_PRIVATE);

                String userDetails = preferences.getString(user + password + "information", "-1");
                SharedPreferences.Editor editor = preferences.edit();
                if (userDetails.isEmpty() || userDetails.equals("-1")) {
                    Toast.makeText(MainActivity.this, "You must register first.", Toast.LENGTH_SHORT).show();
                } else {
                    editor.putString("display", userDetails);
                    editor.apply();

                    System.out.println(userDetails);
                    Intent displayScreen = new Intent(MainActivity.this, SuccessfulLoginActivity.class);
                    startActivity(displayScreen);
                }
            }
        });


        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent registerScreen = new Intent(MainActivity.this, NewUserActivity.class);
                startActivity(registerScreen);
            }
        });
    }
}
