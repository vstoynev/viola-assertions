package org.vstoynev.viola.junit4.rule;

import javax.validation.Validator;

import org.junit.runner.Description;
import org.junit.runners.model.Statement;

public abstract class AbstractValidatorRule implements ValidatorRule {

	private Validator validator = null;

	@Override
	public final Statement apply(Statement base, Description description) {
		return new Statement() {

			@Override
			public void evaluate() throws Throwable {
				validator = initializeValidator();

				base.evaluate();
			}
		};
	}

	protected abstract Validator initializeValidator();

	public final Validator getValidator() {
		if (validator == null) {
			throw new IllegalStateException("validator is not yet initialized!");
		}

		return validator;
	}
}