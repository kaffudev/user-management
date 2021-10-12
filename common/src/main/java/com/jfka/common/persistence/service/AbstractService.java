package com.jfka.common.persistence.service;

import com.jfka.common.persistence.model.INameableEntity;

public abstract class AbstractService<T extends INameableEntity> extends AbstractRawService<T> implements IService<T> {

    public AbstractService() {
        super();
    }

    // API

}
