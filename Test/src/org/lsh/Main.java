package org.lsh;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    public static void main(String[] args) {
	// write your code here
        // 按指定模式在字符串查找
        String line = "/global/asdf";
        String pattern = "^/global/.*";

        // 创建 Pattern 对象
        Pattern r = Pattern.compile(pattern);

        // 现在创建 matcher 对象
        Matcher m = r.matcher(line);
        if (m.matches()) {
//            System.out.println("Found value: " + m.group(0) );
//            System.out.println("Found value: " + m.group(1) );
//            System.out.println("Found value: " + m.group(2) );
            System.out.println("Match");
        } else {
            System.out.println("NO MATCH");
        }
    }
}
