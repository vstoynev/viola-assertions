package org.vstoynev.viola.testng;

import javax.validation.Validation;
import javax.validation.Validator;

import org.testng.annotations.BeforeClass;
import org.vstoynev.viola.Assertions;
import org.vstoynev.viola.BeanAssertions;
import org.vstoynev.viola.ViolationAssertions;

public abstract class AbstractTestNGViolaDefaultValidatorTests implements BeanAssertions {

	protected Validator validator = null;

	@BeforeClass(alwaysRun = true)
	protected void initializeValidator() throws Exception {
		validator = Validation.buildDefaultValidatorFactory().getValidator();
	}

	@Override
	public <T> void assertNoViolationsFor(T bean, Class<?>... groups) {
		Assertions.using(validator).assertNoViolationsFor(bean, groups);
	}

	@Override
	public <T> ViolationAssertions<T> assertSingleViolationFor(T bean, Class<?>... groups) {
		return Assertions.using(validator).assertSingleViolationFor(bean, groups);
	}
}