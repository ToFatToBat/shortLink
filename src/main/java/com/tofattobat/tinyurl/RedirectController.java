package com.tofattobat.tinyurl;

import com.tofattobat.tinyurl.dto.LinkDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

public class RedirectController {
    private final LinkService linkService;

    public RedirectController(LinkService linkService) {
        this.linkService = linkService;
    }

    @GetMapping("/redir/{id}")
    ResponseEntity<?> redirect(@PathVariable String id) {
       return linkService.incrementVisitsById(id)
               .map(LinkDto::getTargetUrl)
               .map(targetUrl -> ResponseEntity
                       .status(HttpStatus.FOUND)
                       .build())
               .orElse(ResponseEntity.notFound().build());
    }
}
