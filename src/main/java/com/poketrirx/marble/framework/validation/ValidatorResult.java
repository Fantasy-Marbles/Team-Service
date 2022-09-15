package com.poketrirx.marble.framework.validation;

import com.google.common.collect.ImmutableList;
import com.poketrirx.marble.framework.exceptions.InvalidResourceException;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.NonNull;
import lombok.Singular;
import lombok.ToString;

/**
 * A pojo that describes if a resource is valid or invalid.
 */
@Builder(toBuilder = true)
@ToString
@EqualsAndHashCode
public final class ValidatorResult {
    /**
     * A collection of validation data that was determined in the validation process.
     */
    @NonNull
    @Singular
    private final ImmutableList<ValidatorResultReason> reasons;

    /**
     * Checks if the passed in data was valid.
     * @return true, if the data is valid.
     */
    public boolean isValid() {
        return reasons.size() == 0;
    }

    /**
     * Fetches an InvalidResourceException to describe why the data was invalid.
     * @return An InvalidResourceException that describes why teh data was invalid.
     */
    public InvalidResourceException getException() {
        return new InvalidResourceException("");
    }
}
