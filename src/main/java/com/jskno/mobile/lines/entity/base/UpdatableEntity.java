package com.jskno.mobile.lines.entity.base;

import com.jskno.mobile.lines.entity.listener.UpdatableEntityListener;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import java.time.OffsetDateTime;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@MappedSuperclass
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@EntityListeners(UpdatableEntityListener.class)
public class UpdatableEntity extends InsertableEntity {

    private OffsetDateTime updatedAt;
}
