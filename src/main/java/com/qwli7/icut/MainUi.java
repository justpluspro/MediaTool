package com.qwli7.icut;

import javax.swing.*;

public class MainUi {


    public static void main(String[] args) {

        SwingUtilities.invokeLater(() -> {
            MainUi mainUi = new MainUi();
            mainUi.createMainUi();
        });


    }


    public void createMainUi() {
        JFrame mainFrame = new JFrame();

    }
}
