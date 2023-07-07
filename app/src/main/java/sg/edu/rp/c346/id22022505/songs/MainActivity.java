package sg.edu.rp.c346.id22022505.songs;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    TextView tvTitle, tvSinger, tvYear, tvStars;
    EditText etTitle, etSinger, etYear;
    RadioButton btn1, btn2, btn3, btn4, btn5;
    Button btnInsert, btnList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvTitle = findViewById(R.id.songTitle);
        etTitle = findViewById(R.id.editSong);
        tvSinger = findViewById(R.id.songSinger);
        etSinger = findViewById(R.id.editSinger);
        tvYear = findViewById(R.id.songYear);
        etYear = findViewById(R.id.editYear);
        tvStars = findViewById(R.id.stars);
        btn1 = findViewById(R.id.btn1);
        btn2 = findViewById(R.id.btn2);
        btn3 = findViewById(R.id.btn3);
        btn4 = findViewById(R.id.btn4);
        btn5 = findViewById(R.id.btn5);
        btnInsert = findViewById(R.id.btnInsert);
        btnList = findViewById(R.id.btnList);

        btnInsert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DBHelper db = new DBHelper(MainActivity.this);
                db.insertSong(etTitle.getText().toString(), etSinger.getText().toString(), Integer.parseInt(etYear.getText().toString()));
                db.close();
            }
        });
        btnList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Create the DBHelper object, passing in the
                // activity's Context
                DBHelper db = new DBHelper(MainActivity.this);

                // Insert a task
                ArrayList<Songs> data = db.getSongsContent();
                db.close();

                String txt = "";
                for (int i = 0; i < data.size(); i++) {
                    Log.d("Songs ", i +". "+Songs.get(i));
                    txt += i + ". " + data.get(i) + "\n";
                }
                tvTitle.setText(txt);


            }
        });



    }
}