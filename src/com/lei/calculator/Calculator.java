package com.lei.calculator;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.math.BigDecimal;
import java.util.Vector;
import java.awt.event.KeyEvent;

public class Calculator {

    //Create strings to record two input numbers, default as 0 for stable of program.
    String str1 = "0";
    String str2 = "0";

    //Create signal recorder, default as +
    String signal = "+";

    //Create result string to record the result
    String result = "";

    //k1 indicate input str1 or str2.
    int k1 = 1;
    //k2 record number of input signal. k2>1 indicate a calculation with multiple signals.
    int k2 = 1;
    //k3 indicate str1 can be clear to be 0 or not. if k3=1, then str1 can be clear to be 0.
    int k3 = 1;
    //k4 indicate str2 can be clear to be 0 or not. if k4=1, then str2 can be clear to be 0.
    int k4 = 1;
    //if k5=1, then float number will be record.
    int k5 = 1;

    //Store button status, to record if the signals are clicked contiguously.
    JButton store;

    @SuppressWarnings(("rawtypes"))
    Vector vt = new Vector(20, 10);

    //create main windows for the program
    JFrame frame = new JFrame("Calculator_Lei");

    /* Create and initialize a JTextField object, which is used as a display
    * parameter '20' indicates 20 columns information will be shown*/
    JTextField resultTextField = new JTextField(result, 20);

    //Create a 'clear' button
    JButton clearButton = new JButton("Clear");

    //Create number button
    JButton button0 = new JButton("0");
    JButton button1 = new JButton("1");
    JButton button2 = new JButton("2");
    JButton button3 = new JButton("3");
    JButton button4 = new JButton("4");
    JButton button5 = new JButton("5");
    JButton button6 = new JButton("6");
    JButton button7 = new JButton("7");
    JButton button8 = new JButton("8");
    JButton button9 = new JButton("9");

    //Create calculation buttons
    JButton buttonDot = new JButton(".");
    JButton buttonPlus = new JButton("+");
    JButton buttonMinus = new JButton("-");
    JButton buttonMulti = new JButton("*");
    JButton buttonDive = new JButton("/");
    JButton buttonCal = new JButton("=");        //orignial is button_dy, or res

