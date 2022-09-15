package com.poketrirx.marble.teamservice.teams.impl.controllers;

import java.util.Objects;

import com.codahale.metrics.annotation.Timed;
import com.google.common.collect.ImmutableList;
import io.astefanutti.metrics.aspectj.Metrics;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.poketrirx.marble.framework.data.common.Criterion;
import com.poketrirx.marble.framework.data.common.Hint;
import com.poketrirx.marble.framework.exceptions.InvalidRequestParameterException;
import com.poketrirx.marble.teamservice.teams.pub.models.Team;
import com.poketrirx.marble.teamservice.teams.pub.services.TeamSearchService;

@Metrics
@Log4j2
@Component
@RestController
public class TeamSearchController {
    private final TeamSearchService service;

    @Autowired
    public TeamSearchController(TeamSearchService service) {
    	this.service = Objects.requireNonNull(service);
    }

    @Timed(name = "TeamSearchController.execute")
    @GetMapping("/v1/teams")
    @ResponseStatus(HttpStatus.OK)
    public ImmutableList<Team> execute(
            @RequestParam ImmutableList<Criterion> criteria,
            @RequestParam ImmutableList<Hint> hints
    ) {
        validate(criteria, hints);

        log.info("Fetching all teams");

      	return service.get(criteria, hints);
    }

    private static void validate(ImmutableList<Criterion> criteria, ImmutableList<Hint> hints) {
        if (criteria == null) {
            log.info("Skipping search because the criteria are invalid");

            throw new InvalidRequestParameterException("Criteria are missing and are required.");
        }

        if (hints == null) {
            log.info("Skipping search because the hints are invalid");

            throw new InvalidRequestParameterException("Hints are missing and are required.");
        }
    }
}