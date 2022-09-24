package com.poketrirx.marble.teamservice.teams.pub.services;

import com.google.common.collect.ImmutableList;

import com.poketrirx.marble.framework.data.common.Criterion;
import com.poketrirx.marble.framework.data.common.Hint;
import com.poketrirx.marble.teamservice.teams.pub.models.Team;

/**
 * An interface that abstract the logic for fetching all teams.
 */
public interface TeamSearchService {
    /**
     * Fetches all teams.
     * @return A list containing all teams.
     */
    ImmutableList<Team> get(ImmutableList<Criterion> criteria, ImmutableList<Hint> hints);
}