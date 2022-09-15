package com.poketrirx.marble.framework.data.dynamodb;

import com.amazonaws.services.dynamodbv2.document.spec.QuerySpec;
import com.poketrirx.marble.framework.data.common.Criterion;

public interface CriterionHandler {
    boolean canHandle(Criterion criterion);

    void handle(Criterion criterion, QuerySpec querySpec);
}
