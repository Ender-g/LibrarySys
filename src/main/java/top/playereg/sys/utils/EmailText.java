/*
 *
 * @author: playereg
 * @description: 邮件文本内容
 * @version: 1.0
 *
 * */

package top.playereg.sys.utils;

public class EmailText {
    public static String code = (int) ((Math.random() * 9 + 1) * 100000) + ""; // 生成随机验证码
    public static String text1 = "<h1 style=\"font-size: 18px\">Ciallo～(∠・ω< )⌒☆</h1>" +
            "<h1 style=\"font-size: 18px\">主人，欢迎加入我们！！！</h1>" +
            "<h1 style=\"font-size: 18px\">您的验证码是：</h1>" +
            "<div style=\"font-size: 50px;text-align: center;margin-top: 70px;\">" + code + "</div>" +
            "<div style=\"font-size: 13px;text-align: center;margin-top: 100px;\">" +
            "主人的验证码5分钟内有效，请不要外传哦！</div>" +
            "<div style=\"font-size: 13px;text-align: center;margin-top: 20px;\">" +
            "请勿回复此邮件，此邮件为系统自动发送，请勿回复。</div>";
    public static String text2 = "<h1 style=\"font-size: 18px\">Ciallo～(∠・ω< )⌒☆</h1>" +
            "<h1 style=\"font-size: 18px\">主人，欢迎回来！！！</h1>" +
            "<h1 style=\"font-size: 18px\">您的验证码是：</h1>" +
            "<div style=\"font-size: 50px;text-align: center;margin-top: 70px;\">" + code + "</div>" +
            "<div style=\"font-size: 13px;text-align: center;margin-top: 100px;\">" +
            "主人的验证码5分钟内有效，请不要外传哦！</div>" +
            "<div style=\"font-size: 13px;text-align: center;margin-top: 20px;\">" +
            "请勿回复此邮件，此邮件为系统自动发送，请勿回复。</div>";
    public static String text3 = "<h1 style=\"font-size: 18px\">Ciallo～(∠・ω< )⌒☆</h1>" +
            "<h1 style=\"font-size: 18px\">主人，您需要更改密码吗？</h1>" +
            "<h1 style=\"font-size: 18px\">您的验证码是：</h1>" +
            "<div style=\"font-size: 50px;text-align: center;margin-top: 70px;\">" + code + "</div>" +
            "<div style=\"font-size: 13px;text-align: center;margin-top: 100px;\">" +
            "主人的验证码5分钟内有效，请不要外传哦！</div>" +
            "<div style=\"font-size: 13px;text-align: center;margin-top: 20px;\">" +
            "请勿回复此邮件，此邮件为系统自动发送，请勿回复。</div>";
}
