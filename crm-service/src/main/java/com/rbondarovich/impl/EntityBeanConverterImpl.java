package com.rbondarovich.impl;

import com.rbondarovich.EntityBeanConverter;
import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EntityBeanConverterImpl implements EntityBeanConverter {

    private Mapper dozerMapper;

    public EntityBeanConverterImpl() {
    }

    @Autowired
    public EntityBeanConverterImpl(Mapper dozerMapper) {
        this.dozerMapper = dozerMapper;
    }

    @Override
    public <E, B> B convertToBean(E entity, Class<B> beanClass) {
        B bean = dozerMapper.map(entity, beanClass);
        return bean;
    }

    @Override
    public <E, B> List<B> convertToBeanList(Iterable<E> entities, Class<B> beanClass) {
        List<B> beans = new ArrayList<>();

        for (E entity : entities) {
            B bean = dozerMapper.map(entity, beanClass);
            beans.add(bean);
        }

        return beans;
    }

    @Override
    public <E, B> E convertToEntity(B bean, Class<E> entityClass) {
        E entity = dozerMapper.map(bean, entityClass);

        return entity;
    }
}
