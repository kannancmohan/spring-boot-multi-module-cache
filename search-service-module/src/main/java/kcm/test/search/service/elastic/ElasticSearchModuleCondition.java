package kcm.test.search.service.elastic;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;

public class ElasticSearchModuleCondition implements Condition {
    @Override
    public boolean matches(ConditionContext conditionContext, AnnotatedTypeMetadata annotatedTypeMetadata) {
        String property = conditionContext.getEnvironment().getProperty("search.connector");
        if ("elastic".equalsIgnoreCase(property)) {
            System.out.println(">>>Elastic module enabled");
            return true;
        }
        return false;
    }
}
