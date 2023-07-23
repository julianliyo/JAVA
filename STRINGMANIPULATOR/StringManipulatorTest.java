package STRINGMANIPULATOR;

public class StringManipulatorTest {
    public static void main(String[] args) {
        StringManipulator manipulator = new StringManipulator();
String str = manipulator.trimAndConcat("    Hola     ","     Mundo    ");
System.out.println(str); // HolaMundo 

 char letter = 'n';
 int a = manipulator.getIndexOrNull("Coding", letter);
 int b = manipulator.getIndexOrNull("Hola Mundo", letter);
int c = manipulator.getIndexOrNull("Saludar", letter);
 System.out.println(a); // 4
 System.out.println(b); // 7
 System.out.println(c); // -1
 

 String word = "Hola";
 String subString = "la";
 String notSubString = "mundo";
 int f = manipulator.getIndexOrNull(word, subString);
 int g = manipulator.getIndexOrNull(word, notSubString);
 System.out.println(f); // 2
 System.out.println(g); // -1
 
String woord = manipulator.concatSubstring("Hola", 1, 3, "mundo");
System.out.println(woord); // olmundo



    }
}

