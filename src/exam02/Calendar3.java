package exam02;

import java.time.LocalDate;
import java.time.temporal.ChronoField;
import java.util.Scanner;

public class Calendar3 {
    public static void main(String[] args) {
        //LocalDate today = LocalDate.now();
        LocalDate today = LocalDate.of(2024,2,1);
        System.out.println(today);

        int nowMonth = today.getMonthValue();
        String[] yoils =  {"일", "월", "화", "수", "목", "금", "토"};

        LocalDate startDate = LocalDate.of(today.getYear(), today.getMonthValue(),1);
        LocalDate endDate = LocalDate.of(today.getYear(), today.getMonthValue(), today.lengthOfMonth());
        //현재 월 출력
        System.out.println("현재 달 : " +nowMonth);
        System.out.println("현재 달 시작일 : " + startDate);
        System.out.println("현재 달 마지막일 " + endDate);


/*
        //다음 월 출력(현재 월이 12월이면 1이 출력되도록)
        LocalDate nextMonthDay = today.plusMonths(1);
        int nextMonth = nextMonthDay.getMonthValue();
        System.out.println("한달 뒤 : " + nextMonthDay);
        System.out.println("다음달 : " + nextMonth);
        LocalDate nextStartDate = LocalDate.of(nextMonthDay.getYear(), nextMonthDay.getMonthValue(),1);
        LocalDate nextEndDate = LocalDate.of(nextMonthDay.getYear(),nextMonthDay.getMonthValue(),nextMonthDay.lengthOfMonth());
        System.out.println("다음 달 시작일 : " + nextStartDate);
        System.out.println("다음 달 마지막일 : " + nextEndDate);


 */
        int startYoil = startDate.getDayOfWeek().getValue();
        System.out.println("이번 달 시작 요일 : " + startYoil);

        int firstSunday= 0;

        //첫번째 일요일 구하기
        for(int i=0 ; i<7; i++) {
            if(startDate.plusDays(i).getDayOfWeek().getValue()==7) {
                firstSunday = startDate.plusDays(i).getDayOfMonth();
            }
        }

        for (String yoil : yoils) {
            System.out.print(yoil + " ");
        }
        System.out.println();

        //1부터 마지막일까지
        for (int i=1; i<=today.lengthOfMonth(); i++) {
            int digitCount = (int)(Math.log10(i)+1);
            //일요일이면 다음줄로 넘긴다.
            if(i%7==firstSunday) {
           //if(today.getDayOfWeek().getValue()%7==0) {
                System.out.println();
            }

            if(i==1) {
                for (int j = 1; j <= startYoil; j++) {
                    System.out.print("   ");
                }
            }
            if (digitCount==1) {
                System.out.print(i+"  ");
            } else {
                System.out.print(i + " ");
            }

            }


        }






    }

