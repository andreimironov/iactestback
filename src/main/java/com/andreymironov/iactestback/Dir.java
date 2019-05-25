package com.andreymironov.iactestback;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

public class Dir {
    private UUID id;
    private LocalDateTime dateTime;
    private String path;
    private List<Dir> dirs;
}
