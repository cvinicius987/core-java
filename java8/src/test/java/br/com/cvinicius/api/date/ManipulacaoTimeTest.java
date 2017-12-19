package br.com.cvinicius.api.date;

import java.time.LocalTime;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import br.com.cvinicius.api.date.ManipulacaoTime;

public class ManipulacaoTimeTest {

	private ManipulacaoTime manipulationTime;
	
	@Before
	public void prepare(){
		this.manipulationTime = new ManipulacaoTime();
	}
	
	@Test
	public void sumTotalOfHoursTest(){
		
		Long total 			= 2L;
		LocalTime time 		= LocalTime.of(12, 00, 00);
		LocalTime timeTwo	= LocalTime.of(14, 00, 00);
		
		Assert.assertEquals(total, this.manipulationTime.getTotalHoras(time, timeTwo));
	}
	
	@Test
	public void parseOfTimeTest(){
		
		LocalTime time = LocalTime.of(10, 00, 00);
		
		Assert.assertEquals(time, this.manipulationTime.parseHoras("10:00:00"));
	}
}