package com.example.umang.calculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;


import static android.R.attr.value;

public class MainActivity extends AppCompatActivity {

    String answer = "";
    double two= 0, result=0;
    char sign;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    public void equalTo(View view)
    {

        String delim = "\\s+";
        String [] tokens = answer.split(delim);
        result = Double.parseDouble(tokens[0]);
        for(int i=1;i<tokens.length;i+=2)
        {
            sign = tokens[i].charAt(0);
            two = Double.parseDouble(tokens[i+1]);

            switch (sign) {
                case '+':
                    result = result + two;
                    break;
                case '-':
                    result = result - two;
                    break;
                case 'x':
                    result = result * two;
                    break;
                case '/':
                    result = result / two;
                    break;
            }

        }

        if(result%1==0)
        {
            answer = String.valueOf((int) result);
        }
        else
        {
            answer = String.format("%.6f", result);
            answer = removeTrailingZeros(answer);
        }

        displayMessage(answer);
    }

    public void one(View view)
    {
        answer += "1";
        displayMessage(answer);
    }

    public void two(View view)
    {
        answer += "2";
        displayMessage(answer);
    }

    public void three(View view)
    {
        answer += "3";
        displayMessage(answer);
    }

    public void four(View view)
    {
        answer += "4";
        displayMessage(answer);
    }

    public void five(View view)
    {
        answer += "5";
        displayMessage(answer);
    }

    public void six(View view)
    {
        answer += "6";
        displayMessage(answer);
    }

    public void seven(View view)
    {
        answer += "7";
        displayMessage(answer);
    }

    public void eight(View view)
    {
        answer += "8";
        displayMessage(answer);
    }

    public void nine(View view)
    {
        answer += "9";
        displayMessage(answer);
    }

    public void zero(View view)
    {
        answer += "0";
        displayMessage(answer);
    }

    public void ac(View view)
    {
        answer = "";
        displayMessage(answer);
    }

    public void divide(View view)
    {
        answer += " / ";
        displayMessage(answer);
    }

    public void plus(View view)
    {
        answer += " + ";
        displayMessage(answer);
    }

    public void multiply(View view)
    {
        answer += " x ";
        displayMessage(answer);
    }

    public void minus(View view)
    {
        answer += " - ";
        displayMessage(answer);
    }

    public void dot(View view)
    {
        answer += ".";
        displayMessage(answer);
    }

    public void plusminus(View view)
    {
        answer = "+-";
        displayMessage(answer);
    }

    public void back(View view)
    {
        String str = answer;
        if (str != null && str.length() > 0)
        {
            str = str.substring(0, str.length() - 1);
        }
        answer = str;
        displayMessage(answer);
    }

    public void displayMessage(String answer)
    {
        TextView answerView = (TextView) findViewById(R.id.answer_view);
        answerView.setText(answer);
    }

    public String removeTrailingZeros(String str ){
        if (str == null){
            return null;}
        char[] chars = str.toCharArray();int length,index ;length = str.length();
        index = length -1;
        for (; index >=0;index--)
        {
            if (chars[index] != '0'){
                break;}
        }
        return (index == length-1) ? str :str.substring(0,index+1);
    }

    public double computeInfixExpr(String input) {
        String[] expr = input.split(" ");
        int i = 0;
        double operLeft = Integer.valueOf(expr[i++]);
        while (i < expr.length) {
            String operator = expr[i++];
            double operRight = Double.valueOf(expr[i++]);
            switch (operator) {
                case "*":
                    operLeft = operLeft * operRight;
                    break;
                case "/":
                    operLeft = operLeft / operRight;
                    break;
                case "+":
                    while (i < expr.length) {
                        String operator2 = expr[i++];
                        if (operator2.equals("+") || operator2.equals("-")) {
                            i--;
                            break;
                        }
                        if (operator2.equals("*")) {
                            operRight = operRight * Double.valueOf(expr[i++]);
                        }
                        if (operator2.equals("/")) {
                            operRight = operRight / Double.valueOf(expr[i++]);
                        }
                    }
                    operLeft = operLeft + operRight;
                    break;
                case "-":
                    while (i < expr.length) {
                        String operator2 = expr[i++];
                        if (operator2.equals("+") || operator2.equals("-")) {
                            i--;
                            break;
                        }
                        if (operator2.equals("*")) {
                            operRight = operRight * Double.valueOf(expr[i++]);
                        }
                        if (operator2.equals("/")) {
                            operRight = operRight / Double.valueOf(expr[i++]);
                        }
                    }
                    operLeft = operLeft - operRight;
                    break;
            }
        }
        return operLeft;
    }
}
