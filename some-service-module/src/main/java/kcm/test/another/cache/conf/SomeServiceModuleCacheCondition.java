package kcm.test.another.cache.conf;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;

public class SomeServiceModuleCacheCondition implements Condition {
    public boolean matches(ConditionContext conditionContext, AnnotatedTypeMetadata annotatedTypeMetadata) {
        String property = conditionContext.getEnvironment().getProperty("another.cache.enabled");
        boolean isEnabled = Boolean.parseBoolean(property);
        if (isEnabled) {
            System.out.println(">>>Another Caching module enabled");
        }
        return isEnabled;
    }
}
