package com.ucb.calculator;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText editText;
    float valueOne, valueTwo;
    boolean add, sub, mul, div;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = findViewById(R.id.editText);

        // Number Buttons
        Button button0 = findViewById(R.id.button0);
        Button button1 = findViewById(R.id.button1);
        Button button2 = findViewById(R.id.button2);
        Button button3 = findViewById(R.id.button3);
        Button button4 = findViewById(R.id.button4);
        Button button5 = findViewById(R.id.button5);
        Button button6 = findViewById(R.id.button6);
        Button button7 = findViewById(R.id.button7);
        Button button8 = findViewById(R.id.button8);
        Button button9 = findViewById(R.id.button9);

        // Operator Buttons
        Button buttonAdd = findViewById(R.id.buttonAdd);
        Button buttonSub = findViewById(R.id.buttonSub);
        Button buttonMul = findViewById(R.id.buttonMul);
        Button buttonDiv = findViewById(R.id.buttonDiv);
        Button buttonEqual = findViewById(R.id.buttonEqual);
        Button buttonClear = findViewById(R.id.buttonClear);

        // Set onClickListeners for number buttons
        View.OnClickListener numberListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Button b = (Button) v;
                editText.append(b.getText());
            }
        };

        button0.setOnClickListener(numberListener);
        button1.setOnClickListener(numberListener);
        button2.setOnClickListener(numberListener);
        button3.setOnClickListener(numberListener);
        button4.setOnClickListener(numberListener);
        button5.setOnClickListener(numberListener);
        button6.setOnClickListener(numberListener);
        button7.setOnClickListener(numberListener);
        button8.setOnClickListener(numberListener);
        button9.setOnClickListener(numberListener);

        // Operation buttons
        buttonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                valueOne = Float.parseFloat(editText.getText().toString());
                add = true;
                editText.setText(null);
            }
        });

        buttonSub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                valueOne = Float.parseFloat(editText.getText().toString());
                sub = true;
                editText.setText(null);
            }
        });

        buttonMul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                valueOne = Float.parseFloat(editText.getText().toString());
                mul = true;
                editText.setText(null);
            }
        });

        buttonDiv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                valueOne = Float.parseFloat(editText.getText().toString());
                div = true;
                editText.setText(null);
            }
        });

        buttonEqual.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                valueTwo = Float.parseFloat(editText.getText().toString());

                if (add) {
                    editText.setText(String.valueOf(valueOne + valueTwo));
                    add = false;
                }

                if (sub) {
                    editText.setText(String.valueOf(valueOne - valueTwo));
                    sub = false;
                }

                if (mul) {
                    editText.setText(String.valueOf(valueOne * valueTwo));
                    mul = false;
                }

                if (div) {
                    if (valueTwo != 0) {
                        editText.setText(String.valueOf(valueOne / valueTwo));
                    } else {
                        editText.setText("Error");
                    }
                    div = false;
                }
            }
        });

        buttonClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editText.setText("");
                valueOne = 0;
                valueTwo = 0;
            }
        });
    }
}
