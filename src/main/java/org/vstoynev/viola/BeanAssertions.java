package org.vstoynev.viola;

public interface BeanAssertions {

	<T> void assertNoViolationsFor(T bean, Class<?>... groups);

	<T> ViolationAssertions<T> assertSingleViolationFor(T bean, Class<?>... groups);
}