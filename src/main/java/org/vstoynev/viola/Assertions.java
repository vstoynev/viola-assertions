package org.vstoynev.viola;

import javax.validation.Validator;

import org.vstoynev.viola.junit4.rules.ValidatorRule;

public abstract class Assertions {

	public static BeanAssertions using(ValidatorRule validatorRule) {
		return using(validatorRule.getValidator());
	}

	public static BeanAssertions using(Validator validator) {
		return new DefaultBeanAssertions(validator);
	}
}