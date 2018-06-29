package org.vstoynev.viola.junit4.rule;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.mockito.Mockito.mock;

import javax.validation.Validator;

import org.junit.ClassRule;
import org.junit.Test;

public class AbstractValidatorRuleTests {

	private static final Validator MOCK_VALIDATOR = mock(Validator.class);

	@ClassRule
	public static ValidatorRule rule = new MockValidatorRule();
	
	@Test
	public void throwsExceptionWhenMisused() {
		MockValidatorRule rule = new MockValidatorRule();
		assertThatExceptionOfType(IllegalStateException.class).isThrownBy(() -> rule.getValidator())
						.withMessage("validator is not yet initialized!");
	}

	@Test
	public void initializesValidator() {
		assertThat(rule.getValidator()).isNotNull().isSameAs(MOCK_VALIDATOR);
	}

	private static class MockValidatorRule extends AbstractValidatorRule {

		@Override
		protected Validator initializeValidator() {
			return MOCK_VALIDATOR;
		}
		
	}
}
