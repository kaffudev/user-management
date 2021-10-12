package com.jfka.common.persistence.service;

import com.jfka.common.interfaces.IByNameApi;
import com.jfka.common.interfaces.IWithName;

public interface IService<T extends IWithName> extends IRawService<T>, IByNameApi<T> {

    //

}
