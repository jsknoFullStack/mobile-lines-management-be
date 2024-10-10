package com.jskno.mobile.lines.entity.listener;

import com.jskno.mobile.lines.entity.base.InsertableEntity;
import jakarta.persistence.PrePersist;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;

public class InsertableEntityListener {

    @PrePersist
    public void onCreate(final InsertableEntity entity) {
        entity.setCreatedAt(OffsetDateTime.now(ZoneOffset.UTC));
    }

}
