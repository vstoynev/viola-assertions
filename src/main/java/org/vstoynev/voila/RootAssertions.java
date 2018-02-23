package org.vstoynev.voila;

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;

import org.junit.Assert;

public class RootAssertions {

	private final Validator validator;

	public RootAssertions(Validator validator) {
		this.validator = validator;
	}

	public <T> void assertNoViolationsFor(T bean, Class<?>... groups) {
		Set<ConstraintViolation<T>> violations = validator.validate(bean, groups);

		Assert.assertTrue(violations.isEmpty());
	}

	public <T> ViolationAssertions<T> assertSingleViolationFor(T bean, Class<?>... groups) {
		Set<ConstraintViolation<T>> violations = validator.validate(bean, groups);

		Assert.assertTrue(violations.size() == 1);

		return new ViolationAssertions<>(violations.iterator().next());
	}
}