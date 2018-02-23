package org.vstoynev.voila;

import javax.validation.Validator;

public abstract class Assertions {

	public static RootAssertions using(Validator validator) {
		return new RootAssertions(validator);
	}
}