package com.seanponeil.zalgotextgenerator;

import java.util.Random;

/**
 *  Utility class for transforming a given String into a
 * "Zalgo" String.
 *
 *  The stackable Unicode chars reference can be found at
 *  eeemo.net
 *
 *  @author Sean O'Neil <oneilse14@gmail.com>
 */
public class ZalgoString {

    //Unicode chars that go up
    private static final char[] UP_CHARS = {
            '\u030d', /*     ̍     */        '\u030e', /*     ̎     */
            '\u0304', /*     ̄     */        '\u0305', /*     ̅     */
            '\u033f', /*     ̿     */        '\u0311', /*     ̑     */
            '\u0306', /*     ̆     */        '\u0310', /*     ̐     */
            '\u0352', /*     ͒     */        '\u0357', /*     ͗     */
            '\u0351', /*     ͑     */        '\u0307', /*     ̇     */
            '\u0308', /*     ̈     */        '\u030a', /*     ̊     */
            '\u0342', /*     ͂     */        '\u0343', /*     ̓     */
            '\u0344', /*     ̈  ́     */    '\u034a', /*     ͊     */
            '\u034b', /*     ͋     */        '\u034c', /*     ͌     */
            '\u0303', /*     ̃     */        '\u0302', /*     ̂     */
            '\u030c', /*     ̌     */        '\u0350', /*     ͐     */
            '\u0300', /*     ̀     */        '\u0301', /*     ́     */
            '\u030b', /*     ̋     */        '\u030f', /*     ̏     */
            '\u0312', /*     ̒   */            '\u0313', /*     ̓     */
            '\u0314', /*     ̔     */        '\u033d', /*     ̽     */
            '\u0309', /*     ̉     */        '\u0363', /*     ͣ     */
            '\u0364', /*     ͤ     */        '\u0365', /*     ͥ     */
            '\u0366', /*     ͦ     */        '\u0367', /*     ͧ     */
            '\u0368', /*     ͨ     */        '\u0369', /*     ͩ     */
            '\u036a', /*     ͪ     */        '\u036b', /*     ͫ     */
            '\u036c', /*     ͬ     */        '\u036d', /*     ͭ     */
            '\u036e', /*     ͮ     */        '\u036f', /*     ͯ     */
            '\u033e', /*     ̾     */        '\u035b', /*     ͛     */
            '\u0346', /*     ͆     */        '\u031a'  /*     ̚     */
    };

    //Unicode chars that go down
    private static final char[] DOWN_CHARS = {
            '\u0316', /*     ̖     */        '\u0317', /*     ̗     */
            '\u0318', /*     ̘     */        '\u0319', /*     ̙     */
            '\u031c', /*     ̜     */        '\u031d', /*     ̝     */
            '\u031e', /*     ̞     */        '\u031f', /*     ̟     */
            '\u0320', /*     ̠     */        '\u0324', /*     ̤     */
            '\u0325', /*     ̥     */        '\u0326', /*     ̦     */
            '\u0329', /*     ̩     */        '\u032a', /*     ̪     */
            '\u032b', /*     ̫     */        '\u032c', /*     ̬     */
            '\u032d', /*     ̭     */        '\u032e', /*     ̮     */
            '\u032f', /*     ̯     */        '\u0330', /*     ̰     */
            '\u0331', /*     ̱     */        '\u0332', /*     ̲     */
            '\u0333', /*     ̳     */        '\u0339', /*     ̹     */
            '\u033a', /*     ̺     */        '\u033b', /*     ̻     */
            '\u033c', /*     ̼     */        '\u0345', /*     ͅ     */
            '\u0347', /*     ͇     */        '\u0348', /*     ͈     */
            '\u0349', /*     ͉     */        '\u034d', /*     ͍     */
            '\u034e', /*     ͎     */        '\u0353', /*     ͓     */
            '\u0354', /*     ͔     */        '\u0355', /*     ͕     */
            '\u0356', /*     ͖     */        '\u0359', /*     ͙     */
            '\u035a', /*     ͚     */        '\u0323'  /*     ̣     */
    };

    //Unicode chars that stay in the middle
    private static final char[] MID_CHARS = {
            '\u0315', /*     ̕     */        '\u031b', /*     ̛     */
            '\u0340', /*     ̀     */        '\u0341', /*     ́     */
            '\u0358', /*     ͘     */        '\u0321', /*     ̡     */
            '\u0322', /*     ̢     */        '\u0327', /*     ̧     */
            '\u0328', /*     ̨     */        '\u0334', /*     ̴     */
            '\u0335', /*     ̵     */        '\u0336', /*     ̶     */
            '\u034f', /*     ͏     */        '\u035c', /*     ͜     */
            '\u035d', /*     ͝     */        '\u035e', /*     ͞     */
            '\u035f', /*     ͟     */        '\u0360', /*     ͠     */
            '\u0362', /*     ͢     */        '\u0338', /*     ̸     */
            '\u0337', /*     ̷     */        '\u0361', /*     ͡     */
            '\u0489' /*     ҉_     */
    };

    private static boolean isZalgo(char c){
        for(int i=0; i<UP_CHARS.length; i++){
            if(c == UP_CHARS[i]){
                return true;
            }
        }
        for(int i=0; i<DOWN_CHARS.length; i++){
            if(c == DOWN_CHARS[i]){
                return true;
            }
        }
        for(int i=0; i<MID_CHARS.length; i++){
            if(c == MID_CHARS[i]){
                return true;
            }
        }
        return false;
    }

    public static String generate(String source){
        StringBuilder result = new StringBuilder();
        Random rand = new Random(System.currentTimeMillis());

        for(int i=0; i<source.length(); i++){
            if(isZalgo(source.charAt(i))){
                continue;
            }else{
                result.append(source.charAt(i));
            }

            //TODO: Make these values come from user preferences, probably a slider
            int upCharCount = rand.nextInt(16);
            int downCharCount = rand.nextInt(6);
            int midCharCount = rand.nextInt(16);

            for(int j=0; j<upCharCount; j++){
                result.append(UP_CHARS[rand.nextInt(UP_CHARS.length)]);
            }
            for(int j=0; j<downCharCount; j++){
                result.append(DOWN_CHARS[rand.nextInt(DOWN_CHARS.length)]);
            }
            for(int j=0; j<midCharCount; j++){
                result.append(MID_CHARS[rand.nextInt(MID_CHARS.length)]);
            }
        }

        return result.toString();
    }

    public static String generateHTML(String source){
        StringBuilder result = new StringBuilder();
        result.append("<html>").append("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\" />")
                .append("<head><style type=\"text/css\">")
                .append("@font-face {")
                .append("font-family: TimesNewRoman;")
                .append("src: url(\"file:///android_asset/TimesNewRoman.ttf\") }")
                .append("body {")
                .append("font-family: TimesNewRoman;")
                .append("}")
                .append("</style></head>")
                .append("<body>").append(generate(source))
                .append("</body>").append("</html>");
        return result.toString();
    }


}
