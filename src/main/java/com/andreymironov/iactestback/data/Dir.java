package com.andreymironov.iactestback.data;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Data
@Entity
@NoArgsConstructor(access = AccessLevel.PRIVATE, force = true)
@RequiredArgsConstructor
public class Dir {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @NonNull
    @Basic
    private LocalDateTime dateTime;

    @NonNull
    private String path;

    @OneToMany(
            fetch = FetchType.EAGER,
            cascade = CascadeType.ALL,
            mappedBy = "dir",
            orphanRemoval = true
    )
    private List<SubDir> subDirs = new ArrayList<>();

    public void addFile(SubDir subDir) {
        subDir.setDir(this);
        this.subDirs.add(subDir);
    }

    public void removeFile(SubDir subDir) {
        subDir.setDir(null);
        this.subDirs.remove(subDir);
    }
}
