package org.skalka.groupme4j.model;

import org.junit.Test;

import com.openpojo.reflection.filters.FilterPackageInfo;
import com.openpojo.validation.Validator;
import com.openpojo.validation.ValidatorBuilder;
import com.openpojo.validation.rule.impl.GetterMustExistRule;
import com.openpojo.validation.rule.impl.SetterMustExistRule;
import com.openpojo.validation.test.impl.GetterTester;
import com.openpojo.validation.test.impl.SetterTester;

public class PojoTest {

    // Test all packages inside of model.*
    private static final String POJO_PACKAGE = "org.skalka.groupme4j.model.";

    Validator validator = ValidatorBuilder.create()
            // Add Rules to validate structure for pojoPackage
            // See com.openpojo.validation.rule.impl for more ...
            .with(new GetterMustExistRule())
            .with(new SetterMustExistRule())
            // Add Testers to validate behaviour for pojoPackage
            // See com.openpojo.validation.test.impl for more ...
            .with(new SetterTester())
            .with(new GetterTester())
            .build();

    @Test
    public void testPojoStructureAndBehavior() {
        validator.validateRecursively(POJO_PACKAGE, new FilterPackageInfo());
    }
}
