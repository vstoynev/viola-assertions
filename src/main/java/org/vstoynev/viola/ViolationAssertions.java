package org.vstoynev.viola;

import javax.validation.ConstraintViolation;

public class ViolationAssertions<T> {

	private final ConstraintViolation<T> violation;

	public ViolationAssertions(ConstraintViolation<T> violation) {
		this.violation = violation;
	}
}