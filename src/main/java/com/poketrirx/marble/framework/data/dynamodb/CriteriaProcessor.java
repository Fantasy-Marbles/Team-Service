package com.poketrirx.marble.framework.data.dynamodb;

import com.amazonaws.services.dynamodbv2.document.spec.QuerySpec;
import com.google.common.collect.ImmutableList;
import lombok.Builder;
import lombok.NonNull;
import lombok.Singular;

import com.poketrirx.marble.framework.data.common.Criterion;
import com.poketrirx.marble.framework.exceptions.BadRequestException;

@Builder
public final class CriteriaProcessor {
    @Singular
    @NonNull
    private final ImmutableList<CriterionHandler> handlers;

    public void process(ImmutableList<Criterion> criteria, QuerySpec querySpec) {
        for (Criterion criterion : criteria) {
            boolean isHandled = false;

            for (CriterionHandler handler: handlers) {
                if (handler.canHandle(criterion)) {
                    isHandled = true;

                    handler.handle(criterion, querySpec);

                    break;
                }
            }

            if (!isHandled) {
                throw new BadRequestException("Could not process criteria");
            }
        }
    }
}
