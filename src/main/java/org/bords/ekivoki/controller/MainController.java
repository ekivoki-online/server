package org.bords.ekivoki.controller;

import lombok.AllArgsConstructor;
import org.bords.ekivoki.domain.DrawResult;
import org.bords.ekivoki.service.DrawService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class MainController {

    private final DrawService drawService;

    @GetMapping()
    public String index() {
        return "index";
    }

    @GetMapping("/{diceNumber}")
    public DrawResult draw(@PathVariable int diceNumber) {
        return drawService.draw(diceNumber);
    }
}
