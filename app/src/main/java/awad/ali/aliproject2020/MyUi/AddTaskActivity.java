package awad.ali.aliproject2020.MyUi;

import androidx.appcompat.app.AppCompatActivity;
import awad.ali.aliproject2020.R;

import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageButton;

public class AddTaskActivity extends AppCompatActivity {
    private ImageButton btnImage;
    private Button btnUpload;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_task);
        btnUpload=findViewById(R.id.btnUpload);
        btnImage=findViewById(R.id.btnImage);


    }
}