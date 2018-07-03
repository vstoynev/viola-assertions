package org.vstoynev.viola;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.constraints.NotBlank;

import org.junit.BeforeClass;
import org.junit.Test;

public class DefaultViolationAssertionsTests {

	public static Validator validator = null;

	@BeforeClass
	public static void setUpClass() {
		validator = Validation.buildDefaultValidatorFactory().getValidator();
	}

	@Test
	public void withMessagePasses() {
		MockBean bean = new MockBean();
		Set<ConstraintViolation<MockBean>> constraintViolations = validator.validate(bean);

		DefaultViolationAssertions<MockBean> assertions = new DefaultViolationAssertions<>(constraintViolations.iterator().next());

		ViolationAssertions<MockBean> returnedAssertions = assertions.withMessage("must not be blank");
		assertThat(returnedAssertions).isNotNull().isSameAs(assertions);
	}

	@Test
	public void withMessageThrowsError() {
		MockBean bean = new MockBean();
		Set<ConstraintViolation<MockBean>> constraintViolations = validator.validate(bean);

		DefaultViolationAssertions<MockBean> assertions = new DefaultViolationAssertions<>(constraintViolations.iterator().next());

		assertThatExceptionOfType(AssertionError.class).isThrownBy(() -> assertions.withMessage("not matching message")).withMessage(
						"Expected violation with message <not matching message> but the actual message is <must not be blank>");
	}

	private static class MockBean {

		@NotBlank
		private String string = null;

		private Integer integer = null;

		public void setString(String string) {
			this.string = string;
		}

		public void setInteger(Integer integer) {
			this.integer = integer;
		}
	}
}