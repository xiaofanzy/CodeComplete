package com.learning.core.java.capture5.resourse;

import javax.swing.*;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.nio.charset.StandardCharsets;

public class ResourseTest {

    public static void main(String[] argsa) throws IOException {
        //获取类对象
        Class cl = ResourseTest.class;

        URL aboutURL = cl.getResource("about.gif");

        var icon = new ImageIcon(aboutURL);

        InputStream stream = cl.getResourceAsStream("date/about.txt");
        var about = new String(stream.readAllBytes(),"UTF-8");

        InputStream stream2 = cl.getResourceAsStream("corejava/title.txt");
        var title = new String(stream2.readAllBytes(), StandardCharsets.UTF_8).trim();

        JOptionPane.showMessageDialog(null,about,title,JOptionPane.INFORMATION_MESSAGE,icon);
    }
}
