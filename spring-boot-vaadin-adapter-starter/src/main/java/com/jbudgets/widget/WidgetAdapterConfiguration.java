package com.jbudgets.widget;

import com.jbudgets.widget.adapter.WidgetAdapter;
import com.jbudgets.widget.adapter.WidgetPurpose;
import com.jbudgets.widget.adapter.impl.DefaultWidgetAdapter;
import com.jbudgets.widget.impl.DefaultWidgetForCreator;
import jakarta.inject.Inject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.AnnotatedBeanDefinition;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ClassPathScanningCandidateComponentProvider;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.type.filter.AnnotationTypeFilter;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

@Configuration
public class WidgetAdapterConfiguration {

    private static final Logger LOG = LoggerFactory.getLogger(WidgetAdapterConfiguration.class);

    @Inject
    private ApplicationContext context;

    @Bean
    public WidgetAdapter targets() {
        try {
            ClassPathScanningCandidateComponentProvider provider = new ClassPathScanningCandidateComponentProvider(false);
            provider.addIncludeFilter(new AnnotationTypeFilter(WidgetFor.class));

            Map<Class<?>, Map<WidgetPurpose, WidgetForCreator>> sourcePurposeWidgetMap = new HashMap<>();

            Set<BeanDefinition> beanDefs = provider.findCandidateComponents("com.jbudgets");
            for (BeanDefinition bd : beanDefs) {
                if (bd instanceof AnnotatedBeanDefinition) {
                    Map<String, Object> annotAttributeMap = ((AnnotatedBeanDefinition) bd)
                            .getMetadata()
                            .getAnnotationAttributes(WidgetFor.class.getCanonicalName());
                    Class<?> widget = Class.forName(bd.getBeanClassName());
                    Class<?> forClass = (Class) annotAttributeMap.get("forClass");
                    WidgetPurpose purpose = (WidgetPurpose) annotAttributeMap.get("purpose");

                    LOG.info("Found widget {} for class {} with purpose {}", widget.getName(), forClass.getName(), purpose.toString());
                    sourcePurposeWidgetMap.putIfAbsent(forClass, new HashMap<>());

                    WidgetForCreator creator = new DefaultWidgetForCreator(context, widget, purpose);
                    sourcePurposeWidgetMap.get(forClass).put(purpose, creator);
                }
            }
            return new DefaultWidgetAdapter(sourcePurposeWidgetMap);
        } catch (Exception e) {
            // TODO: clean up try/catch; more specific; move
            throw new RuntimeException(e);
        }
    }

}
