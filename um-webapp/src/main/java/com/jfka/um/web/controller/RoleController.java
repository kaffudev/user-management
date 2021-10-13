package com.jfka.um.web.controller;

import com.jfka.common.persistence.service.IRawService;
import com.jfka.common.web.controller.AbstractController;
import com.jfka.common.web.controller.ISortingController;
import com.jfka.um.persistence.model.Role;
import com.jfka.um.service.IRoleService;
import com.jfka.um.utils.UmMappings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping(value = UmMappings.ROLES)
public class RoleController extends AbstractController<Role> implements ISortingController<Role> {

    private IRoleService service;

    @Autowired
    public RoleController(IRoleService service) {
        this.service = service;
    }

    @Override
    public List<Role> findAllPaginatedAndSorted(int page, int size, String sortBy, String sortOrder) {
        return null;
    }

    @Override
    public List<Role> findAllPaginated(int page, int size) {
        return null;
    }

    @Override
    public List<Role> findAllSorted(String sortBy, String sortOrder) {
        return null;
    }

    @Override
    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public List<Role> findAll(final HttpServletRequest request) {
        return findAllInternal(request);
    }

    // find - one

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ResponseBody
    public Role findOne(@PathVariable("id") final Long id) {
        return findOneInternal(id);
    }

    // create

    @RequestMapping(method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public void create(@RequestBody final Role resource) {
        createInternal(resource);
    }

    // update

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    @ResponseStatus(HttpStatus.OK)
    public void update(@PathVariable("id") final Long id, @RequestBody final Role resource) {
        updateInternal(id, resource);
    }

    // delete

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable("id") final Long id) {
        deleteByIdInternal(id);
    }


    @Override
    protected IRawService<Role> getService() {
        return service;
    }
}
