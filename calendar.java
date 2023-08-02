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
