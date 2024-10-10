package com.jskno.mobile.lines.entity.base;

import com.jskno.mobile.lines.entity.listener.InsertableEntityListener;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import jakarta.validation.constraints.NotNull;
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
@EntityListeners(InsertableEntityListener.class)
public class InsertableEntity {

    @NotNull
    private OffsetDateTime createdAt;
}
