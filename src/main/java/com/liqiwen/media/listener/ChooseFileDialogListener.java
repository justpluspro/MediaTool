package com.liqiwen.media.listener;


import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;


public class ChooseFileDialogListener implements ActionListener {

    private final JPanel parent;

    public ChooseFileDialogListener(JPanel parent) {
        this.parent = parent;
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        JFileChooser jFileChooser = new JFileChooser();
        //设置默认显示为当前文件夹
        jFileChooser.setCurrentDirectory(new File("."));

        //设置选择文件模式
        jFileChooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
        //是否允许多选
        jFileChooser.setMultiSelectionEnabled(true);

//        jFileChooser.addChoosableFileFilter(new FileNameExtensionFilter("*.mp4, *.avi"));
//        jFileChooser.setFileFilter(new FileNameExtensionFilter("video(*.mp4, *.)"));

        int result = jFileChooser.showOpenDialog(parent);
        if(result == JFileChooser.APPROVE_OPTION) {
            File selectedFile = jFileChooser.getSelectedFile();


            System.out.println("选择的文件：" + selectedFile);

        }

    }
}
