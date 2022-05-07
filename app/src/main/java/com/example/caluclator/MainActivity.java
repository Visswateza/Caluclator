package com.example.caluclator;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DownloadManager;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import net.objecthunter.exp4j.Expression;
import net.objecthunter.exp4j.ExpressionBuilder;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    TextView display,queryD,backspace;
    TextView brace, power, percent, divide, multiply, subtract, add, evaluate, clear, dot;
    TextView zero, one, two, three, four, five, six, seven, eight, nine;
    StringBuffer Query = new StringBuffer();
    boolean leftBracket = true;
    ArrayList<String> exp = new ArrayList<String>();
    EvaluateString ES = new EvaluateString();
    int b=0,l=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        queryD = findViewById(R.id.Query);
        display = findViewById(R.id.Answer);
        backspace = findViewById(R.id.bkspace);
        brace = findViewById(R.id.lbrace);
        power = findViewById(R.id.rbrace);
        percent = findViewById(R.id.percent);
        divide = findViewById(R.id.division);
        multiply = findViewById(R.id.multiply);
        subtract = findViewById(R.id.subtract);
        add = findViewById(R.id.addition);
        evaluate = findViewById(R.id.evaluate);
        clear = findViewById(R.id.clear);
        dot = findViewById(R.id.dot);

        zero = findViewById(R.id.zero);
        one = findViewById(R.id.one);
        two = findViewById(R.id.two);
        three = findViewById(R.id.three);
        four = findViewById(R.id.four);
        five = findViewById(R.id.five);
        six = findViewById(R.id.six);
        seven = findViewById(R.id.seven);
        eight = findViewById(R.id.eight);
        nine = findViewById(R.id.nine);

        zero.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Query.append('0');
                queryD.setText(Query.toString());
            }
        });
        one.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Query.append('1');
                queryD.setText(Query.toString());
            }
        });
        two.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Query.append('2');
                queryD.setText(Query.toString());
            }
        });
        three.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Query.append('3');
                queryD.setText(Query.toString());
            }
        });
        four.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Query.append('4');
                queryD.setText(Query.toString());
            }
        });
        five.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Query.append('5');
                queryD.setText(Query.toString());
            }
        });
        six.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Query.append('6');
                queryD.setText(Query.toString());
            }
        });
        seven.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Query.append('7');
                queryD.setText(Query.toString());
            }
        });
        eight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Query.append('8');
                queryD.setText(Query.toString());
            }
        });
        nine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Query.append('9');
                queryD.setText(Query.toString());
            }
        });
        dot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Query.append('.');
                queryD.setText(Query.toString());
            }
        });
        brace.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(leftBracket){
                    Query.append('(');
                    queryD.setText(Query.toString());
                    leftBracket = false;
                }
                else {
                    Query.append(')');
                    queryD.setText(Query.toString());
                    leftBracket = true;
                }
            }
        });
        power.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Query.append('^');
                queryD.setText(Query.toString());
            }
        });
        percent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Query.append('%');
                queryD.setText(Query.toString());
            }
        });
        divide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Query.append('/');
                queryD.setText(Query.toString());
            }
        });
        multiply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Query.append('*');
                queryD.setText(Query.toString());
            }
        });
        subtract.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Query.append('-');
                queryD.setText(Query.toString());
            }
        });
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Query.append('+');
                queryD.setText(Query.toString());
            }
        });
        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Query = new StringBuffer();
                queryD.setText(Query.toString());
                display.setText(Query);
                leftBracket= true;
            }
        });
        evaluate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                queryD.setText(Query.toString());
                Expression e = (Expression) new ExpressionBuilder(Query.toString()).build();
                Double result= e.evaluate();
//                EvaluateString e = new EvaluateString();
//                Double result = e.evaluate(Query.toString());
                Log.d("1", ""+result);
                display.setText(result.toString());
            }
        });
        backspace.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }
}