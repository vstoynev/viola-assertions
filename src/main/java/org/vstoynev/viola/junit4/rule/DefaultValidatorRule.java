package org.vstoynev.viola.junit4.rule;

import javax.validation.Validation;
import javax.validation.Validator;

public class DefaultValidatorRule extends AbstractValidatorRule {

	@Override
	protected Validator initializeValidator() {
		return Validation.buildDefaultValidatorFactory().getValidator();
	}
}