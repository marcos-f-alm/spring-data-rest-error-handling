package br.dev.mfalm.springdataresterrorhandling.domain;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
@Setter
@Getter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Skill {
    @Id @EqualsAndHashCode.Include
    @Column(name = "uuid", nullable = false)
    private String uuid;

    @Column(length=20, nullable = false)
    @Size(min = 1, message = "insufficient.size")
    @Size(max = 20, message = "maximum.size.exceeded")
    @NotEmpty(message = "compulsory.field")
    private String shortName;

    @Column(length=50, nullable = false)
    @NotEmpty(message = "compulsory.field")
    @Size(max = 50, message = "maximum.size.exceeded")
    private String name;

    @Column(columnDefinition="TEXT", nullable = false)
    @Size(max = 500, message = "maximum.size.exceeded")
    private String description;
}
