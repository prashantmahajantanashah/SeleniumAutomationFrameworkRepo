package com.prashant.tests;

import org.assertj.core.api.Assertions;
import org.joda.time.LocalDate;
import org.testng.annotations.Test;

public class DateTimeAssertion {
	
	@Test
	public void dateTime() {
		
		LocalDate date = new LocalDate(2000,1,2);
		
		Assertions.assertThat(date)
		.as("date needs to be increased").isLessThan(new LocalDate(1984,1,3));
		
		
	
	}

}
