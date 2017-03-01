package ua.dp.dmma.configuration.condition;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;

/**
 * @author Dmytro Mazan
 */
public class MemoryCondition implements Condition {
    @Override
    public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
        String storageType = context.getEnvironment().getRequiredProperty("data.storage.type");
        return storageType != null && storageType.equals("memory");
    }
}
