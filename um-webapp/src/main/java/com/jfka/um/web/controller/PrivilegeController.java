package com.jfka.um.web.controller;

import com.jfka.common.persistence.service.IRawService;
import com.jfka.common.web.controller.AbstractController;
import com.jfka.common.web.controller.ISortingController;
import com.jfka.um.persistence.model.Privilege;
import com.jfka.um.service.IPrivilegeService;
import com.jfka.um.util.UmMappings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping(value = UmMappings.PRIVILEGES)
public class PrivilegeController extends AbstractController<Privilege> implements ISortingController<Privilege> {

    private IPrivilegeService service;

    @Autowired
    public PrivilegeController(IPrivilegeService service) {
        this.service = service;
    }

    @Override
    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public List<Privilege> findAll(final HttpServletRequest request) {
        return findAllInternal(request);
    }

    // find - one

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ResponseBody
    public Privilege findOne(@PathVariable("id") final Long id) {
        return findOneInternal(id);
    }

    // create

    @RequestMapping(method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public void create(@RequestBody final Privilege resource) {
        createInternal(resource);
    }

    // update

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    @ResponseStatus(HttpStatus.OK)
    public void update(@PathVariable("id") final Long id, @RequestBody final Privilege resource) {
        updateInternal(id, resource);
    }

    // delete

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable("id") final Long id) {
        deleteByIdInternal(id);
    }

    @Override
    public List<Privilege> findAllPaginatedAndSorted(int page, int size, String sortBy, String sortOrder) {
        return null;
    }

    @Override
    public List<Privilege> findAllPaginated(int page, int size) {
        return null;
    }

    @Override
    public List<Privilege> findAllSorted(String sortBy, String sortOrder) {
        return null;
    }

    @Override
    protected IRawService<Privilege> getService() {
        return service;
    }
}
