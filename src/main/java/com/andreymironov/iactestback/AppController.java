package com.andreymironov.iactestback;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

@Slf4j
@CrossOrigin
@Controller
public class AppController {
    @PostMapping(value = "/postdir")
    public @ResponseBody Dir postDir(
            @RequestParam(name = "path", required = true) String path
    ) {
        log.debug(String.format("%s::postDir(path: %s)", this.getClass().getName(), path));
        Path pathToDir = Paths.get(path);
        try {
            Files.walk(pathToDir, 1).forEach(p -> {
                log.debug(p.toString());
            });
            Dir dir = null;
            return dir;
        } catch (NoSuchFileException e) {
            throw new NoSuchDirException("No such directory");
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    @GetMapping(value = "/dirs")
    public @ResponseBody
    List<Dir> getDirs() {
        log.debug(String.format("%s::getDirs()", this.getClass().getName()));
        return null;
    }
}