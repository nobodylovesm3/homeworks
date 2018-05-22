package inc0n3ck.hw2_informationsaving;

import android.content.Intent;
import android.content.SharedPreferences;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import inc0n3ck.hw2_informationsaving.databinding.ActivityMainBinding;

public class NewUserActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_user);

        final EditText userName = findViewById(R.id.edt_new_nickname);
        final EditText password = findViewById(R.id.edt_new_password);
        final EditText confirmPassword = findViewById(R.id.edt_confirmPass);
        Button btnCreate = findViewById(R.id.btn_create);
        Button btnCancel = findViewById(R.id.btn_cancel);


        btnCreate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (arePasswordsValid(password, confirmPassword) && isUserNameValid(userName)) {
                    SharedPreferences preferences = getSharedPreferences("MYPREFS", MODE_PRIVATE);
                    String newUser = userName.getText().toString();
                    String newPassword = password.getText().toString();

                    SharedPreferences.Editor editor = preferences.edit();

                    editor.putString(newUser, newUser);
                    editor.apply();
                    editor.putString(newPassword, newPassword);
                    editor.apply();
                    editor.putString(newUser + newPassword + "information", newUser);
                    editor.apply();

                    Toast.makeText(NewUserActivity.this, "You can now proceed to log in, " + newUser + "!", Toast.LENGTH_SHORT).show();

                    goBackToMainScreen();

                } else if (!arePasswordsEntered(password, confirmPassword)) {
                    generateErrorMessagesPasswords(password, confirmPassword);
                } else if (!isUserNameValid(userName)) {
                    generateErrorMessagesUsername(userName);
                } else if (!arePasswordsEqual(password, confirmPassword)) {
                    generateErrorMessagesPasswords(password, confirmPassword);
                }
            }
        });

        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goBackToMainScreen();
            }
        });

    }

    public void goBackToMainScreen() {
        Intent intent = new Intent(NewUserActivity.this, MainActivity.class);
        startActivity(intent);
    }

    public boolean isUserNameValid(EditText userName) {
        return ((userName.getText().toString().trim().length()) != 0);
    }

    public boolean arePasswordsEntered(EditText password, EditText confirmPassword) {
        return (password.getText().toString().trim().length() != 0 && confirmPassword.getText().toString().trim().length() != 0);
    }

    public boolean arePasswordsValid(EditText password, EditText confirmPassword) {
        return (arePasswordsEqual(password, confirmPassword) && arePasswordsEntered(password, confirmPassword));
    }

    public boolean arePasswordsEqual(EditText password, EditText confirmPassword) {
        return (confirmPassword.getText().toString().equals(password.getText().toString()));
    }

    public void generateErrorMessagesPasswords(EditText password, EditText confirmPassword) {
        password.setError("Passwords don't match!");
        confirmPassword.setError("Passwords don't match!");
    }

    public void generateErrorMessagesUsername(EditText userName) {
        userName.setError("Username isn't entered!");
    }

}
