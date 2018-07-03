package org.vstoynev.viola.testng;

import static org.assertj.core.api.Assertions.assertThat;

import org.testng.annotations.Test;

public class AbstractTestNGViolaDefaultValidatorTestsTests extends AbstractTestNGViolaDefaultValidatorTests {

	@Test
	public void validatorIsInitialized() {
		assertThat(validator).isNotNull();
	}
}