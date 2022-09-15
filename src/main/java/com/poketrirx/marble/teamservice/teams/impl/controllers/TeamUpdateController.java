package com.poketrirx.marble.teamservice.teams.impl.controllers;

import java.util.Objects;

import com.codahale.metrics.annotation.Timed;
import io.astefanutti.metrics.aspectj.Metrics;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import com.poketrirx.marble.framework.exceptions.InvalidPathParameterException;
import com.poketrirx.marble.framework.exceptions.InvalidRequestBodyException;
import com.poketrirx.marble.teamservice.teams.pub.models.Team;
import com.poketrirx.marble.teamservice.teams.pub.services.TeamUpdateService;

@Metrics
@Log4j2
@Component
@RestController
public class TeamUpdateController {
    private final TeamUpdateService service;

    @Autowired
    public TeamUpdateController(TeamUpdateService service) {
    	this.service = Objects.requireNonNull(service);
    }

    @Timed(name = "TeamUpdateController.execute")
    @PutMapping("/v1/teams/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Team execute(@RequestBody Team team, @PathVariable String id) {
        validate(team, id);

        log.info("Updating team[{}]", id);

        return service.update(team);
    }

    private static void validate(Team team, String id) {
        if (id == null) {
            log.info("Skipping update for team because the path id is invalid");

            throw new InvalidPathParameterException("id", "Id parameter is required");
        }

        if (team == null) {
            log.info("Skipping update for team[{}] because the body is invalid", id);

            throw new InvalidRequestBodyException("Missing team data in request body");
        }

        if (!id.equalsIgnoreCase(team.getId())) {
            log.info("The path parameter id[{}] doesn't match the body content's id[{}]", id, team.getId());

            throw new InvalidPathParameterException("id", "Id parameter must match id defined in the body");
        }
    }
}