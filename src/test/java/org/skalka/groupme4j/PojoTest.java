package org.skalka.groupme4j; 

import com.openpojo.business.identity.IdentityFactory;
import com.openpojo.random.RandomFactory;
import com.openpojo.reflection.PojoClass;
import com.openpojo.reflection.PojoClassFilter;
import com.openpojo.reflection.impl.PojoClassFactory;
import com.openpojo.validation.Validator;
import com.openpojo.validation.ValidatorBuilder;
import com.openpojo.validation.rule.impl.GetterMustExistRule;
import com.openpojo.validation.rule.impl.SetterMustExistRule;
import com.openpojo.validation.test.Tester;
import com.openpojo.validation.test.impl.GetterTester;
import com.openpojo.validation.test.impl.SetterTester;
import com.openpojo.validation.utils.IdentityHandlerStub;

import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import org.skalka.groupme4j.model.JacksonObject;

public class PojoTest {

  // The top level package for all classes to be tested
  private String packageName = "org.skalka.groupme4j.model";
  private List<PojoClass> pojoClasses;
  private Validator validator; 

  @Before
  public void setup() {
    // Get all classes recursively under package
    pojoClasses = PojoClassFactory.getPojoClassesRecursively(packageName, new FilterClasses());

    validator = ValidatorBuilder.create()
      // Add Rules to validate structure for pojoPackage
      // See com.openpojo.validation.rule.impl for more ...
      .with(new GetterMustExistRule())
      .with(new SetterMustExistRule())
      // Add Testers to validate behaviour for pojoPackage
      // See com.openpojo.validation.test.impl for more ...
      .with(new EqualsTester())
      .with(new GetterTester())
      .with(new SetterTester())
      .with(new ToStringTester())
      .build();
  }

  @Test
  public void validate() {
    validator.validate(pojoClasses);
  }

  private static class FilterClasses implements PojoClassFilter {
    public boolean include(PojoClass pojoClass) {
      return !pojoClass.getClazz().equals(JacksonObject.class)
        && pojoClass.isConcrete();
    }
  }

  private static class ToStringTester implements Tester {

    public void run(PojoClass pojoClass) {
      Object instance = RandomFactory.getRandomValue(pojoClass.getClazz());

      IdentityHandlerStub identityHandlerStub = new IdentityHandlerStub(instance);
      identityHandlerStub.setToStringReturn(RandomFactory.getRandomValue(String.class));

      IdentityFactory.registerIdentityHandler(identityHandlerStub);

      Assert.assertNotEquals("Expected string mismatch", identityHandlerStub.getToStringReturn(), instance.toString());
    }
  }

  private static class EqualsTester implements Tester {

    public void run(PojoClass pojoClass) {
      Object instance = RandomFactory.getRandomValue(pojoClass.getClazz());
      Assert.assertEquals("Expected Equality", instance, instance);

      Object oInstance = RandomFactory.getRandomValue(pojoClass.getClazz());
      Assert.assertEquals("Expected Equality", instance, oInstance);
    }
  }
}
