package br.dev.mfalm.springdataresterrorhandling.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.util.List;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Developer {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
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
    private List<Skill> skills;

}
