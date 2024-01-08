package exam02;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.time.format.TextStyle;
import java.time.temporal.ChronoField;
import java.time.temporal.ValueRange;
import java.util.Locale;

public class LocalDatePackageEx {
    public static void main(String[] args) {

        LocalDate date = LocalDate.now();

        //날짜지정
        LocalDate setDate = LocalDate.of(2024,1,1);
        System.out.println(setDate);

        //attime
            LocalDateTime dateAtTime = date.atTime(3,20);
            System.out.println(dateAtTime);
            LocalDateTime dateAtTime2 = date.atTime(4,30,19);
            System.out.println(dateAtTime2);

        //날짜비교
            //int compare = date.compareTo(ChronoLocalDate oter)


        //equal
            String targetDateString = "2024-01-08";
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            LocalDate targetDate = LocalDate.parse(targetDateString, formatter);

            LocalDate today = LocalDate.now();
            System.out.printf("두 날짜 비교결과 %s%n",today.equals(targetDate));

            LocalDate date1 = LocalDate.of(2024,1,1);
            boolean equalEx = date.equals(date1);
            System.out.println("date와 date1의 비교 결과: " + equalEx);

        //from : 날짜를 포함한 객체에서 날짜를 추출
            // LocalDateTime 객체에서 LocalDate 객체를 생성합니다.
            LocalDateTime dateTime = LocalDateTime.of(2024, 1, 8, 12, 0, 0);
            LocalDate date3 = LocalDate.from(dateTime);
            System.out.println("dateTime의 날짜는" + date3);

        //get 연/월/일/요일
            //date = 2024-01-08
            //int year = date.get(ChronoField.YEAR);    // 2024
            int year = date.getYear(); //2024

            int month = date.get(ChronoField.MONTH_OF_YEAR);  // 1

            int dayOfMonth = date.get(ChronoField.DAY_OF_MONTH); // 8
            int dayOfWeek = date.get(ChronoField.DAY_OF_WEEK);  // 2 (월요일)
            int dayOfYear = date.get(ChronoField.DAY_OF_YEAR);  // 8
        System.out.printf("연:%d%n 월:%d%n 일:%d%n 요일:%d%n 1월1일부터 몇일이 지났는지:%d%n",
                year,month, dayOfMonth, dayOfWeek, dayOfYear);

        //월을 한글로 출력하기
            Month month1 = date.getMonth();
            int month2 = date.getMonthValue();
            String monthName = month1.getDisplayName(TextStyle.FULL, Locale.KOREAN);
            System.out.println(date+"의 현재 월은 '" + monthName +"' 입니다.");
            System.out.println(date+"의 현재 월은 '" + month2 +"' 입니다.");

        //isAfter(), isBefore()
            //비교할 샘플날짜
            LocalDate testDate = LocalDate.of(2020,2,2);
            boolean isAfterMethod = testDate.isAfter(date);
            boolean isBeforeMethod = testDate.isBefore(date);
            System.out.println(testDate + "(testDate)는 " + date + "(현재날짜)보다 이후의 날짜입니까? " + isAfterMethod);
            System.out.println(testDate + "(testDate)는 " + date + "(현재날짜)보다 이전의 날짜입니까? " + isBeforeMethod);

        //isLeapYear() : 윤년 판단
            boolean leapYear = date.isLeapYear();
            System.out.println(date+"는 윤년입니까? " + leapYear);

        //lengthOfMonth() : 그 달이 몇일까지 있는지 알려줌
            //현재 날짜에 해당하는 달이 몇일까지 있는지
            int lengthOfMonth = date.lengthOfMonth();
            System.out.println("현재 날짜에 해당하는 달은 몇일까지 존재? " + lengthOfMonth);

            //2024-2-20일에 해당하는 달이 몇일까지 있는지
            LocalDate sampleDate = LocalDate.of(2024,2,20);
            int lengthOfMonth2 = sampleDate.lengthOfMonth();
            System.out.println(sampleDate+ " 에 해당하는 달은 몇일까지 존재? " +lengthOfMonth2);

            //현재 날짜에 해당하는 연도는 총 몇일인지 (평년:365일 / 윤년:366일)
            int lengthOfYear = date.lengthOfYear();
            System.out.println("올해는 총 몇일입니까? " + lengthOfYear);

        //minus - minusDays, minusMonth, minusWeeks, minusYears
            LocalDate threeDaysAgo = date.minusDays(3);
            LocalDate twoMonthsAgo = date.minusMonths(2);
            LocalDate sixWeeksAgo= date.minusWeeks(6);
            LocalDate fiveYearsAgo = date.minusYears(5);
            System.out.println("오늘로부터 3일 전은 " + threeDaysAgo);
            System.out.println("오늘로부터 2달 전은 " + twoMonthsAgo);
            System.out.println("오늘로부터 6주 전은 " + sixWeeksAgo);
            System.out.println("오늘로부터 5년 전은 " + fiveYearsAgo);


        //plus - plusDays, plusMonth, plusWeeks, plusYears
            LocalDate threeDaysAfter = date.plusDays(3);
            LocalDate twoMonthsAfter = date.plusMonths(2);
            LocalDate sixWeeksAfter= date.plusWeeks(6);
            LocalDate fiveYearsAfter = date.plusYears(5);
            System.out.println("오늘로부터 3일 후는 " + threeDaysAfter);
            System.out.println("오늘로부터 2달 후는 " + twoMonthsAfter);
            System.out.println("오늘로부터 6주 후는 " + sixWeeksAfter);
            System.out.println("오늘로부터 5년 후은 " + fiveYearsAfter);

        //parse : 문자열을 날짜 형식으로 변환
            LocalDate parseDate3 = LocalDate.parse("2023-01-03");
            System.out.println(parseDate3);



        //range : 해당 날짜에 유효한 값의 범위출력(연/월/일의 범위 등)
            //현재날짜에 해당하는 월에 며칠까지 있는지 출력
            ValueRange dateRange = date.range(ChronoField.DAY_OF_MONTH);
            System.out.println(dateRange);




    }
}
