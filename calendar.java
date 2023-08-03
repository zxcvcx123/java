/* 자바 달력 관련 or 날짜 */

    /* 달력 구하기 */
		Date now = new Date();
		Calendar cal = Calendar.getInstance();
		cal.setTime(now);
		
		/* 현재년도 */
		int year = cal.get(Calendar.YEAR); 
		/* 현재 월 */
		int month = cal.get(Calendar.MONTH) + 1; //0부터 시작하기 때문에 1더해준다
		/* 현재 일 */
		int day = cal.get(Calendar.DAY_OF_MONTH);
		/* 현재 시간 */
		int hour = cal.get(Calendar.HOUR_OF_DAY);
		/* 현재 분 */
		int min = cal.get(Calendar.MINUTE);
		/* 현재 초 */
		int sec = cal.get(Calendar.SECOND);
		System.out.println(year + "년도 " + month + "월 " + day + "일 " + hour + "시 " + min + "분 " + sec + "초");

/* 내가 변형한거 */
/* 달력 구하기 */
		Date now = new Date();
		Calendar cal = Calendar.getInstance();
		cal.setTime(now);
		
		
		/* 현재년도 */
		int year = cal.get(Calendar.YEAR ); 
		
		/* 현재 월 */
		/* ?Month값 없는 즉 null 인경우 현재 월로 변수 선언   */
		/* 12월 넘어가면 년도 증가 / 1월 내려가면 년도 차감 */
		if(Month == null) {
			Month = cal.get(Calendar.MONTH) + 1;
		} else if (Month > 12) {
			Month = 1;
			Year = Year +1;
			year = Year;
		} else if (Month == 0) {
			Month = 12;
			Year = Year -1;
			year = Year;
		}
		
		int month = cal.get(Calendar.MONTH) + 1;
		/* Month의 값이 들어오는대로 month 변수의 넣어주기  */
		
		if(month > 0 && month > Month) { 
			month = Month;
			year = Year;
		} else if(month < Month) { 
			month = Month; 
			year = Year;
		}
		 
		
		/* 현재 일 */
		int day = cal.get(Calendar.DAY_OF_MONTH);
		/* 현재 월의 시작일 / 마지막 일 */
		int startDay = cal.getActualMinimum(Calendar.DAY_OF_MONTH);
	    int endDay = cal.getActualMaximum(Calendar.DAY_OF_MONTH);
		
		/* 현재 월의 시작 요일 / 일:1, 월:2, 화:3 .. */
	    cal.set(year, month - 1, 1);
	    int startDate = cal.get(Calendar.DAY_OF_WEEK);
	    
	    System.out.println("@@@@@@ 년도: " + year);
	    System.out.println("@@@@@@ 월: " + month);
		System.out.println("@@@@@@@ 시작일: " + startDay);
		System.out.println("@@@@@@@ 마지막 일: " + endDay);
		System.out.println("@@@@@@@ 시작 요일: " + startDate);
		
		/* 타임리프로 테이블에 뿌려줘야 하기위한 사전 작업 */
		List<List<Integer>> weeks = new ArrayList<>();
        List<Integer> week = new ArrayList<>();
        for (int i = 1; i < startDate; i++) {
            week.add(0); // 비어있는 셀은 0으로 표시
        }

        for (int i = 1; i <= endDay; i++) {
            week.add(i);
            if (week.size() == 7) {
                weeks.add(week);
                week = new ArrayList<>();
            }
        }

        if (!week.isEmpty()) {
            while (week.size() < 7) {
                week.add(0);
            }
            weeks.add(week);
        }

/* html view */
 <table class="candle_Table_Start_Day" id="candle_Table_Start_Day">
	        <!-- 주 단위 반복문 -->
	        <tr th:each="week : ${weeks}">
	            <!-- 각 주의 일자 출력 -->
	            <td th:each="day : ${week}">
	                <a th:id="${year} +''+ ${month} +''+ ${day}" 
	                	th:href="@{'reservation?Month=' + ${month} + '&&Year=' + ${year} + '&&id=' + ${year} + ${month} + ${day}}" 
	                	th:if="${day != 0}" 
	                	th:text="${day}">
	                </a>
	             </td>
	        </tr>
    	</table>
