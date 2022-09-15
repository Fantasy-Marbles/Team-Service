package com.poketrirx.marble.framework.validation;

/**
 * An abstraction to process if an atomic entity of a resource is valid.
 * @param <TEntity> The resource type to operate on.
 */
public interface Validator<TEntity> {
    /**
     * Checks if an atomic concept of a resource is valid.
     * @param entity The resource to process.
     * @return A ValidatorResultReason describing if the atomic concept of the resource is valid or not.
     */
    ValidatorResultReason isValid(TEntity entity);
}
