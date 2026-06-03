package cms.hub.belogistics.service.impl;

import cms.hub.belogistics.common.enums.Type;
import cms.hub.belogistics.dto.request.PageSectionsRequest;
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
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PageServiceImpl implements PageService {

    private final PagesRepository pagesRepository;
    private final PageSectionsRepository pageSectionsRepository;
    private final PagesMapper mapper;

    @Override
    @Transactional
    public PagesResponse create(PagesRequest request) {
        Pages pages = mapper.toEntity(request);

        // Set parent nếu có parentId
        if (request.getParentId() != null) {
            Pages parent = pagesRepository.findById(request.getParentId())
                    .orElseThrow(() -> new ResourceNotFoundException("Parent page not found with id: " + request.getParentId()));
            pages.setParent(parent);
        }

        pages = pagesRepository.save(pages);

        // Tạo sections nếu có
        if (request.getSections() != null && !request.getSections().isEmpty()) {
            for (PageSectionsRequest sectionReq : request.getSections()) {
                PageSections section = new PageSections();
                section.setPages(pages);
                section.setTitle(sectionReq.getTitle());
                section.setDescription(sectionReq.getDescription());
                section.setImages(sectionReq.getImages());
                section.setSortIndex(sectionReq.getSortIndex());
                section.setActive(sectionReq.getActive() != null ? sectionReq.getActive() : true);
                pageSectionsRepository.save(section);
            }
        }

        return mapper.toResponse(pages);
    }

    @Override
    @Transactional
    public PagesResponse update(Long id, PagesRequest request) {
        Pages existing = pagesRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Page not found with id: " + id));

        existing.setName(request.getName());
        existing.setUrl(request.getUrl());
        existing.setShortDescription(request.getShortDescription());
        existing.setImage(request.getImage());
        existing.setDescription(request.getDescription());
        existing.setContent(request.getContent());
        existing.setOtherOptions(request.getOtherOptions());
        existing.setSortIndex(request.getSortIndex());
        existing.setType(request.getType());

        // Set parent nếu có parentId
        if (request.getParentId() != null) {
            Pages parent = pagesRepository.findById(request.getParentId())
                    .orElseThrow(() -> new ResourceNotFoundException("Parent page not found with id: " + request.getParentId()));
            existing.setParent(parent);
        } else {
            existing.setParent(null);
        }

        Pages saved = pagesRepository.save(existing);

        // Đồng bộ sections: xóa cũ + tạo mới
        if (request.getSections() != null) {
            List<PageSections> oldSections = pageSectionsRepository.findByPagesIdOrderBySortIndexAsc(id);
            pageSectionsRepository.deleteAll(oldSections);

            for (PageSectionsRequest sectionReq : request.getSections()) {
                PageSections section = new PageSections();
                section.setPages(saved);
                section.setTitle(sectionReq.getTitle());
                section.setDescription(sectionReq.getDescription());
                section.setImages(sectionReq.getImages());
                section.setSortIndex(sectionReq.getSortIndex());
                section.setActive(sectionReq.getActive() != null ? sectionReq.getActive() : true);
                pageSectionsRepository.save(section);
            }
        }

        return mapper.toResponse(saved);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        if (!pagesRepository.existsById(id)) {
            throw new ResourceNotFoundException("Page not found with id: " + id);
        }
        // Xóa tất cả sections trước
        List<PageSections> sections = pageSectionsRepository.findByPagesIdOrderBySortIndexAsc(id);
        pageSectionsRepository.deleteAll(sections);
        pagesRepository.deleteById(id);
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

    @Override
    public List<PagesResponse> findAll() {
        List<Pages> pages = pagesRepository.findAll();
        return mapper.toResponseList(pages);
    }

    @Override
    public List<PagesResponse> findByType(Type type) {
        List<Pages> pages = pagesRepository.findByType(type);
        return mapper.toResponseList(pages);
    }
}
