package com.demo2do.core.cache;

import org.springframework.cglib.core.ReflectUtils;
import org.springframework.expression.EvaluationContext;
import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;

import java.beans.PropertyDescriptor;
import java.util.HashSet;
import java.util.Set;

/**
 * Cache accessor of a java bean
 */
public class CompositeCacheAccessor implements CacheAccessor {

    private ExpressionParser expressionParser = new SpelExpressionParser();

    private Set<String> keys;

    private EvaluationContext evaluationContext;

    /**
     * Generate evaluationContext and available keys by setting cacheRoot
     *
     * @param cacheRoot
     */
    public void setCacheRoot(Object cacheRoot) {
        this.evaluationContext = new StandardEvaluationContext(cacheRoot);
        this.keys = this.generateKeys(cacheRoot.getClass());
    }

    /**
     * populate keys according to all the getter functions from cacheRootClass
     *
     * @param cacheRootClass
     * @return
     */
    protected Set<String> generateKeys(Class<?> cacheRootClass) {
        PropertyDescriptor[] propertyDescriptors = ReflectUtils.getBeanGetters(cacheRootClass);
        Set<String> keys = new HashSet<String>(propertyDescriptors.length);

        for(PropertyDescriptor propertyDescriptor : propertyDescriptors) {
            keys.add(propertyDescriptor.getName());
        }

        return keys;
    }

    /**
     * whether key in the cache
     *
     * @param key
     * @return
     */
    public boolean contains(String key) {
        return keys.contains(key);
    }

    /**
     * evaluate key in the cache
     *
     * @param key
     * @return
     */
    public Object evaluate(String key) {
        try {
            Expression expression = this.expressionParser.parseExpression(key);
            return expression.getValue(evaluationContext);
        } catch(Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
