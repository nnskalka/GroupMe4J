package org.skalka.groupme4j.response.group;

import java.util.List;

import org.junit.Test;

import com.openpojo.reflection.PojoClass;
import com.openpojo.reflection.filters.FilterPackageInfo;
import com.openpojo.reflection.impl.PojoClassFactory;
import com.openpojo.validation.Validator;
import com.openpojo.validation.ValidatorBuilder;
import com.openpojo.validation.affirm.Affirm;
import com.openpojo.validation.rule.impl.GetterMustExistRule;
import com.openpojo.validation.rule.impl.SetterMustExistRule;
import com.openpojo.validation.test.impl.GetterTester;
import com.openpojo.validation.test.impl.SetterTester;

public class DtoTest {
	  // Configured for expectation, so we know when a class gets added or removed.
	  private static final int EXPECTED_CLASS_COUNT = 6 /* Dtos */ + 1 /*for the DtoTest class */;

	  // The package to test
	  private static final String POJO_PACKAGE = "org.skalka.groupme4j.response";

	  @Test
	  public void ensureExpectedPojoCount() {
	    List <PojoClass> pojoClasses = PojoClassFactory.getPojoClasses(POJO_PACKAGE, new FilterPackageInfo());
	    Affirm.affirmEquals("Classes were added / removed;", EXPECTED_CLASS_COUNT, pojoClasses.size());
	  }

	  @Test
	  public void testPojoStructureAndBehavior() {
	    Validator validator = ValidatorBuilder.create()
	                            // Add Rules to validate structure for POJO_PACKAGE
	                            // See com.openpojo.validation.rule.impl for more ...
	                            .with(new GetterMustExistRule())
	                            .with(new SetterMustExistRule())
	                            // Add Testers to validate behaviour for POJO_PACKAGE
	                            // See com.openpojo.validation.test.impl for more ...
	                            .with(new SetterTester())
	                            .with(new GetterTester())
	                            .build();

	    validator.validate(POJO_PACKAGE, new FilterPackageInfo());
	  }
	}