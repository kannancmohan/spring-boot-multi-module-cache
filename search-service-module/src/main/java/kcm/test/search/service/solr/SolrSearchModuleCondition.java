package kcm.test.search.service.solr;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.env.Environment;
import org.springframework.core.type.AnnotatedTypeMetadata;

public class SolrSearchModuleCondition implements Condition {
    @Override
    public boolean matches(ConditionContext conditionContext, AnnotatedTypeMetadata annotatedTypeMetadata) {
        String property = conditionContext.getEnvironment().getProperty("search.connector");
        if ("solr".equalsIgnoreCase(property)) {
            System.out.println(">>>Solr module enabled");
            return true;
        }
        return false;
    }
}
