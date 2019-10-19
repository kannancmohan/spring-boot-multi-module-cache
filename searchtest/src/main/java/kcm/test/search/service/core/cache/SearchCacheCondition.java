package kcm.test.search.service.core.cache;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;

public class SearchCacheCondition implements Condition {
    @Override
    public boolean matches(ConditionContext conditionContext, AnnotatedTypeMetadata annotatedTypeMetadata) {
        String property = conditionContext.getEnvironment().getProperty("search.cache.enabled");
        boolean isEnabled = Boolean.parseBoolean(property);
        if (isEnabled) {
            System.out.println(">>>Search Caching module enabled");
        }
        return isEnabled;
    }
}