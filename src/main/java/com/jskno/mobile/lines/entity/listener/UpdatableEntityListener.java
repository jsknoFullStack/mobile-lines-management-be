package com.jskno.mobile.lines.entity.listener;

import com.jskno.mobile.lines.entity.base.UpdatableEntity;
import jakarta.persistence.PreUpdate;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;

public class UpdatableEntityListener extends InsertableEntityListener {

    @PreUpdate
    public void onUpdate(final UpdatableEntity entity) {
        entity.setUpdatedAt(OffsetDateTime.now(ZoneOffset.UTC));
    }

}
