package org.vstoynev.viola.error;

import java.util.ArrayList;
import java.util.List;

public abstract class AssertionErrors {

	private static final String BASE_PACKAGE = "org.vstoynev.viola";

	public static void throwWithMessage(String message) {
		AssertionError error = new AssertionError(message);
		cleanUpStackTrace(error);

		throw error;
	}

	private static void cleanUpStackTrace(AssertionError error) {
		StackTraceElement[] stackTrace = error.getStackTrace();

		List<StackTraceElement> elements = new ArrayList<>(stackTrace.length);

		for (int i = 0; i < stackTrace.length; i++) {
			StackTraceElement element = stackTrace[i];

			if (!element.getClassName().startsWith(BASE_PACKAGE)) {
				elements.add(element);
			}
		}

		stackTrace = elements.toArray(new StackTraceElement[elements.size()]);
		error.setStackTrace(stackTrace);
	}
}