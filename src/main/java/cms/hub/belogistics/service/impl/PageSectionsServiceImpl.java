package cms.hub.belogistics.service.impl;

import cms.hub.belogistics.common.exception.ResourceNotFoundException;
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
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

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
                    .orElseThrow(() -> new ResourceNotFoundException("Page not found with id: " + request.getPageId()));
            pageSections.setPages(pages);
        }

        PageSections saved = pageSectionsRepository.save(pageSections);
        return mapper.toResponse(saved);
    }

    @Override
    @Transactional
    public PageSectionsResponse update(Long id, PageSectionsRequest request) {
        PageSections existing = pageSectionsRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("PageSection not found with id: " + id));

        existing.setTitle(request.getTitle());
        existing.setDescription(request.getDescription());
        existing.setImages(request.getImages());
        existing.setSortIndex(request.getSortIndex());
        existing.setActive(request.getActive());

        if (request.getPageId() != null) {
            Pages pages = pagesRepository.findById(request.getPageId())
                    .orElseThrow(() -> new ResourceNotFoundException("Page not found with id: " + request.getPageId()));
            existing.setPages(pages);
        }

        PageSections saved = pageSectionsRepository.save(existing);
        return mapper.toResponse(saved);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        if (!pageSectionsRepository.existsById(id)) {
            throw new ResourceNotFoundException("PageSection not found with id: " + id);
        }
        pageSectionsRepository.deleteById(id);
    }

    @Override
    public List<PageSectionsResponse> getByPageId(Long pageId) {
        List<PageSections> sections = pageSectionsRepository.findByPagesIdOrderBySortIndexAsc(pageId);
        return sections.stream()
                .map(mapper::toResponse)
                .collect(Collectors.toList());
    }
}
