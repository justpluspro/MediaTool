package com.liqiwen.media.listener;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ProcessListener implements ActionListener {

    private JPanel parentFrame;

    public ProcessListener(JPanel jPanel) {
        this.parentFrame = jPanel;
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        showOutputWindow(parentFrame);

    }

    private void showOutputWindow(JPanel relativeWindow) {
        JFrame newFrame = new JFrame("正在处理中");
        newFrame.setSize(250, 250);


        newFrame.setLocationRelativeTo(relativeWindow);

        newFrame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        newFrame.setResizable(false);

        JPanel panel = new JPanel(new GridLayout(1, 1));

        // 在新窗口中显示一个标签
        JLabel label = new JLabel("这是一个窗口");
        label.setFont(new Font(null, Font.PLAIN, 25));
        label.setHorizontalAlignment(SwingConstants.CENTER);
        label.setVerticalAlignment(SwingConstants.CENTER);
        panel.add(label);

        newFrame.setContentPane(panel);
        newFrame.setVisible(true);

    }
}
