package exam02;

import java.time.LocalDate;

public class Ex08 {
    public static void main(String[] args) {
        LocalDate today = LocalDate.of(2024,2,4);
        int yoil = today.getDayOfWeek().getValue();
        System.out.println(yoil);
    }
}
