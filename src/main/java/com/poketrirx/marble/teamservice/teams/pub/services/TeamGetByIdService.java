package com.poketrirx.marble.teamservice.teams.pub.services;

import com.poketrirx.marble.teamservice.teams.pub.models.Team;

/**
 * An interface that abstract the logic for fetching a single team.
 */
public interface TeamGetByIdService {
    /**
     * Fetches a team by a team's id.
     * @param id The id of the team to fetch.
     * @return The team pojo that is referenced by the passed in id.
     */
    Team get(String id);
}