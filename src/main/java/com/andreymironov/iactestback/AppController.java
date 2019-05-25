package com.andreymironov.iactestback;

import com.andreymironov.iactestback.data.Dir;
import com.andreymironov.iactestback.data.DirRepository;
import com.andreymironov.iactestback.data.SubDir;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;

@Slf4j
@CrossOrigin
@Controller
public class AppController {
	private static String HOME = System.getProperty("user.home");

	@Autowired private DirRepository dirRepository;

    @PostMapping(value = "/postdir")
    public @ResponseBody
    Dir postDir(
            @RequestParam(name = "dirpath", required = true) String dirPath
    ) {
        log.debug(String.format("%s::postDir(dirPath: %s)", this.getClass().getName(), dirPath));
        Path path = Paths.get(dirPath);
        Dir dir = new Dir(LocalDateTime.now(), dirPath);
        try {
            Files.walk(path, 1).forEach(
                subPath -> {
                    if (!subPath.equals(path)) {
                        SubDir subDir = new SubDir(subPath.getFileName().toString());
                        if (Files.isRegularFile(subPath)) {
                            try {
                                subDir.setSize(Files.size(subPath));
                            } catch (IOException e) {
                                log.error(String.format("IO exception while getting size of file %s", subPath));
                                e.printStackTrace();
                            }
                        }
                        dir.addFile(subDir);
                    }
                }
            );
            return dirRepository.save(dir);
        } catch (NoSuchFileException e) {
            throw new NoSuchDirException(String.format("No such directory %s", dirPath));
        } catch (IOException e) {
            e.printStackTrace();
            throw new UnknownIOException(String.format("IO exception while walking through the path %s", path));
        }
    }

    @GetMapping(value = "/dirs")
    public @ResponseBody
    Iterable<Dir> getDirs() {
        log.debug(String.format("%s::getDirs()", this.getClass().getName()));
        return dirRepository.findAll();
    }

    @GetMapping(value = "/home")
    public @ResponseBody
    String getHome() {
        return HOME;
    }
}