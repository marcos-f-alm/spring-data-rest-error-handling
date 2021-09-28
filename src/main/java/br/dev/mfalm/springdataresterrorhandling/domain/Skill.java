package br.dev.mfalm.springdataresterrorhandling.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Skill {
    @Id
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
