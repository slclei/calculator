package com.lei.calculator;

import javax.swing.*;
import java.awt.*;

public class Calculator {
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
    JButton buttonCal = new JButton("=");

    /* Next part is creating two panels, one for number and calculation buttons,
    another is for display and clear button*/

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

    //Set edge distance of



}
