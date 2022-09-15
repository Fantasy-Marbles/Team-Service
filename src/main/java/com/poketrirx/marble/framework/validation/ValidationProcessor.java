package com.poketrirx.marble.framework.validation;

import com.google.common.collect.ImmutableList;
import com.poketrirx.marble.framework.validation.Validator;
import com.poketrirx.marble.framework.validation.ValidatorResultReason;
import com.poketrirx.marble.framework.validation.ValidatorResult;
import lombok.Builder;
import lombok.NonNull;
import lombok.Singular;

/**
 * A class that'll process a collection of Validators on a single resource to determine if an entity is valid.
 * @param <TEntity> The type of resource to validate.
 */
@Builder
public class ValidationProcessor<TEntity> {
    /**
     * A collection of validators that will process atomic validations that composed together will validate an entity resource.
     */
    @NonNull
    @Singular
    private final ImmutableList<Validator<TEntity>> validators;

    /**
     * Fully validate a resource. If the resource is invalid an InvalidResourceException will be thrown.
     * @param entity The resource to validate.
     */
    public void validate(TEntity entity) {
        ValidatorResult result = getValidationResults(entity);

        if (!result.isValid()) {
            throw result.getException();
        }
    }

    /**
     * Fetches validation results for a resource. No exception is thrown, but the results will be returned.
     * @param entity The resource to validate.
     * @return The validation results as a ValidatorResult instance.
     */
    public ValidatorResult getValidationResults(TEntity entity) {
        ValidatorResult.ValidatorResultBuilder builder = ValidatorResult.builder();

        for(Validator<TEntity> validator : validators) {
            ValidatorResultReason reason = validator.isValid(entity);

            if (!reason.isValid()) {
                builder.reason(reason);
            }
        }

        return builder.build();
    }
}
