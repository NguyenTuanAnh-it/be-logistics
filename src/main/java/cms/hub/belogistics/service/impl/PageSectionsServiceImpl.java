package cms.hub.belogistics.service.impl;

import cms.hub.belogistics.dto.request.PageSectionsRequest;
import cms.hub.belogistics.dto.response.PageSectionsResponse;
import cms.hub.belogistics.entity.PageSections;
import cms.hub.belogistics.entity.Pages;
import cms.hub.belogistics.mapper.PageSectionsMapper;
import cms.hub.belogistics.repository.PageSectionsRepository;
import cms.hub.belogistics.repository.PagesRepository;
import cms.hub.belogistics.service.PageSectionsService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PageSectionsServiceImpl implements PageSectionsService {

    private final PageSectionsRepository pageSectionsRepository;
    private final PagesRepository pagesRepository;
    private final PageSectionsMapper mapper;

    @Override
    public PageSectionsResponse create(PageSectionsRequest request) {
        PageSections pageSections = mapper.toEntity(request);

        if (request.getPageId() != null) {
            Pages pages = pagesRepository.findById(request.getPageId())
                    .orElseThrow(() -> new RuntimeException("Page not found with id: " + request.getPageId()));
            pageSections.setPages(pages);
        }

        PageSections saved = pageSectionsRepository.save(pageSections);
        return mapper.toResponse(saved);
    }
}
