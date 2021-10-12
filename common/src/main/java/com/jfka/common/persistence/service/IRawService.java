package com.jfka.common.persistence.service;

import com.jfka.common.interfaces.IOperations;
import com.jfka.common.interfaces.IWithName;
import org.springframework.data.domain.Page;

public interface IRawService<T extends IWithName> extends IOperations<T> {

    Page<T> findAllPaginatedAndSortedRaw(final int page, final int size, final String sortBy, final String sortOrder);

    Page<T> findAllPaginatedRaw(final int page, final int size);

}
