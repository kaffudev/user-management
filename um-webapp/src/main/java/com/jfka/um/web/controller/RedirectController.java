package com.jfka.um.web.controller;

import com.jfka.um.util.UmMappings;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping(method = RequestMethod.GET)
public class RedirectController {

    public RedirectController() {
        super();
    }

    @RequestMapping(value = UmMappings.Singular.PRIVILEGE)
    public ResponseEntity<Void> privilegeToPrivileges(final HttpServletRequest request) {
        return singularToPlural(request);
    }

    @RequestMapping(value = UmMappings.Singular.ROLE)
    public ResponseEntity<Void> roleToRoles(final HttpServletRequest request) {
        return singularToPlural(request);
    }

    @RequestMapping(value = UmMappings.Singular.USER)
    public ResponseEntity<Void> userToUsers(final HttpServletRequest request) {
        return singularToPlural(request);
    }

    // util

    private final ResponseEntity<Void> singularToPlural(final HttpServletRequest request) {
        final String correctUri = request.getRequestURL()
                .toString() + "s";
        final HttpHeaders responseHeaders = new org.springframework.http.HttpHeaders();
        responseHeaders.add(HttpHeaders.LOCATION, correctUri);

        final ResponseEntity<Void> redirectResponse = new ResponseEntity<>(responseHeaders, HttpStatus.MOVED_PERMANENTLY);
        return redirectResponse;
    }
}
