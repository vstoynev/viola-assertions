package org.vstoynev.viola;

import java.lang.annotation.Annotation;

public interface ViolationAssertions<T> {

	ViolationAssertions<T> withMessage(String expected);

	void asResultOfTypeHavingConstraint(Class<? extends Annotation> expectedAnnotationType);
}