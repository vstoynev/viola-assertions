package org.vstoynev.viola.junit4;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;

public class AbstractJUnit4ViolaDefaultValidatorTestsTests extends AbstractJUnit4ViolaDefaultValidatorTests {

	@Test
	public void validatorRuleIsInitialized() {
		assertThat(validatorRule).isNotNull();
		assertThat(validatorRule.getValidator()).isNotNull();
	}
}