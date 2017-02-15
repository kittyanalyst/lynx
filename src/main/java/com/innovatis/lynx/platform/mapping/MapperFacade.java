package com.innovatis.lynx.platform.mapping;

import java.util.List;

/**
 * Created by Ramakrishna Chalasani 02/10/2017.
 */
public interface MapperFacade {

    <S, D> D map(S sourceObject, Class<D> destinationClass);
    <S, D> void map(S sourceObject, D destinationObject);
    <S, D> List<D> mapAsList(Iterable<S> source, Class<D> destinationClass);
}
