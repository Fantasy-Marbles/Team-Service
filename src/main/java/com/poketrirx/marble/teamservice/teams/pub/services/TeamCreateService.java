package com.poketrirx.marble.teamservice.teams.pub.services;

import com.poketrirx.marble.teamservice.teams.pub.models.Team;

/**
 * An interface that abstract the logic for creating a user.
 */
public interface TeamCreateService {
    /**
     * Creates and persists a user from a user pojo.
     * @param entity The user pojo to create
     * @return The persisted user pojo.
     */
    Team create(Team entity);
}