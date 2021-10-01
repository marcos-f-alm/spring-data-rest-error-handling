package br.dev.mfalm.springdataresterrorhandling.domain;

import lombok.*;
import org.springframework.data.rest.core.annotation.RestResource;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.util.List;

@Entity
@Setter
@Getter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Developer {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) @EqualsAndHashCode.Include
    private Long id;

    @Column(length=20, nullable = false)
    @Size(min = 3, message = "insufficient.size")
    @Size(max = 20, message = "maximum.size.exceeded")
    @NotEmpty(message = "compulsory.field")
    private String nickname;

    @Column(length=100, nullable = false)
    @Email(message = "invalid.field.value")
    @NotEmpty(message = "compulsory.field")
    private String email;

    private LocalDate dob;

    @ManyToMany
    @JoinTable(name = "developer_skills",
            joinColumns = @JoinColumn(name = "developer_id"),
            inverseJoinColumns = @JoinColumn(name = "skills_uuid"))
    @RestResource(exported = false)
    private List<Skill> skills;

}
