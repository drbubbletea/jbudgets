package com.jbudgets.widget;

import com.jbudgets.widget.adapter.WidgetPurpose;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.AnnotatedBeanDefinition;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ClassPathScanningCandidateComponentProvider;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.type.filter.AnnotationTypeFilter;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Configuration
public class WidgetAdapterConfiguration {

    private static final Logger LOG = LoggerFactory.getLogger(WidgetAdapterConfiguration.class);

    @Bean
    public AdapterTargets targets() {
        ClassPathScanningCandidateComponentProvider provider = new ClassPathScanningCandidateComponentProvider(false);
        provider.addIncludeFilter(new AnnotationTypeFilter(WidgetFor.class));

        Set<BeanDefinition> beanDefs = provider.findCandidateComponents("com.jbudgets");
        for (BeanDefinition bd : beanDefs) {
            if (bd instanceof AnnotatedBeanDefinition) {
                Map<String, Object> annotAttributeMap = ((AnnotatedBeanDefinition) bd)
                        .getMetadata()
                        .getAnnotationAttributes(WidgetFor.class.getCanonicalName());
                Class<?> forClass = (Class) annotAttributeMap.get("forClass");
                WidgetPurpose purpoes = (WidgetPurpose) annotAttributeMap.get("purpose");
                LOG.info("Found widget {} for class {}", bd.getBeanClassName(), forClass.getName());
            }
        }
        return new AdapterTargets();
    }
}
