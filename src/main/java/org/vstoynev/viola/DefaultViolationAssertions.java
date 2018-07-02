package org.vstoynev.viola;

import java.lang.annotation.Annotation;

import javax.validation.ConstraintViolation;

public class DefaultViolationAssertions<T> implements ViolationAssertions<T> {

	private final ConstraintViolation<T> violation;

	public DefaultViolationAssertions(ConstraintViolation<T> violation) {
		this.violation = violation;
	}

	@Override
	public ViolationAssertions<T> withMessage(String expected) {
		String actual = violation.getMessage();

		if (!actual.equals(expected)) {
			throw new AssertionError("Expected violation with message <" + expected + "> but the actual message is <" + actual + ">");
		}

		return this;
	}

	@Override
	public void asResultOfTypeHavingConstraint(Class<? extends Annotation> expectedAnnotationType) {
		String propertyPath = violation.getPropertyPath().toString();
		Annotation annotation = violation.getConstraintDescriptor().getAnnotation();

		if (!propertyPath.isEmpty() || !expectedAnnotationType.isInstance(annotation)) {
			throw new AssertionError("Expected violation as result of " + violation.getRootBeanClass().getCanonicalName()
							+ " having constraint of type " + expectedAnnotationType.getCanonicalName() + " but the actual reason is: "
							+ propertyPath + " having constraint of type + " + annotation.getClass().getCanonicalName());
		}
	}

	@Override
	public PropertyAssertions<T> asResultOfPropertyWithPath(String expectedPath) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PropertyValueAssertions<T> asResultOfValueOfPropertyWithPath(String expectedPath) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PropertyAssertions<T> asResultOfElementsOfListWithPath(String expectedPath) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CollectionAssertions<T> asResultOfCollectionWithPath(String expectedPath) {
		// TODO Auto-generated method stub
		return null;
	}
}