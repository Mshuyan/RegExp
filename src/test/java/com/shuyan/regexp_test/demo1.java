package com.shuyan.regexp_test;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class demo1 {

    // 字符串验证（方法1）
    @Test
    public void matchesMethodTest1(){
        String str = "I am noob from runoob.com.";
        String regExp = ".*runoob.*";

        boolean isMatch = Pattern.matches(regExp, str);
        System.out.println("字符串中是否包含了 'runoob' 子字符串? " + isMatch);
    }

    // 字符串验证（方法2）
    @Test
    public void matchesMethodTest2(){
        String str = "I am noob from runoob.com.";
        String regExp = ".*runoob.*";

        Pattern pattern = Pattern.compile(regExp);
        Matcher matcher = pattern.matcher(str);
        boolean isMatch= matcher.matches();
        System.out.println("字符串中是否包含了 'runoob' 子字符串? " + isMatch);
    }

    // 字符串验证（方法3）
    @Test
    public void matchesMethodTest3(){
        boolean isMatch = "I am noob from runoob.com.".matches(".*runoob.*");
        System.out.println("字符串中是否包含了 'runoob' 子字符串? " + isMatch);
    }

    // 字符串分割（方法1）
    @Test
    public void splitMethodTest1(){
        // 使用1个或多个","、" "或"|"分割字符串
        Pattern pattern = Pattern.compile("[, |]+");
        String[] strs = pattern.split("Java    Hello World Java,Hello,,World|Sun");
        System.out.println(Arrays.asList(strs));
    }

    // 字符串分割（方法2）
    @Test
    public void splitMethodTest2(){
        // 使用1个或多个","、" "或"|"分割字符串
        String[] split = "Java    Hello World Java,Hello,,World|Sun".split("[, |]+");
        System.out.println(Arrays.asList(split));
    }

    // 查找匹配到的字符串
    @Test
    public void findTest(){
        String str = "I am noob from runoob.com.";
        String regExp = "\\S*noob\\S*";

        Pattern pattern = Pattern.compile(regExp);
        Matcher matcher = pattern.matcher(str);
        // 查找下一个匹配到的字符串，匹配到返回true，否则返回false
        while (matcher.find()){
            // 返回匹配到的字符串
            System.out.println(matcher.group());
            // 返回匹配到的字符串在原字符串中的索引
            System.out.println(matcher.start());
            // 返回匹配到的字符串的最后1个字母在原字符串中的索引
            System.out.println(matcher.end());
        }
    }

    // 字符串替换1
    @Test
    public void replaceMethodTest1(){
        Pattern pattern = Pattern.compile("正则表达式");
        Matcher matcher = pattern.matcher("正则表达式 Hello World,正则表达式 Hello World");
        //替换第一个
        System.out.println(matcher.replaceFirst("Java"));
        //替换全部
        System.out.println(matcher.replaceAll("Java"));
    }

    // 字符串替换2
    @Test
    public void replaceTest2(){
        //替换第一个
        String s = "正则表达式 Hello World,正则表达式 Hello World".replaceFirst("正则表达式", "java");
        System.out.println(s);
        //替换全部
        s = "正则表达式 Hello World,正则表达式 Hello World".replaceAll("正则表达式", "java");
        System.out.println(s);
    }


    @Test
    public void appendTest(){
        // 逐个替换字符串中匹配到的多个子字符串
        Pattern pattern = Pattern.compile("正则表达式");
        Matcher matcher = pattern.matcher("正则表达式 Hello World,正则表达式 Hello World ");
        StringBuffer sbr = new StringBuffer();
        while (matcher.find()) {
            /*
                将当前匹配子串替换为指定字符串，并且将替换后的子串以及其之前到上次匹配子串之后的
                字符串段添加到一个 StringBuffer 对象里
             */
            matcher.appendReplacement(sbr, "Java");
        }
        // 将最后一次匹配工作后剩余的字符串添加到一个 StringBuffer 对象里
        matcher.appendTail(sbr);
        System.out.println(sbr.toString());
    }

    @Test
    public void htmlTest(){
        Pattern pattern = Pattern.compile("<.+?>");
        Matcher matcher = pattern.matcher("<a href=\"index.html\">主页</a>");
        String string = matcher.replaceAll("");
        System.out.println(string);
    }

    @Test
    public void findTest1(){
        Pattern pattern = Pattern.compile("\\b\\w*e\\w*\\b");
        Matcher matcher = pattern.matcher(" Google google");
        while (matcher.find()){
            System.out.println("["+matcher.group()+"]");
        }
        /*
            [Google]
            [google]
         */

        pattern = Pattern.compile("\\b.*\\b");
        matcher = pattern.matcher(" Google google");
        while (matcher.find()){
            System.out.println("["+matcher.group()+"]");
        }
        /*
            [Google google]
            []
         */
    }

    @Test
    public void emailTest(){
        Pattern pattern = Pattern.compile("(?![.-_]{2,})[a-zA-Z][\\w-._]{1,16}\\w");
        Matcher matcher = pattern.matcher("18310040701");
        System.out.println(matcher.matches());
    }

    @Test
    public void phoneNumTest(){
        Pattern pattern = Pattern.compile("1[34578]\\d{9}");
        Matcher matcher = pattern.matcher("18310040701");
        System.out.println(matcher.matches());
    }

    @Test
    public void test2(){
        Pattern pattern = Pattern.compile("\\w*(?<=he)llo");
        Matcher matcher = pattern.matcher("hallo");
        while (matcher.find()){
            System.out.println("["+matcher.group()+"]");
        }
    }

    @Test
    public void test4(){
        Pattern pattern = Pattern.compile("(?=llo)\\w*");
        Matcher matcher = pattern.matcher("hallo");
        while (matcher.find()){
            System.out.println("["+matcher.group()+"]");
        }
    }

    @Test
    public void test3(){
        Pattern pattern = Pattern.compile(".*?(?<!.*[（].*)（");
        Matcher matcher = pattern.matcher("北京市（海淀区）（朝阳区）（西城区）");
        while (matcher.find()){
            System.out.println("["+matcher.group()+"]");
        }
    }

    @Test
    public void test5(){
        Pattern pattern = Pattern.compile("^(?![0-9])[a-z0-9]+$");
        Matcher matcher = pattern.matcher("1a12");
        while (matcher.find()){
            System.out.println("["+matcher.group()+"]");
        }
    }

    @Test
    public void test6(){
        String str = "orderRefunded : testingItem: 不能为空字符串    >>> 1020";
        String str1 = "orderRefunded : testingItem: 不能为空字符串";
        Pattern pattern = Pattern.compile("^" + str1 + ".*");
        Matcher matcher = pattern.matcher(str);
        System.out.println(matcher.matches());
    }

    @Test
    public void test7(){
        //>>> 5,5,5,5,5,5,5,33,34
        String str = ">>> 5,5,5,5,5,5,5,33,34";
        String reg = "(?<=(>>> |,))\\w*(?=(,|$))";
        Pattern pattern = Pattern.compile(reg);
        Matcher matcher = pattern.matcher(str);
        while (matcher.find()){
            String group = matcher.group();
            System.out.println(group);
        }
    }
}
