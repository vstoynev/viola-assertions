package org.vstoynev.viola.junit4.rule;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.ClassRule;
import org.junit.Test;

public class DefaultValidatorRuleTests {

	@ClassRule
	public static ValidatorRule rule = new DefaultValidatorRule();

	@Test
	public void initializesValidator() {
		assertThat(rule.getValidator()).isNotNull();
	}
}