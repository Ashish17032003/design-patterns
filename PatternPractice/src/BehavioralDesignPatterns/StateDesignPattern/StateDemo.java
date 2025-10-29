package BehavioralDesignPatterns.StateDesignPattern;

import javax.swing.*;

public class StateDemo {
    public static void main(String[] args) {
        Phone phone = new Phone();
        JButton homeButton = new JButton("Home");
        homeButton.addActionListener(e -> phone.home());
        JButton onOff = new JButton("On/Off");
        onOff.addActionListener(e -> phone.lock());
    }
}
