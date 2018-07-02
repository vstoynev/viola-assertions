package org.vstoynev.viola;

import java.lang.annotation.Annotation;

public interface PropertyAssertions<T> {

	void havingConstraint(Class<? extends Annotation> expectedAnnotationType);
}