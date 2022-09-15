package com.poketrirx.marble.teamservice.teams.pub.services;

import com.poketrirx.marble.teamservice.teams.pub.models.Team;

/**
 * An interface that abstract the logic for updating a single team.
 */
public interface TeamUpdateService {
    /**
     * Updates an already persisted team with data in a team pojo.
     * @param entity The data to persist for the team.
     * @return The updated and persisted data in a team pojo.
     */
    Team update(Team entity);
}