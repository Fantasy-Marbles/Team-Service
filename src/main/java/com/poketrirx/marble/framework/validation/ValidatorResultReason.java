package com.poketrirx.marble.framework.validation;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NonNull;
import lombok.ToString;

/**
 * A pojo that describes if an atomic field of a resource is valid or not.
 */
@Builder(toBuilder = true)
@ToString
@EqualsAndHashCode
public final class ValidatorResultReason {
    /**
     * Defines if the validation determined that data was valid.
     */
    @Getter
    private final boolean isValid;

    /**
     * The name of the field that was validated.
     */
    @NonNull
    @Getter
    private final String fieldName;

    /**
     * The reason the field was determined to be valid or invalid.
     */
    @Getter
    private final String reason;
}
