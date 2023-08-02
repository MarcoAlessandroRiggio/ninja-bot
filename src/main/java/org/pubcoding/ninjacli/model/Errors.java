package org.pubcoding.ninjacli.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Errors {
    FILE_NOT_FOUND(1),
    MALFORMED_CONFIGURATION(2);

    private final Integer code;

}
