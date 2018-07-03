package org.vstoynev.viola.error;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

import org.junit.Test;

public class AssertionErrorsTests {

	@Test
	public void throwWithMessageCleansUpStackTrace() {
		assertThatExceptionOfType(AssertionError.class).isThrownBy(() -> AssertionErrors.throwWithMessage("asd")).satisfies(error -> {
			assertThat(error.getStackTrace()).isNotNull().isNotEmpty().allSatisfy(
							stackTraceElement -> assertThat(stackTraceElement.getClassName()).doesNotStartWith("org.vstoynev.viola"));
		});
	}
}