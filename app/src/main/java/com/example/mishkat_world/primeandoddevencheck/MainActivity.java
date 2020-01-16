package com.example.mishkat_world.primeandoddevencheck;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
   private EditText et_number;
    private Button b_go,btn_check;
   private TextView tv_show;

    private int inputnumber;
    private boolean isPrimeNumber = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et_number = (EditText) findViewById(R.id.et_number);
        b_go = (Button) findViewById(R.id.b_go);
        tv_show = (TextView) findViewById(R.id.tv_show);
        btn_check=(Button)findViewById(R.id.btn_check);
        b_go.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int number = Integer.parseInt(et_number.getText().toString());
                number = number % 2;
                if (number == 0){
                    tv_show.setText("The given number is EVEN");
                }else{
                    tv_show.setText("The given number is ODD");
                }

            }
        });

        btn_check.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!(et_number.getText().toString().trim() != null && et_number.getText().toString().trim().length() > 0)) {
                    et_number.setError("Please enter the number");

                } else {
                    inputnumber = Integer.parseInt(et_number.getText().toString());
                    for (int i = 2; i <= inputnumber / 2; i++) {
                        if (inputnumber % i == 0) {
                            isPrimeNumber = false;
                            break;
                        }
                    }
                    if (isPrimeNumber) {
                        tv_show.setText("The given number " + inputnumber + " is a prime number");
                    } else {
                        tv_show.setText("The given number " + inputnumber + " is not a prime number");
                    }
                    isPrimeNumber = true;
                }
            }
        });




    }
}
