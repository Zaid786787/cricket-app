package io.cricket.controller;

import io.cricket.domain.Cricket;
import io.cricket.service.CricketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CricketController {

    private CricketService cricketService;

    @Autowired
    public CricketController(CricketService cricketService) {
        this.cricketService = cricketService;
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @RequestMapping(method = RequestMethod.GET, value = "/cricket/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Cricket findOne(@PathVariable("id") Integer id) {
        return cricketService.findOne(id);
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @RequestMapping(method = RequestMethod.GET, value = "/cricket", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Cricket> findAll() {
        return cricketService.findAll();
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @RequestMapping(method = RequestMethod.POST, value = "/cricket", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public Cricket create(@RequestBody Cricket cricket) {
        return cricketService.create(cricket);
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @RequestMapping(method = RequestMethod.PUT, value = "/cricket/{id}", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public Cricket update(@PathVariable("id") Integer id, @RequestBody Cricket cricket) {
        return cricketService.update(id, cricket);
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @RequestMapping(method = RequestMethod.DELETE, value = "/cricket/{id}")
    public void delete(@PathVariable("id") Integer id) {
        cricketService.delete(id);
    }
}
