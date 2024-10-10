package com.jskno.mobile.lines.entity;

import com.jskno.mobile.lines.entity.base.UpdatableEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import java.time.LocalDate;
import lombok.Generated;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import org.hibernate.annotations.NaturalId;

@Entity
@Table(name = "mobile_lines")
@Getter
@Setter
@NoArgsConstructor
@SuperBuilder
public class MobileLine extends UpdatableEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private String userLogin;

    @NotNull
    private String company;

    @NotBlank
    @NaturalId(mutable = true)
    @Column(unique = true)
    private String telephone;

    @NotBlank
    @NaturalId(mutable = true)
    @Column(unique = true)
    private String extension;

    private LocalDate registrationDate;

    private LocalDate cancellationDate;

    @Column(columnDefinition = "text")
    private String notes;

    private String rate;

}
