package STRINGMANIPULATOR;


public class StringManipulator{
    public static String trimAndConcat(String str1, String str2){
        return str1.trim() + str2.trim();
    }
    public static int getIndexOrNull(String cba1, char letter){
        return cba1.indexOf(letter);
    } 
    public static int getIndexOrNull(String abc1, String abc2){
        return abc1.indexOf(abc2);
    }
    public static String concatSubstring(String string, int d, int e, String string2){
        String woord = string.substring(d, e);
        return woord.trim() + string2.trim();
    }
}
