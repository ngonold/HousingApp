package com.niit.housing.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.core.convert.converter.Converter;
import org.springframework.core.convert.support.ConfigurableConversionService;
import org.springframework.stereotype.Component;

import java.util.Set;

@Component
public class ConverterConfig {
    private final Set<Converter<?,?>> converters;
    private final ConfigurableConversionService configurableConversionService;

    @Autowired
    public ConverterConfig(Set<Converter<?,?>> converters, ConfigurableConversionService configurableConversionService){
        this.configurableConversionService = configurableConversionService;
        this.converters = converters;
    }
    @EventListener(ContextRefreshedEvent.class)
    public void addConverters() {
        converters.forEach(configurableConversionService::addConverter);
    }
}