    //Constructor of Calculator
    public Calculator(){

        //Set keyboard with button; ie. can press the corresponding key in keyboard instead of click it.
        button0.setMnemonic(KeyEvent.VK_0);
        button1.setMnemonic(KeyEvent.VK_1);
        button2.setMnemonic(KeyEvent.VK_2);
        button3.setMnemonic(KeyEvent.VK_3);
        button4.setMnemonic(KeyEvent.VK_4);
        button5.setMnemonic(KeyEvent.VK_5);
        button6.setMnemonic(KeyEvent.VK_6);
        button7.setMnemonic(KeyEvent.VK_7);
        button8.setMnemonic(KeyEvent.VK_8);
        button9.setMnemonic(KeyEvent.VK_9);
        //TODO set other keyboard equal

        //Text align to right
        resultTextField.setHorizontalAlignment((JTextField.RIGHT));

        //Create first panel
        JPanel pan1 = new JPanel();

        //Set pan1 as 4*4 matrix, with 5 pixel to the edge
        pan1.setLayout(new GridLayout(4, 4, 5, 5));

        //Add UI parts to the panel
        pan1.add(button7);
        pan1.add(button8);
        pan1.add(button9);
        pan1.add(buttonDive);
        pan1.add(button4);
        pan1.add(button5);
        pan1.add(button6);
        pan1.add(buttonMulti);
        pan1.add(button1);
        pan1.add(button2);
        pan1.add(button3);
        pan1.add(buttonMinus);
        pan1.add(button0);
        pan1.add(buttonDot);
        pan1.add(buttonCal);
        pan1.add(buttonPlus);

        //Set edge distance of pan2 objectives
        pan1.setBorder(BorderFactory.createEmptyBorder(5,5,5,5));

        //Set pan2 for second panel
        JPanel pan2 = new JPanel();
        pan2.setLayout(new BorderLayout());
        pan2.add(resultTextField, BorderLayout.WEST);
        pan2.add(clearButton, BorderLayout.EAST);

        //Set windows position in the screen
        frame.setLocation(300, 200);

        frame.setResizable(false);
        frame.getContentPane().setLayout(new BorderLayout());
        frame.getContentPane().add(pan2, BorderLayout.NORTH);
        frame.getContentPane().add(pan1, BorderLayout.CENTER);

        frame.pack();
        frame.setVisible(true);

        //Action listener to the input
        //Listen to keyboard input, for numbers
        class ListenerNumber implements ActionListener //implements ActionListener
        {
           @SuppressWarnings("unchecked")

            @Override
            public void actionPerformed(ActionEvent e) {
                String ss = ((JButton)(e.getSource())).getText();
                store = (JButton) e.getSource();
                vt.add(store);

                if (k1 ==1) {
                    if (k3 == 1) {
                        str1 = "";

                        //Reset k5.
                        k5 =1;
                    }
                    str1 = str1+ss;

                    k3 =k3 +1;

                    //Display the right number
                    resultTextField.setText(str1);
                }
                else if (k1 == 2) {
                    if (k4==1) {
                        str2 = "";

                        k5 =1;
                    }
                    str2 = str2 +ss;
                    k4 = k4+1;
                    resultTextField.setText(str2);
                }
            }
        }

        //Listen to the input, for signal.
        class ListenerSignal implements ActionListener //implements ActionListener
        {
            //Operation singal
            @SuppressWarnings("unchecked")

            @Override
            public void actionPerformed(ActionEvent e) {
                String ss2 = ((JButton) e.getSource()).getText();
                store = (JButton) e.getSource();

                vt.add(store);

                if (k2 == 1) {
                    /* if k1==1, then input number is stored in str1;
                     *if k1==2, then input number is stored in str2. */
                    k1 = 2;
                    k5 =1;
                    signal = ss2;
                    //update signal input numbers.
                    //k2++;
                }

                else {
                    int a = vt.size();
                    JButton c = (JButton) vt.get(a-2);

                    if (!(c.getText().equals("+")) && !(c.getText().equals("-"))
                            && !(c.getText().equals("*"))
                            && !(c.getText().equals("/"))) {
                        cal();
                        str1 = result;
                        k1 = 2;
                        k5 = 1;
                        k4 = 1;
                        signal = ss2;
                    }

                    //k2++;
                }

                k2++;

            }
        }

        //Logcial for clear button
        class ListenerClear implements ActionListener //implements ActionListener
        {
            @SuppressWarnings("unchecked")

            @Override
            public void actionPerformed(ActionEvent e) {
                store = (JButton) e.getSource();
                vt.add(store);
                k5=1;
                k2=1;
                k1=1;
                k3=1;
                k4=1;
                str1="0";
                str2="0";
                signal="";
                result="";
                resultTextField.setText(result);
                vt.clear();
            }
        }

        //"=" event
        class ListenerCal implements ActionListener //implements ActionListener
        {
            @SuppressWarnings("unchecked")

            @Override
            public void actionPerformed(ActionEvent e) {
                store = (JButton) e.getSource();
                vt.add(store);
                cal();

                //reset all k values.
                k1=1;
                k2=1;
                k3=1;
                k4=1;

                str1 = result;
            }
        }

        //"." event
        class ListenerFloat implements ActionListener //implements ActionListener
        {

            @SuppressWarnings("unchecked")

            @Override
            public void actionPerformed(ActionEvent e) {
                store = (JButton) e.getSource();
                vt.add(store);

                if (k5 == 1) {
                    String ss2 = ((JButton) e.getSource()).getText();

                    if (k1 == 1) {
                        if (k3 == 1) {
                            str1 = "";

                            k5 = 1;
                        }
                        str1 = str1 + ss2;

                        k3++;

                        resultTextField.setText(str1);
                    } else if (k1 == 2) {
                        if (k4 == 1) {
                            str2 = "";
                            k5 = 1;
                        }
                        str2 = str2 + ss2;

                        k4++;

                        resultTextField.setText(str2);
                    }
                }
                k5++;
            }
        }

        //Regist all listeners

        ListenerCal LCal = new ListenerCal();

        //Number key
        ListenerNumber LNum = new ListenerNumber();
        ListenerSignal LSignal = new ListenerSignal();
        ListenerClear LClear = new ListenerClear();
        ListenerFloat LFloat = new ListenerFloat();

        button7.addActionListener(LNum);
        button8.addActionListener(LNum);
        button9.addActionListener(LNum);
        buttonDive.addActionListener(LSignal);
        button4.addActionListener(LNum);
        button5.addActionListener(LNum);
        button6.addActionListener(LNum);
        buttonMulti.addActionListener(LSignal);
        button1.addActionListener(LNum);
        button2.addActionListener(LNum);
        button3.addActionListener(LNum);
        buttonMinus.addActionListener(LSignal);
        button0.addActionListener(LNum);
        buttonDot.addActionListener(LFloat);
        buttonCal.addActionListener(LCal);
        buttonPlus.addActionListener(LSignal);
        clearButton.addActionListener(LClear);

        //Close program windows
        frame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowAdapter e) {
                System.exit(0);
            }
        });
    }

    //Calculation process
    public void cal() {
        //first number
        double a2;
        //second number
        double b2;
        //Operation signal
        String c = signal;
        //Operation result
        double result2=0;

        if (c.equals("")) {
            resultTextField.setText("Please input operator!");
        }
        else {
            //Float number
            if (str1.equals("."))
                str1 = "0.0";
            if (str2.equals("."))
                str2 = "0.0";

            a2 = Double.valueOf(str1);
            b2 = Double.valueOf(str2);

            switch (c) {
                case "+":
                    result2 = a2+b2;
                    break;
                case "-":
                    result2 = a2-b2;
                    break;
                case "*":
                    BigDecimal m1 = new BigDecimal(Double.toString(a2));
                    BigDecimal m2 = new BigDecimal(Double.toString(b2));

                    result2 = m1.multiply(m2).doubleValue();
                    break;
                case "/":
                    if (b2==0)
                        result2 = 0;
                    else
                        result2 = a2 / b2;
                    break;
                default:
                    resultTextField.setText("Wrong input!");
                    break;
            }

            result = Double.toString(result2);

            resultTextField.setText(result);
        }
    }

    @SuppressWarnings("unused")

    public static void main(String[] args){
        //Set the display type
        try {
            UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");
        } catch (Exception e) {
            e.printStackTrace();
        }

        Calculator cal = new Calculator();
    }
}
