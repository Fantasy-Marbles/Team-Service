package com.poketrirx.marble.teamservice.teams.pub.models;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.ToString;

import java.time.OffsetDateTime;

/**
 * A POJO representing a Team resource.
 */
@ToString
@EqualsAndHashCode
@AllArgsConstructor(access = AccessLevel.PROTECTED)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Builder(toBuilder = true)
public final class Assignment {
    /**
     * The unique identifier of the related marble resource.
     */
    @DynamoDBAttribute
    @Builder.Default
    @NonNull
    @Getter
    private final String marbleId = "";

    /**
     * The unique identifier of the related position resource.
     */
    @DynamoDBAttribute
    @Builder.Default
    @NonNull
    @Getter
    private final String positionId = "";

    /**
     * The time this assignment takes effect.
     */
    @DynamoDBAttribute
    @Builder.Default
    @NonNull
    @Getter
    private final OffsetDateTime effectiveAt = OffsetDateTime.MIN;
}