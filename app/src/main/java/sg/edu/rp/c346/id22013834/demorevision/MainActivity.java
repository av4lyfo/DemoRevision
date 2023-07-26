package sg.edu.rp.c346.id22013834.demorevision;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    EditText etName;
    CheckBox cbMarried;
    Button btnSave,btnShow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etName = (EditText) findViewById(R.id.etName);
        cbMarried = (CheckBox) findViewById(R.id.cbMarried);
        btnSave = (Button) findViewById(R.id.btnSave);
        btnShow = (Button) findViewById(R.id.btnShow);


        myPref = getPreferences(MODE_PRIVATE);

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                SharedPreferences.Editor prefEdit = myPref.edit();


                String name = etName.getText().toString ();

                boolean status = cbMarried.isChecked();

                prefEdit.putString("name", name);
                prefEdit.putBoolean("status", status);


                prefEdit.commit();
            }
        });

        btnShow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                String name =  myPref.getString("name","jack");

                boolean status = myPref.getBoolean("status", true);


                String statusInString = "Married";
                if (status == false){
                    statusInString = "Unmarried";
                }

                Toast.makeText(MainActivity.this, name + "," + statusInString, Toast)

            }

        });

        }


    }
