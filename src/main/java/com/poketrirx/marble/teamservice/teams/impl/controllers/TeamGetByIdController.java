package com.poketrirx.marble.teamservice.teams.impl.controllers;

import java.util.Objects;

import com.codahale.metrics.annotation.Timed;
import io.astefanutti.metrics.aspectj.Metrics;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.poketrirx.marble.framework.exceptions.InvalidPathParameterException;
import com.poketrirx.marble.teamservice.teams.pub.models.Team;
import com.poketrirx.marble.teamservice.teams.pub.services.TeamGetByIdService;

@Metrics
@Log4j2
@Component
@RestController
public class TeamGetByIdController {
    private final TeamGetByIdService service;

    @Autowired
    public TeamGetByIdController(TeamGetByIdService service) {
    	this.service = Objects.requireNonNull(service);
    }
  
    @Timed(name = "TeamGetByIdController.execute")
    @GetMapping("/v1/teams/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Team execute(@PathVariable String id) {
        validate(id);

        log.info("Fetching team[{}]", id);

      	return service.get(id);
    }

    private static void validate(String id) {
        if (id == null) {
            log.info("Skipping fetch for team because the path id is invalid");

            throw new InvalidPathParameterException("id", "Id parameter is required");
        }
    }
}