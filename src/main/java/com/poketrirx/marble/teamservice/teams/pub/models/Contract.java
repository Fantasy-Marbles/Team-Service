package com.poketrirx.marble.teamservice.teams.pub.models;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.ToString;

/**
 * A POJO representing a Team resource.
 */
@ToString
@EqualsAndHashCode
@AllArgsConstructor(access = AccessLevel.PROTECTED)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Builder(toBuilder = true)
public final class Contract {
    /**
     * The unique identifier of the team resource.
     */
    @Builder.Default
    @NonNull
    @Getter
    private final String marbleId = "";

    /**
     * The unique identifier of the related user resource.
     */
    @Builder.Default
    @NonNull
    @Getter
    private final String positionId = "";
}