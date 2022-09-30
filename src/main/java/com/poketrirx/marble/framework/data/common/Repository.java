package com.poketrirx.marble.framework.data.common;

import com.google.common.collect.ImmutableList;

/**
 * An interface that abstracts repository operations for Users.
 */
public interface Repository<T> {
    ImmutableList<T> get(ImmutableList<Criterion> criteria, ImmutableList<Hint> hints);

    void delete(ImmutableList<Criterion> criteria, ImmutableList<Hint> hints);

    T update(T user);

    T create(T user);
}