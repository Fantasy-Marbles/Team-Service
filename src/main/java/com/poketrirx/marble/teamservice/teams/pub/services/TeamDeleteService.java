package com.poketrirx.marble.teamservice.teams.pub.services;

/**
 * An interface that abstract the logic for deleting a user.
 */
public interface TeamDeleteService {
    /**
     * Deletes a user by the user's id.
     * @param id The id of the user to delete.
     */
    void delete(String id);
}