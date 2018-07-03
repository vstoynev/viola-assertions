package org.vstoynev.viola;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class DefaultBeanAssertionsTests {

	public static Validator validator = null;

	private DefaultBeanAssertions assertions = null;

	@BeforeClass
	public static void setUpClass() {
		validator = Validation.buildDefaultValidatorFactory().getValidator();
	}

	@Before
	public void setUp() {
		assertions = new DefaultBeanAssertions(validator);
	}

	@Test
	public void assertNoViolationsForPasses() {
		assertions.assertNoViolationsFor(mockBeanWithNoViolations());
	}

	@Test
	public void assertNoViolationsForThrowsError() {
		assertThatExceptionOfType(AssertionError.class).isThrownBy(() -> assertions.assertNoViolationsFor(mockBeanWithMultipleViolations()))
						.withMessage("Expected no violations but actual count is 2");
	}

	@Test
	public void assertSingleViolationForPasses() {
		ViolationAssertions<MockBean> violationAssertions = assertions.assertSingleViolationFor(mockBeanWithSingleViolation());
		assertThat(violationAssertions).isNotNull().isExactlyInstanceOf(DefaultViolationAssertions.class);
	}

	@Test
	public void assertSingleViolationForThrowsError() {
		assertThatExceptionOfType(AssertionError.class).isThrownBy(() -> assertions.assertSingleViolationFor(mockBeanWithNoViolations()))
						.withMessage("Expected single violations but actual count is 0");

		assertThatExceptionOfType(AssertionError.class)
						.isThrownBy(() -> assertions.assertSingleViolationFor(mockBeanWithMultipleViolations()))
						.withMessage("Expected single violations but actual count is 2");
	}

	private MockBean mockBeanWithNoViolations() {
		MockBean bean = new MockBean();
		bean.setString("valid string");
		bean.setInteger(100);

		return bean;
	}

	private MockBean mockBeanWithSingleViolation() {
		MockBean bean = new MockBean();
		bean.setString(null);
		bean.setInteger(100);

		return bean;
	}

	private MockBean mockBeanWithMultipleViolations() {
		MockBean bean = new MockBean();
		bean.setString(null);
		bean.setInteger(0);

		return bean;
	}

	private static class MockBean {

		@NotBlank
		private String string = null;

		@Min(10)
		private Integer integer = null;

		public void setString(String string) {
			this.string = string;
		}

		public void setInteger(Integer integer) {
			this.integer = integer;
		}
	}
}