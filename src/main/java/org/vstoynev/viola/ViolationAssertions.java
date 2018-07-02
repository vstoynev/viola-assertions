package org.vstoynev.viola;

import java.lang.annotation.Annotation;

public interface ViolationAssertions<T> {

	ViolationAssertions<T> withMessage(String expected);

	void asResultOfTypeHavingConstraint(Class<? extends Annotation> expectedAnnotationType);

	PropertyAssertions<T> asResultOfPropertyWithPath(String expectedPath);

	PropertyValueAssertions<T> asResultOfValueOfPropertyWithPath(String expectedPath);

	PropertyAssertions<T> asResultOfElementsOfListWithPath(String expectedPath);

	CollectionAssertions<T> asResultOfCollectionWithPath(String expectedPath);
}