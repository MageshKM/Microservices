package com.java8.stream.data;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Month;
import java.time.Period;
import java.time.ZoneId;
import java.time.ZonedDateTime;

public class DurationTime {

	public static void main(String args[]) {

		LocalDate date1 = LocalDate.now();

		LocalDate date2 = LocalDate.of(2014, Month.DECEMBER, 12);

		Period gap = Period.between(date2, date1);
		System.out.println("gap between dates " + "is a period of " + gap.getDays());

		LocalTime time1 = LocalTime.now();
		System.out.println("the current time is " + time1);

		Duration fiveHours = Duration.ofHours(5);

		// adding five hours to the current
		// time and storing it in time2
		LocalTime time2 = time1.plus(fiveHours);

		System.out.println("after adding five hours " + "of duration " + time2);

		Duration gap1 = Duration.between(time2, time1);
		System.out.println("duration gap between time1" + " & time2 is " + gap1);
		
		LocalTime l1 = LocalTime.now();
		Duration d = Duration.ofHours(5);
		LocalTime l2 = l1.plus(d);
		Duration d2 = Duration.between(l1, l2);
		
		System.out.println(d2.toHours() +":"+d2.toMinutesPart()+":"+d2.toSecondsPart());
		
		ZonedDateTime zoneTime = ZonedDateTime.now();
		
		ZoneId zone = ZoneId.of("Asia/Tokyo");
		ZonedDateTime zdt = zoneTime.withZoneSameInstant(zone);
		
		System.out.println("Asia/tokyo time now :"+zdt.now());
		
	}
}
