package com.poketrirx.marble.teamservice.teams.impl.controllers;

import java.util.Objects;

import com.codahale.metrics.annotation.Timed;
import io.astefanutti.metrics.aspectj.Metrics;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.poketrirx.marble.framework.exceptions.InvalidRequestBodyException;
import com.poketrirx.marble.teamservice.teams.pub.models.Team;
import com.poketrirx.marble.teamservice.teams.pub.services.TeamCreateService;

@Metrics
@Log4j2
@Component
@RestController
public class TeamCreateController {
    private final TeamCreateService service;

    @Autowired
    public TeamCreateController(TeamCreateService service) {
    	this.service = Objects.requireNonNull(service);
    }

    @Timed(name = "TeamCreateController.execute")
    @PostMapping("/v1/teams")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public Team execute(@RequestBody Team team) {
        validate(team);

        log.info("Creating a new team");

      	return service.create(team);
    }

    private static void validate(Team team) {
        if (team == null) {
            log.info("Skipping create for team because the body is invalid");

            throw new InvalidRequestBodyException("Missing team data in request body");
        }
    }
}