package com.tofattobat.tinyurl;

import com.tofattobat.tinyurl.dto.LinkCreateDto;
import com.tofattobat.tinyurl.dto.LinkDto;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.security.PublicKey;
import java.util.Optional;

@Service
public class LinkService {
    private final LinkRepository linkRepository;


    public LinkService(LinkRepository linkRepository) {
        this.linkRepository = linkRepository;
    }

    @Transactional
    public LinkDto shortenLink(LinkCreateDto link) {
        String randomeId;
        do {
            randomeId = UUIDRandomIdGenerator.genereteId();
        }while (linkRepository.existsById(randomeId));
        Link newLink = new Link(randomeId, link.getName(), link.getTargetUrl());
        Link savedLink = linkRepository.save(newLink);
        return LinkDtoMapper.map(savedLink);
    }
    @Transactional
    public Optional<LinkDto> incrementVisitsById(String id) {
        Optional<Link> link = linkRepository.findById(id);
        link.ifPresent(l -> l.setVisits(l.getVisits() + 1));
        return link.map(LinkDtoMapper::map);
    }
    public Optional<LinkDto> findLinkById(String id) {
        return linkRepository.findById(id)
                .map(LinkDtoMapper::map);
    }
}
