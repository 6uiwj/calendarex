package exam02;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.format.TextStyle;
import java.util.Locale;
import java.util.Scanner;

public class Calendar {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("연도를 입력하세요 :");
        int year = Integer.parseInt(sc.nextLine());
        System.out.print("월을 입력하세요: ");
        int month = Integer.parseInt(sc.nextLine());

        //첫째날 구하기
        LocalDate startDate = LocalDate.of(year, month, 1);
        //System.out.println("startDate: "+startDate);
        //1=월요일 ~ 7=일요일
        int firstYoil = startDate.getDayOfWeek().getValue() ;
        //System.out.println(firstYoil);
        //DayOfWeek dayOfWeek = startDate.getDayOfWeek();
        //String yoil = dayOfWeek.getDisplayName(TextStyle.FULL, Locale.KOREAN);
        //System.out.println(yoil);
        System.out.println("월\t화\t수\t목\t금\t토\t일");

        for (int i = 1; i < firstYoil; i++) {
            System.out.print(" ");
        }

        //이 달이 몇일까지 있는지
        int daysInMonth = startDate.lengthOfMonth();

        for (int i = 1; i <= daysInMonth; i++) {
            System.out.print(i  + "\t");

            if ((i + firstYoil - 1) % 7 == 0) {
                System.out.println();
            }

        }
    }
}