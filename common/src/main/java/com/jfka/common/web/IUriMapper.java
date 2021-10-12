package com.jfka.common.web;

import com.jfka.common.persistence.model.IEntity;

public interface IUriMapper {

    <T extends IEntity> String getUriBase(final Class<T> clazz);

}
