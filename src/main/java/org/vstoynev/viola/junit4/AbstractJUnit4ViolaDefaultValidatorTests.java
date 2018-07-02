package org.vstoynev.viola.junit4;

import org.junit.ClassRule;
import org.vstoynev.viola.Assertions;
import org.vstoynev.viola.BeanAssertions;
import org.vstoynev.viola.ViolationAssertions;
import org.vstoynev.viola.junit4.rule.DefaultValidatorRule;
import org.vstoynev.viola.junit4.rule.ValidatorRule;

public abstract class AbstractJUnit4ViolaDefaultValidatorTests implements BeanAssertions {

	@ClassRule
	public static ValidatorRule validatorRule = new DefaultValidatorRule();

	@Override
	public <T> void assertNoViolationsFor(T bean, Class<?>... groups) {
		Assertions.using(validatorRule).assertNoViolationsFor(bean, groups);
	}

	@Override
	public <T> ViolationAssertions<T> assertSingleViolationFor(T bean, Class<?>... groups) {
		return Assertions.using(validatorRule).assertSingleViolationFor(bean, groups);
	}
}