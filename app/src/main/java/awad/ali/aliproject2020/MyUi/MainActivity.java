package awad.ali.aliproject2020.MyUi;

import androidx.appcompat.app.AppCompatActivity;
import awad.ali.aliproject2020.Data.MyTaskAdapter;
import awad.ali.aliproject2020.R;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {
    private ImageButton ibtnAdd;
    ImageButton lstTasks;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ibtnAdd=findViewById(id.ibtnAdd);

        ibtnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this,AddTaskActivity.class);
                startActivity(i);


        }
    });
        lstTasks=findViewById(id.lstTasks);
        MyTaskAdapter =new MyTaskAdapter (getBaseContext(), android.R.layout.activity_list_item);
        lstTasks.set(taskAdapter);
        downloadFromFireBase();

}