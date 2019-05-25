package com.andreymironov.iactestback.data;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.UUID;

@Data
@Entity
@NoArgsConstructor(access = AccessLevel.PRIVATE, force = true)
@RequiredArgsConstructor
public class SubDir {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @NonNull
    private String name;

    private Long size;

    @ManyToOne
    @JoinColumn(name = "dir_id", referencedColumnName = "id")
    @JsonIgnore
    private Dir dir;
}
