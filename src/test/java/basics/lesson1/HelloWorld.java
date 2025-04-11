package basics.lesson1;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.TextStyle;
import java.util.Locale;

public class HelloWorld {
    @Test
    public void printHelloWorld() {
        System.out.println("Hello, world");
        byte age = 127;
        Byte bigAge = null;

        short distance = 32767;
        Short bigDistance = null;

        int userId = 2146545689;
        Integer bigUserId = 25465123;

        long id = 92284693184796L;
        Long bigId = 925413587841L;

        float price = 13.76F;
        Float bigPrice = 999.99F;

        double weight = 4.4098;
        Double bigWeight = 8888.9865;
        double secondWeight = 77.8;

        char letter = 'h';
        Character stace = ' ';

        String text = "Hello, Dilyara!";
        String oneChar = "h";

        boolean isLightSwitchedOn = true;
        Boolean isLecturerDead = true;


        double result = weight + secondWeight; //result = 4.4098+77.8;


    }


    @Test
    public void variablesExamples() {
        int a = 13;
        int b = 44;

        String c = "13";
        String d = "44";

        System.out.println(a + b); //57
        System.out.println(c + d); //1344

        String name = "Dilyara";
        String surname = "The Tester";
        System.out.println(name + " " + surname);

        int x = 12345;
        String y = "12345";

        int z = Integer.parseInt(y);
        System.out.println(z);



        LocalDate date = LocalDate.now();
        LocalDateTime dateTime = LocalDateTime.now();
        System.out.println("Date without time: " + date);
        System.out.println("Date with time: " + dateTime);

        System.out.println(date.getMonth().getDisplayName(TextStyle.SHORT, Locale.GERMANY));
        System.out.println(date.plusYears(2).getDayOfWeek().getDisplayName(TextStyle.FULL, Locale.GERMAN));


    }
}

    public class HelloWorld {
        @Test
        public void tryMe() {
            System.out.println("Hello World");
            System.out.println("Another other String");
        }
    }