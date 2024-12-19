import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class Main {
    public static void main(String[] args) {
        while (true){
           clock();
            break;
        }
    }
    public static void clock(){
        LocalTime clock = LocalTime.now();
        DateTimeFormatter p = DateTimeFormatter.ofPattern("HH:mm");
        String format = clock.format(p);
        String now;
        if (clock.isAfter(LocalTime.of(5,59)) && clock.isBefore(LocalTime.of(9,0))){
            now = "Кутман таң! Caaт  ->  ";
        }else if (clock.isAfter(LocalTime.of(9,0)) && clock.isBefore(LocalTime.of(18,0))){
            now = "Кутман кун! Caaт  ->  ";
        }else {
            now = "Кутман кеч! Caaт  ->  ";
        }
        System.out.printf(now+format);
    }
}