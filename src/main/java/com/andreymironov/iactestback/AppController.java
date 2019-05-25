package com.andreymironov.iactestback;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@CrossOrigin
@Controller
public class AppController {
    @PostMapping(value = "/post")
    public @ResponseBody Dir postDir(@RequestParam(name = "path", required = true) String path) {
        log.debug(
                String.format("%s::postDir(path: %s)", this.getClass().getName(), path)
        );
        return null;
    }

    @GetMapping(value = "/dirs")
    public @ResponseBody
    List<Dir> getDirs() {
        log.debug(
                String.format("%s::getDirs()", this.getClass().getName())
        );
        return null;
    }
}