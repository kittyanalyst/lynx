package com.innovatis.lynx.platform.mapping;

import org.apache.commons.lang3.time.DateFormatUtils;
import org.modelmapper.AbstractConverter;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * Created by Ramakrishna Chalasani 02/10/2017.
 */
@Component
public class MapperFacadeImpl implements MapperFacade, ApplicationContextAware {

    private ApplicationContext applicationContext;

    private ModelMapper modelMapper;

    public MapperFacadeImpl() {
        this.modelMapper = new ModelMapper();

        //date to string
        this.modelMapper.addConverter(new AbstractConverter<Date, String>() {
            @Override
            protected String convert(Date source) {
                String dateStr = source == null ? "" : DateFormatUtils.format(source, DateFormatUtils.ISO_DATETIME_TIME_ZONE_FORMAT.getPattern());
                return dateStr;
            }
        });
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
        this.addMappings();
    }

    private void addMappings() {
        Map<String, MappingConfigurable> mappingConfigurables = applicationContext.getBeansOfType(MappingConfigurable.class);
        for (MappingConfigurable mappingConfigurable : mappingConfigurables.values()) {
            modelMapper.addMappings(mappingConfigurable.configure());
        }
    }

    @Override
    public <S, D> D map(S sourceObject, Class<D> destinationClass) {
        return modelMapper.map(sourceObject, destinationClass);
    }

    @Override
    public <S, D> void map(final S sourceObject, final D destinationObject) {
        modelMapper.map(sourceObject, destinationObject);
    }

    @Override
    public <S, D> List<D> mapAsList(Iterable<S> source, Class<D> destinationClass) {
        return modelMapper.map(source, new TypeToken<List<D>>() {}.getType());
    }

}
