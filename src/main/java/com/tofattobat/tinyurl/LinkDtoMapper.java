package com.tofattobat.tinyurl;

import com.tofattobat.tinyurl.dto.LinkDto;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

public class LinkDtoMapper {
    public static LinkDto map(Link link) {
        String redirectURL = buildRedirectUrlFromId(link.getId());
        return new LinkDto(link.getId(), link.getName(), link.getTargetURL(), redirectURL, link.getVisits());
    }

    private static String buildRedirectUrlFromId(String id) {
        return ServletUriComponentsBuilder
                .fromCurrentContextPath()
                .path("/redir/{id}")
                .buildAndExpand(id)
                .toUriString();
    }
}
