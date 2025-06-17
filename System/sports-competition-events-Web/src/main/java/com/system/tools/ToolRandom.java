package com.system.tools;


import java.util.Random;

public class ToolRandom {


    private static final String[] email_suffix = ("@gmail.com,@yahoo.com,@msn.com,@hotmail.com,@aol.com,@ask.com," +
            "@live.com,@qq.com,@0355.net,@163.com,@163.net,@263.net,@3721.net,@yeah.net," +
            "@googlemail.com,@126.com,@sina.com,@sohu.com,@yahoo.com.cn").split(",");
    /**
     * 返回Email
     *
     * @param lMin 最小长度
     * @param lMax 最大长度
     * @return
     */
    public static String str = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
    /**
     * 返回手机号码
     */
    private static String[] telFirst = "134,135,136,137,138,139,150,151,152,157,158,159,130,131,132,155,156,133,153".split(",");

    public static String getEmail(int lMin, int lMax) {
        int length = randomInt(lMin, lMax);
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < length; i++) {
            int number = (int) (Math.random() * str.length());
            sb.append(str.charAt(number));
        }
        sb.append(email_suffix[(int) (Math.random() * email_suffix.length)]);
        return sb.toString();
    }

    /**
     * 返回手机号
     *
     * @return
     */
    private static String getTel() {
        int index = randomInt(0, telFirst.length - 1);
        String first = telFirst[index];
        String second = String.valueOf(randomInt(1, 888) + 10000).substring(1);
        String thrid = String.valueOf(randomInt(1, 9100) + 10000).substring(1);
        return first + second + thrid;
    }

    /**
     * 返回银行卡号
     *
     * @return
     */
    private static String getCarNum() {

        String prefix = "622309";
        for (int j = 0; j < 13; j++) {
            prefix = prefix + Math.floor(Math.random() * 10);
        }
        prefix = prefix.replace(".", "");
        return prefix;
    }

    /**
     * 生成[min, max]之间的随机整数
     *
     * @param min 最小整数
     * @param max 最大整数
     */
    private static int randomInt(int min, int max) {
        return new Random().nextInt(max) % (max - min + 1) + min;
    }

    /**
     * 产生随机字符数据 + 时间戳
     *
     * @return
     */
    public static String returnRandomString() {
        Random random = new Random();
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < 10; i++) {
            int number = random.nextInt(62);
            sb.append(str.charAt(number));
        }
        return sb.toString() + System.currentTimeMillis();
    }


}
