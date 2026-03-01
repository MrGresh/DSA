class Solution {
    public String dayOfTheWeek(int day, int month, int year) {
        Map<Integer, Integer> months = new HashMap<>();
        months.put(1, 31);
        months.put(3, 31);
        months.put(4, 30);
        months.put(5, 31);
        months.put(6, 30);
        months.put(7, 31);
        months.put(8, 31);
        months.put(9, 30);
        months.put(10, 31);
        months.put(11, 30);
        months.put(12, 31);
        Map<Integer, String> weekDays = new HashMap<>();
        weekDays.put(0, "Thursday");
        weekDays.put(1, "Friday");
        weekDays.put(2, "Saturday");
        weekDays.put(3, "Sunday");
        weekDays.put(4, "Monday");
        weekDays.put(5, "Tuesday");
        weekDays.put(6, "Wednesday");

        int daysInYears = 0;
        for(int i=1971;i<year;i++) {
            daysInYears += isLeapYear(i) ? 366 : 365;
        }
        int daysInMonths = 0;
        for(int i=1;i<month;i++) {
            if(i==2) daysInMonths += isLeapYear(year) ? 29 : 28;
            else daysInMonths += months.get(i);
        }
        int totalDays = daysInYears + daysInMonths + day;
        return weekDays.get(totalDays%7);
    }
    boolean isLeapYear(int i) {
        return (i%400==0 || (i%4==0 && i%100!=0));
    }
}
