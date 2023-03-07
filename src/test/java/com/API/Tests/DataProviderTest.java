package com.API.Tests;

import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;

public final class DataProviderTest {

	public DataProviderTest() {	}
	
	@Test
	public void dbTest() {
		for(int i=0 ;i<10; i++) {
			System.out.println("username");
			Assertions.assertThat(true).isEqualTo(false);
		}
	}
}
