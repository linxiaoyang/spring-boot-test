package com.shuqi;

import com.shuqi.anno.MyConditionalOnProperty;
import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;

import java.util.Map;


/**
 * @author olifer
 */
public class MyOnPropertyCondition implements Condition {

    @Override
    public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
        Map<String, Object> annotationAttributes = metadata.getAnnotationAttributes(MyConditionalOnProperty.class.getName());
        String propertyName = (String) annotationAttributes.get("value");
        String[] values = (String[]) annotationAttributes.get("havingValues");
        String propertyValue = context.getEnvironment().getProperty(propertyName);
        for (String havingValue : values) {
            if (propertyValue.equalsIgnoreCase(havingValue)) {
                return true;
            }
        }
        return false;
    }
}
