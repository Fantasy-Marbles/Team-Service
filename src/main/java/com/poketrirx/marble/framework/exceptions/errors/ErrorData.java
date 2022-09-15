package com.poketrirx.marble.framework.exceptions.errors;

import com.google.common.collect.ImmutableMap;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Singular;
import lombok.ToString;

@ToString
@EqualsAndHashCode
@AllArgsConstructor(access = AccessLevel.PROTECTED)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Builder(toBuilder = true)
public class ErrorData {
    @Builder.Default
    @NonNull
    @Getter
    private final String title = "";

    @Builder.Default
    @NonNull
    @Getter
    private final String message = "";

    @Builder.Default
    @Getter
    private final int statusCode = 0;

    @Getter
    @NonNull
    @Singular("datum")
    private ImmutableMap<String, String> data;
}
