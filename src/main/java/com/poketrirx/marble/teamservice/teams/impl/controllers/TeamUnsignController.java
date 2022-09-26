package com.poketrirx.marble.teamservice.teams.impl.controllers;

import com.codahale.metrics.annotation.Timed;
import io.astefanutti.metrics.aspectj.Metrics;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import com.poketrirx.marble.framework.exceptions.InvalidPathParameterException;
import com.poketrirx.marble.teamservice.teams.pub.models.Team;

@Metrics
@Log4j2
@Component
@RestController
public class TeamUnsignController {
    @Timed(name = "TeamUpdateController.execute")
    @PostMapping("/v1/teams/{teamId}/_unsign/{marbleId}")
    @ResponseStatus(HttpStatus.OK)
    public Team execute(@PathVariable String teamId, @PathVariable String marbleId) {
        validate(teamId, marbleId);

        log.info("Unsigning marble[{}] from team[{}]", marbleId, teamId);

        return null;
    }

    private static void validate(String teamId, String marbleId) {
        if (teamId == null) {
            log.info("Skipping signing for team because the path teamId is invalid");

            throw new InvalidPathParameterException("teamId", "Team Id parameter is required");
        }

        if (marbleId == null) {
            log.info("Skipping signing for marble because the path marbleId is invalid");

            throw new InvalidPathParameterException("marbleId", "Marble Id parameter is required");
        }
    }
}