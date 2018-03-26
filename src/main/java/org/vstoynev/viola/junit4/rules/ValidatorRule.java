package org.vstoynev.viola.junit4.rules;

import javax.validation.Validator;

import org.junit.rules.TestRule;

public interface ValidatorRule extends TestRule {

	Validator getValidator();
}