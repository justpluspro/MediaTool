package com.liqiwen.media.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

/**
 * @author liqiwen
 **/
public final class ProcessUtil {

    private static String ffmpegPath =  "E:\\ffmpeg-4.3.2-2021-02-02-essentials_build\\bin\\ffmpeg.exe";
    private static String ffprobePath = "E:\\ffmpeg-4.3.2-2021-02-02-essentials_build\\bin\\ffprobe.exe";


    public static String videoConvert(File file) {
        List<String> command = new ArrayList<>();
        command.add(ffmpegPath);
        command.add("-y");
        command.add("-hide_banner");

        //使用多少个线程来执行
        command.add("-threads");
        command.add("1");


        //从什么时候开始
        command.add("-ss");
        command.add("");

        //持续多长时间
        command.add("-t");
        command.add("");


        command.add("-i");
        command.add(file.getAbsolutePath());



        return null;
    }




    public static String extractMetadata(String url) {
        List<String> command = new ArrayList<>();
        command.add(ffmpegPath);
        command.add("-i");
        command.add(url);
        command.add("-hide_banner");
        Optional<String> resultOp = runCommand(command);
        resultOp.ifPresent(System.out::println);

        return null;
    }

    public static String extractMetadataWithFfprobe(String text) {
        List<String> command = new ArrayList<>();
        command.add(ffprobePath);
        command.add("-loglevel");
        command.add("quiet");
        command.add("-show_streams");
        command.add("-show_format");
        command.add(text);
        command.add("_print_format");
        command.add("json");

        Optional<String> result = runCommand(command);
        if(result.isPresent()) {
            Map<String, Object> map = JsonUtil.json2Map(result.get());
            System.out.println(map);
        }



        return null;
    }


    public static Optional<String> runCommand(List<String> command) {
        System.out.println("执行脚本：" + command.toString());

        ProcessBuilder processBuilder = new ProcessBuilder(command);
        processBuilder.redirectErrorStream(true);
        Process process = null;
        try {
            process = processBuilder.start();

            process.waitFor();

            InputStream inputStream = process.getInputStream();
            InputStream errorStream = process.getErrorStream();

            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(errorStream));
            String line;
            StringBuilder result = new StringBuilder();
            while ((line = bufferedReader.readLine()) != null) {
                result.append(line);
            }
            System.out.println("获取结果：" + result.toString());

            BufferedReader resultReader = new BufferedReader(new InputStreamReader(inputStream));
            StringBuilder resultInput = new StringBuilder();
            while ((line = resultReader.readLine()) != null) {
                resultInput.append(line);
            }
            System.out.println("inputStream: " + resultInput);
            return Optional.of(resultInput.toString());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if(process != null) {
                process.destroy();
            }
        }
        return Optional.empty();
    }

}
