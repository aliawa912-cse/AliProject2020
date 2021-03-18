package awad.ali.aliproject2020.MyUi;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import awad.ali.aliproject2020.R;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class SignInActivity extends AppCompatActivity {
    private TextView edEmail , edPassword;
    private Button btnLogIn, btnSignUp;
    private  FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);
        auth= FirebaseAuth.getInstance();

        edEmail = findViewById(R.id.edEmail);
        edPassword = findViewById(R.id.etPassword);
        btnLogIn = findViewById(R.id.btnLogIn);
        btnSignUp = findViewById(R.id.btnSignUp);
        btnLogIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //5س
               /// startActivity(new Intent(SignInActivity.this,MainActivity.class));
                checkForm();
            }
        });

        btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //5س
                startActivity(new Intent(SignInActivity.this,SignUpActivity.class));
            }
        });

    }
    private void checkForm() {
        String stEmail=edEmail.getText().toString();
        String stPassword=edPassword.getText().toString();
        boolean isOk=true;
        if (stEmail.length()<5||stEmail.indexOf('@')==0||stEmail.indexOf('@')>stEmail.length()-2||stEmail.indexOf('.')==0||stEmail.indexOf('.')>stEmail.length()-1||stEmail.lastIndexOf(".")<stEmail.indexOf('@'))
        {
            isOk=false;
            edEmail.setError("Wrong Email syntax");
        }
        MyValidations myValidations=new MyValidations();
//        if (myValidations.validatePasword(stPassword)==false)
//        {
//            isOk = false;
//            edPassword.setError("Invalid Password");
//        }
        if(isOk)

        {
             SignIn(stEmail, stPassword);
        }
    }
    private void SignIn(String stEmail, String stPassw) {
       // FirebaseDatabase auth=FirebaseDatabase.getInstance();
        auth.signInWithEmailAndPassword(stEmail,stPassw).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()) {
                    Intent i = new Intent(getApplicationContext(), MainActivity.class);
                    startActivity(i);
                } else {
                    Toast.makeText(SignInActivity.this, "Failed", Toast.LENGTH_SHORT).show();
                    edEmail.setError(task.getException().getMessage());


                }
            }
        });
    }
}