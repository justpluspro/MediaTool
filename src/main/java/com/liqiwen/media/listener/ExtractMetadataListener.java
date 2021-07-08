package com.liqiwen.media.listener;

import com.liqiwen.media.util.ProcessUtil;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author liqiwen
 **/
public class ExtractMetadataListener implements ActionListener {


    private final JTextField jTextField;

    private String ffmpegPath = "C:\\Users\\admin\\Downloads\\ffmpeg-release-i686-static.tar\\ffmpeg-release-i686-static\\ffmpeg-4.4-i686-static\\ffmpeg.exe";

    public ExtractMetadataListener(JTextField jTextField) {
        this.jTextField = jTextField;
    }


    @Override
    public void actionPerformed(ActionEvent e) {

        String text = jTextField.getText();

        System.out.println("click url：" + text);
//        String s = ProcessUtils.extractMetadata(text);

        String s = ProcessUtil.extractMetadataWithFfprobe(text);

    }
}
