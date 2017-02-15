package com.innovatis.lynx.platform.mapping;

import org.modelmapper.PropertyMap;

/**
 * Created by Ramakrishna Chalasani 02/10/2017.
 */
public interface MappingConfigurable<D, T> {
    PropertyMap<D, T> configure();
}
