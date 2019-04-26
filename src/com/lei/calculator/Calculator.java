package com.lei.calculator;

import javax.swing.*;
import java.awt.*;
import java.util.Vector;
import java.awt.event.KeyEvent;

public class Calculator {

    //Create strings to record input
    String str1 = "0";
    String str2 = "0";

    //Create singal recorder, default as +
    String signal = "+";

    //Create result string
    String result = "";

    //Set status of switches
    int k1 = 1;
    int k2 = 1;
    int k3 = 1;
    int k4 = 1;
    int k5 = 1;

    //Store button status
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
    JButton buttonCal = new JButton("=");        //orignial is button_dy

    //Constructor of Calculator
    public Calculator(){

        button0.setMnemonic(KeyEvent.VK_0);

        resultTextField.setHorizontalAlignment((JTextField.RIGHT));

        //Create first panel
        JPanel pan1 = new JPanel();

        //Set pan1 as 4*4 matrix, with 5 pixel to the edge
        pan1.setLayout(new GridLayout(4, 4, 5, 5));

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

        //Set edge distance
        frame.setLocation(300, 200);

        frame.setResizable(false);
        frame.getContentPane().setLayout(new BorderLayout());
        frame.getContentPane().add(pan2, BorderLayout.NORTH);
        frame.getContentPane().add(pan1, BorderLayout.CENTER);

        frame.pack();
        frame.setVisible(true);


    }

}
