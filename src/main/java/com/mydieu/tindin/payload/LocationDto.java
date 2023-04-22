package com.mydieu.tindin.payload;

import java.io.Serializable;

/**
 * A DTO for the {@link com.mydieu.tindin.models.Location} entity
 */
public record LocationDto(
        String district,
        String province
) implements Serializable {
}