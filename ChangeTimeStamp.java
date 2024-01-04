public class ChangeTimeStamp {
    
    // ~초,분,시간,일,달,년 전으로 변환
    public static String getAgo(LocalDateTime a) {

        if (a == null) {
            return "";
        }

        // 서울 시간
        LocalDateTime b = LocalDateTime.now(ZoneId.of("Asia/Seoul"));

        if (a.isBefore(b.minusYears(1))) {
            Period between = Period.between(a.toLocalDate(), b.toLocalDate());
            return between.get(ChronoUnit.YEARS) + "년 전";
        } else if (a.isBefore(b.minusMonths(1))) {
            Period between = Period.between(a.toLocalDate(), b.toLocalDate());
            return between.get(ChronoUnit.MONTHS) + "달 전";
        } else if (a.isBefore(b.minusDays(1))) {
            Period between = Period.between(a.toLocalDate(), b.toLocalDate());
            return between.get(ChronoUnit.DAYS) + "일 전";
        } else if (a.isBefore(b.minusHours(1))) {
            Duration between = Duration.between(a, b);
            return (between.getSeconds() / 60 / 60) + "시간 전";
        } else if (a.isBefore(b.minusMinutes(1))) {
            Duration between = Duration.between(a, b);
            return (between.getSeconds() / 60) + "분 전";
        } else {
            Duration between = Duration.between(a, b);
            return between.getSeconds() + "초 전";
        }
    }

    // 날짜만 출력 시간표시 x
    public static String withOutTime(LocalDateTime a) {

        LocalDateTime justTime = a.withHour(0).withMinute(0).withSecond(0).withNano(0);
        return justTime.format(DateTimeFormatter.ISO_LOCAL_DATE);

    }

    // 초, 분, 시간 제거
    public static Integer voteTime(LocalDateTime a) {

        if (a == null) {
            return 0;
        }
        // 서울 시간
        LocalDateTime b = LocalDateTime.now(ZoneId.of("Asia/Seoul"));

        if (a.isBefore(b.minusDays(1))) {
            Period between = Period.between(a.toLocalDate(), b.toLocalDate());
            return (int) between.get(ChronoUnit.DAYS);

        }

        return 1;
    }
}
