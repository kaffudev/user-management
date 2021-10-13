package com.jfka.um.web.controller;

import com.jfka.common.persistence.service.IRawService;
import com.jfka.common.web.controller.AbstractController;
import com.jfka.common.web.controller.ISortingController;
import com.jfka.um.persistence.model.User;
import com.jfka.um.service.IUserService;
import com.jfka.um.util.UmMappings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping(value = UmMappings.USERS)
public class UserController extends AbstractController<User> implements ISortingController<User> {

    private IUserService service;

    @Autowired
    public UserController(IUserService service) {
        this.service = service;
    }

    @Override
    public List<User> findAllPaginatedAndSorted(int page, int size, String sortBy, String sortOrder) {
        return null;
    }

    @Override
    public List<User> findAllPaginated(int page, int size) {
        return null;
    }

    @Override
    public List<User> findAllSorted(String sortBy, String sortOrder) {
        return null;
    }

    @Override
    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public List<User> findAll(HttpServletRequest request) {
        return findAllInternal(request);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ResponseBody
    public User findOne(@PathVariable("id") final Long id) {
        return findOneInternal(id);
    }

    @RequestMapping(method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public void create(@RequestBody final User user) {
        createInternal(user);
    }

    @RequestMapping(method = RequestMethod.PUT)
    @ResponseStatus(HttpStatus.OK)
    public void update(@PathVariable("id") final Long id, @RequestBody final User user) {
        updateInternal(id, user);
    }

    @RequestMapping(method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable("id") final Long id) {
        deleteByIdInternal(id);
    }


    @Override
    protected IRawService<User> getService() {
        return service;
    }


}
