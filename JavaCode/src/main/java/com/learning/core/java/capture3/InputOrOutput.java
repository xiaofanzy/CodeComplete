package com.learning.core.java.capture3;

import java.io.Console;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.util.Scanner;

public class InputOrOutput {

    public static void main(String[] args) throws IOException {

        // 文件输入
        Scanner in = new Scanner(System.in);
        System.out.println("请输入数据");
        int i = in.nextInt();

        System.out.println("请输入名称");
        String name = in.nextLine();

        Console console = System.console();
        String s = console.readLine("User name");
        char[] psswords = console.readPassword("you pssword");

        //文件输入与输出      注意编码格式为StandardCharsets.UTF_8
        // 写入一个文件
        Scanner scanner = new Scanner(Path.of("d:\\readExcelMaven\\test.xls"), StandardCharsets.UTF_8);

        // 输出一个文件
        // 如果这个文件不存在，则创建该文件；
        PrintWriter printWriter = new PrintWriter("mytext.txe", StandardCharsets.UTF_8);

    }
}
