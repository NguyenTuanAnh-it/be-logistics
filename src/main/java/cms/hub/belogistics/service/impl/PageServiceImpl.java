package cms.hub.belogistics.service.impl;

import cms.hub.belogistics.dto.request.PagesRequest;
import cms.hub.belogistics.dto.response.PageWithSectionsResponse;
import cms.hub.belogistics.dto.response.PagesResponse;
import cms.hub.belogistics.entity.PageSections;
import cms.hub.belogistics.entity.Pages;
import cms.hub.belogistics.mapper.PagesMapper;
import cms.hub.belogistics.repository.PageSectionsRepository;
import cms.hub.belogistics.common.exception.ResourceNotFoundException;
import cms.hub.belogistics.repository.PagesRepository;
import cms.hub.belogistics.service.PageService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PageServiceImpl implements PageService {

    private final PagesRepository pagesRepository;
    private final PageSectionsRepository pageSectionsRepository;
    private final PagesMapper mapper;

    @Override
    public PagesResponse create(PagesRequest request) {
        Pages pages = pagesRepository.save(mapper.toEntity(request));
        return mapper.toResponse(pages);
    }

    @Override
    public PageWithSectionsResponse findByUrl(String url) {
        Pages page = pagesRepository.findByUrl(url);
        if (page == null) {
            throw new ResourceNotFoundException("Page not found with url: " + url);
        }
        return mapPageWithSections(page);
    }

    private PageWithSectionsResponse mapPageWithSections(Pages page) {
        List<PageSections> sections = pageSectionsRepository.findByPagesIdOrderBySortIndexAsc(page.getId());
        PageWithSectionsResponse response = mapper.toWithSectionsResponse(page);
        response.setSections(mapper.toSectionResponseList(sections));

        if (page.getParent() == null) {
            List<Pages> children = pagesRepository.findByParentIdOrderBySortIndexAsc(page.getId());
            response.setChildren(mapper.toResponseList(children));
        }

        return response;
    }

    @Override
    public PageWithSectionsResponse findById(Long id) {
        Pages page = pagesRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Page not found with id: " + id));
        return mapPageWithSections(page);
    }


}
