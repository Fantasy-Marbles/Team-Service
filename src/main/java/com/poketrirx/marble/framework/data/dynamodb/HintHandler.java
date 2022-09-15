package com.poketrirx.marble.framework.data.dynamodb;

import com.amazonaws.services.dynamodbv2.document.spec.QuerySpec;
import com.poketrirx.marble.framework.data.common.Hint;

public interface HintHandler {
    boolean canHandle(Hint hint);

    void handle(Hint hint, QuerySpec querySpec);
}
