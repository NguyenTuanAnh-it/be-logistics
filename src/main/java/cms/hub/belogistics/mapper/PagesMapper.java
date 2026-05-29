package cms.hub.belogistics.mapper;

import cms.hub.belogistics.dto.request.PagesRequest;
import cms.hub.belogistics.dto.response.PageSectionsResponse;
import cms.hub.belogistics.dto.response.PageWithSectionsResponse;
import cms.hub.belogistics.dto.response.PagesResponse;
import cms.hub.belogistics.entity.PageSections;
import cms.hub.belogistics.entity.Pages;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PagesMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "active", ignore = true)
    @Mapping(target = "parent", ignore = true)
    Pages toEntity(PagesRequest request);

    @Mapping(source = "parent.id", target = "parentId")
    PagesResponse toResponse(Pages pages);

    @Mapping(source = "parent.id", target = "parentId")
    PageWithSectionsResponse toWithSectionsResponse(Pages pages);

    @Mapping(source = "pages.id", target = "pageId")
    @Mapping(source = "pages.name", target = "pageTitle")
    PageSectionsResponse toSectionResponse(PageSections section);

    List<PageSectionsResponse> toSectionResponseList(List<PageSections> sections);

    List<PagesResponse> toResponseList(List<Pages> pages);
}
