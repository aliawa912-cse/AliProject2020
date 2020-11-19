package awad.ali.aliproject2020;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class SignInActivity extends AppCompatActivity {
    private TextView edEmail, edPassWord;
    private Button btnLogIn,BtnSignUp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);
        edEmail=findViewById(R.id.edEmail);
        edPassWord =findViewById(R.id.edPassWord);
        btnLogIn=findViewById(R.id.btnLogIn);
        BtnSignUp = findViewById(R.id.btnSignUp);
        btnLogIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //5
                validateForm();
            }

            private void validateForm() {
            }
        });
        BtnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(SignInActivity.this, SignInActivity.class);
                startActivity(i);

            }
        });
    }
    private void validateForm(){
        String stEmail = edEmail.getText().toString();
        String stPassw = edPassWord.getText().toString();
        boolean isOk = true;
        if(stEmail.length()<5||stEmail.indexOf('@')==0||stEmail.indexOf('@')>stEmail.length()-2||stEmail.indexOf('.')==0||stEmail.indexOf('.')>stEmail.length()-1||stEmail.lastIndexOf(".")<stEmail.

                indexOf('@') )

        {
            isOk = false;
            edEmail.setError("Wrong Email syntax");
        }

        MyValidations myValidations = new MyValidations();
        if(myValidations.validatePasword(stPassw)==false)

        {
            isOk = false;
            edPassWord.setError("Invalid Password");
        }
        if(isOk)

        {
            SignInActivity (stEmail, stPassw);
        }

    }
    private void SignInActivity(final String stEmail, String stPassw) {
        FirebaseAuth auth=FirebaseAuth.getInstance();
        auth.signInWithEmailAndPassword(stEmail,stPassw).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful())
                {
                    Intent i=new Intent(SignInActivity.this,MainActivity.class);
                    startActivity(i);
                }
                else
                {
                    Toast.makeText(SignInActivity.this, "Failed", Toast.LENGTH_SHORT).show();
                    stEmail.(task.getException().getMessage());
                }
            }
        });



}
}