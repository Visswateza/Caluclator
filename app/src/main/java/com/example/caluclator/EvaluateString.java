package com.example.caluclator;

import java.util.Stack;
import java.lang.*;

public class EvaluateString {
    public static double evaluate(String expression){
        char[] tokens = expression.toCharArray();
        Stack<Double> values = new Stack<Double>();
        Stack<Character> ops = new Stack<Character>();

        for (int i = 0; i < tokens.length; i++){
            if (tokens[i] == ' ')
                continue;
            if ((tokens[i] >= '0' && tokens[i] <= '9') || tokens[i]=='.'){
                StringBuffer sbuf = new StringBuffer();
                while (i < tokens.length && tokens[i] >= '0' && tokens[i] <= '9')
                    sbuf.append(tokens[i++]);
                values.push(Double.parseDouble(sbuf.toString()));
                i--;
            }
            else {
                if (tokens[i] == '('){
                    try{
                        if((tokens[i-1]>='0' && tokens[i-1]<='9') || tokens[i-1]=='.'){
                            ops.push('*');
                        }
                    }
                    catch(Exception e){
    
                    }
                    ops.push(tokens[i]);
                }
                else if (tokens[i] == ')')
                {
                    while (ops.peek() != '(')
                        values.push(applyOp(ops.pop(),values.pop(),values.pop()));
                    ops.pop();
                    try{
                        if((tokens[i-1]>='0' && tokens[i-1]<='9') || tokens[i-1]=='.'){
                            ops.push('*');
                        }
                    }
                    catch(Exception e) {
                        
                    }
                }
                else if (tokens[i] == '+' || tokens[i] == '-' || tokens[i] == '*' || tokens[i] == '/' || tokens[i] == '%' || tokens[i] == '^')
                {
                    while (!ops.empty() && hasPrecedence(tokens[i], ops.peek()))
                        values.push(applyOp(ops.pop(), values.pop(), values.pop()));
                    ops.push(tokens[i]);
                }
            }
        }
        while (!ops.empty())
            values.push(applyOp(ops.pop(), values.pop(), values.pop()));
        return values.pop();
    }

    public static boolean hasPrecedence(char op1, char op2)
    {
        int vop1,vop2;
        if(op1=='+'||op1=='-') vop1=1;
        else if(op1=='*'||op1=='/') vop1=2;
        else if(op1=='%'||op1=='^') vop1=3;
        else vop1=0;

        if(op2=='+'||op2=='-') vop2=1;
        else if(op2=='*'||op2=='/') vop2=2;
        else if(op2=='%'||op2=='^') vop2=3;
        else vop2=0;

        if(vop1<vop2) return true;
        else return false;
    }

    public static double applyOp(char op, double b, double a){
        switch (op){
            case '+':
                return a + b;
            case '-':
                return a - b;
            case '*':
                return a * b;
            case '/':
                if (b == 0)
                    throw new UnsupportedOperationException( "Cannot divide by zero");
                return a / b;
            case '%':
                return (a/100)*b;
            case '^':
                return Math.pow(a,b);
        }
        return 0;
    }
}