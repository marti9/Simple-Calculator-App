package kalkulator;

import java.awt.*;
import java.awt.geom.*;
import java.lang.invoke.StringConcatFactory;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;


public class MainFrame extends JFrame implements Runnable {

    private JPanel buttonPanel;
    private JTextField liczba1;
    private JTextField liczba2;
    private JTextField wynik;

    public MainFrame(String title){

        super(title);

        Dimension dim= Toolkit.getDefaultToolkit().getScreenSize();
        setSize(dim.width / 2,dim.height / 2);
        setLocationByPlatform(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        this.setLayout(new FlowLayout());

        //tworzenie przyciskow
        JTextField liczba1 = new JTextField("Podaj pierwszą liczbę", 10);
        JTextField liczba2 = new JTextField("Podaj drugą liczbę", 10);

        JButton dodajButton = new JButton("dodaj");
        JButton odejmijButton = new JButton("odejmij");

        JTextField wynik = new JTextField("Wynik", 10);

        buttonPanel= new JPanel();


        buttonPanel.add(liczba1);
        buttonPanel.add(liczba2);
        buttonPanel.add(dodajButton);
        buttonPanel.add(odejmijButton);
        buttonPanel.add(wynik);

        //dodanie panelu do ramki 
        add(buttonPanel);

        //dodajAction dodawanie = new dodajAction();
        //odejmijAction odejmowanie = new odejmijAction();

        //dodajButton.addActionListener(dodawanie);
        //odejmijButton.addActionListener(odejmowanie);

        dodajButton.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                wynik.setText(Double.toString(Double.parseDouble(liczba1.getText().trim()) + Double.parseDouble(liczba2.getText().trim())));
            }
        });

        odejmijButton.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                wynik.setText(Double.toString(Double.parseDouble(liczba1.getText().trim()) - Double.parseDouble(liczba2.getText().trim())));
            }
        });

    }


    @Override
    public void run(){
        setVisible(true);
    }

}