package io.github.vinilopes1.users.model.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, length = 150)
    @NotEmpty(message = "{name.not.empty}")
    private String name;

    @Column(nullable = false, length = 100)
    @NotEmpty(message = "{email.not.empty}")
    private String email;

    @Column(length = 30)
    private String phone;

    @Column(name= "create_at", updatable = false)
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate createdAt;

    @PrePersist
    public void prePersist(){
        setCreatedAt(LocalDate.now());
    }
}
