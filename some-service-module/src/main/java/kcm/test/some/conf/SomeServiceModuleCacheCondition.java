package kcm.test.some.conf;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;

public class SomeServiceModuleCacheCondition implements Condition {
    public boolean matches(ConditionContext conditionContext, AnnotatedTypeMetadata annotatedTypeMetadata) {
        String property = conditionContext.getEnvironment().getProperty("some.service.module.cache.enabled");
        boolean isEnabled = Boolean.parseBoolean(property);
        if (isEnabled) {
            System.out.println(">>>SomeService cache enabled");
        }
        return isEnabled;
    }
}
