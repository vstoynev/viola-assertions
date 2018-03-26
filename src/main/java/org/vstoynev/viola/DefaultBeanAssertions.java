package org.vstoynev.viola;

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;

class DefaultBeanAssertions implements BeanAssertions {

	private final Validator validator;

	public DefaultBeanAssertions(Validator validator) {
		this.validator = validator;
	}

	@Override
	public <T> void assertNoViolationsFor(T bean, Class<?>... groups) {
		Set<ConstraintViolation<T>> violations = validator.validate(bean, groups);

		if ((violations != null) && !violations.isEmpty()) {
			throw new AssertionError("Expected no violations but actual count is " + violations.size());
		}
	}

	@Override
	public <T> ViolationAssertions<T> assertSingleViolationFor(T bean, Class<?>... groups) {
		Set<ConstraintViolation<T>> violations = validator.validate(bean, groups);

		int violationsCount = (violations == null) ? 0 : violations.size();
		if (violationsCount != 1) {
			throw new AssertionError("Expected single violations but actual count is " + violationsCount);
		}

		return new DefaultViolationAssertions<>(violations.iterator().next());
	}
}