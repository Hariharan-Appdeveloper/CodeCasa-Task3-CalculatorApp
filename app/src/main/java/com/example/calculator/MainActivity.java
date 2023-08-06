package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Stack;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        final String[] qt = {null};

        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide();

        setContentView(R.layout.activity_main);

        Button one,two,three,four,five,six,seven,eight,nine,zero,dot,Allclear,clear,add,sub,mul,div,mod,equal;
        EditText question=findViewById(R.id.que);
        EditText ans=findViewById(R.id.textbox);

        question.setShowSoftInputOnFocus(false);
        ans.setShowSoftInputOnFocus(false);

        one=findViewById(R.id.one);
        two=findViewById(R.id.two);
        three=findViewById(R.id.three);
        four=findViewById(R.id.four);
        five=findViewById(R.id.five);
        six=findViewById(R.id.six);
        seven=findViewById(R.id.seven);
        eight=findViewById(R.id.eight);
        nine=findViewById(R.id.nine);
        zero=findViewById(R.id.zero);
        dot=findViewById(R.id.dec);
        Allclear=findViewById(R.id.allcl);
        clear=findViewById(R.id.cl);
        add=findViewById(R.id.add);
        sub=findViewById(R.id.sub);
        mul=findViewById(R.id.mul);
        div=findViewById(R.id.div);
        mod=findViewById(R.id.mod);
        equal=findViewById(R.id.eq);

        one.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ans.setTextSize(25);
                question.setText(" ");
                ans.setText(ans.getText().toString()+"1");
            }
        });

        two.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ans.setTextSize(25);
                question.setText(" ");
                ans.setText(ans.getText().toString()+"2");
            }
        });

        three.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ans.setTextSize(25);
                question.setText(" ");
                ans.setText(ans.getText().toString()+"3");
            }
        });

        four.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ans.setTextSize(25);
                question.setText(" ");
                ans.setText(ans.getText().toString()+"4");
            }
        });

        five.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ans.setTextSize(25);
                question.setText(" ");
                ans.setText(ans.getText().toString()+"5");
            }
        });

        six.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ans.setTextSize(25);
                question.setText(" ");
                ans.setText(ans.getText().toString()+"6");
            }
        });

        seven.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ans.setTextSize(25);
                question.setText(" ");
                ans.setText(ans.getText().toString()+"7");
            }
        });

        eight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ans.setTextSize(25);
                question.setText(" ");
                ans.setText(ans.getText().toString()+"8");
            }
        });

        nine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ans.setTextSize(25);
                question.setText(" ");
                ans.setText(ans.getText().toString()+"9");
            }
        });

        zero.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ans.setTextSize(25);
                question.setText(" ");
                ans.setText(ans.getText().toString()+"0");
            }
        });

        dot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ans.setTextSize(25);
                question.setText(" ");
                ans.setText(ans.getText().toString()+".");
            }
        });

        Allclear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){
                question.setText(" ");
                ans.setText(" ");
            }
        });

        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try{
                question.setText(" ");
                String s=ans.getText().toString();
                s=s.substring(0,s.length()-1);
                ans.setText(s);}
                catch (Exception e){

                }
            }
        });

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ans.setTextSize(25);
                question.setText(" ");
                ans.setText(ans.getText().toString()+"+");
            }
        });

        sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ans.setTextSize(25);
                question.setText(" ");
                ans.setText(ans.getText().toString()+"-");
            }
        });

        mul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ans.setTextSize(25);
                question.setText(" ");
                ans.setText(ans.getText().toString()+"x");
            }
        });

        div.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ans.setTextSize(25);
                question.setText(" ");
                ans.setText(ans.getText().toString()+"÷");
            }
        });

        mod.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ans.setTextSize(25);
                question.setText(" ");
                ans.setText(ans.getText().toString()+"%");
            }
        });

        equal.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("ResourceAsColor")
            @Override
            public void onClick(View view) {

                String expression =ans.getText().toString();
                qt[0] = expression;
                char[] tokens= expression.toCharArray();

                Stack<Float> values=new Stack<Float>();

                Stack<Character> ops=new Stack<Character>();

                try{

                    for(int i=0;i<tokens.length;i++){
                        if(tokens[i]>='0' && tokens[i]<='9'){
                            StringBuffer sbuf=new StringBuffer();
                            while(i< tokens.length && ((tokens[i]>='0'&& tokens[i]<='9' )|| tokens[i]=='.'))
                                sbuf.append(tokens[i++]);
                            values.push(Float.parseFloat(sbuf.toString()));
                            i--;
                        }
                        else if(tokens[i]=='('){
                            ops.push(tokens[i]);
                        }
                        else if(tokens[i]==')'){
                            while(ops.peek()!='('){
                                values.push(applyOp(ops.pop(),values.pop(),values.pop()));
                            }
                            ops.pop();
                        }
                        else if (tokens[i] == '+' || tokens[i] == '-' || tokens[i] == 'x' || tokens[i] == '÷'|| tokens[i]=='%')
                        {
                            while (!ops.empty() && hasPrecedence(tokens[i], ops.peek())) values.push(applyOp(ops.pop(), values.pop(), values.pop()));
                            ops.push(tokens[i]);
                        }
                    }


                    while (!ops.empty())
                        values.push(applyOp(ops.pop(), values.pop(), values.pop()));

                    ans.setText(values.pop().toString());
                    ans.setTextSize(50);
                    question.setTextSize(30);
                    question.setText(qt[0]);

                } catch (Exception e) {
                    Toast t=Toast.makeText(MainActivity.this,"Error occured",Toast.LENGTH_LONG);
                    t.show();
                }

            }
            public boolean hasPrecedence(char op1, char op2)
            {
                if (op2 == '(' || op2 == ')')
                    return false;
                if ((op1 == 'x' || op1 == '/') && (op2 == '+' || op2 == '-'))
                    return false;
                else
                    return true;
            }

            public float applyOp(char op, float b, float a)
            {
                switch (op)
                {
                    case '+':
                        return a + b;
                    case '-':
                        return a - b;
                    case 'x':
                        return a * b;
                    case '÷':
                        if (b == 0)
                            throw new
                                    UnsupportedOperationException("Cannot divide by zero");
                        return a / b;
                    case '%':
                        return a % b;
                }
                return 0;
            }
        });

    }
}