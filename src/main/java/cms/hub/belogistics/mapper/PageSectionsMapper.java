package cms.hub.belogistics.mapper;

import cms.hub.belogistics.dto.request.PageSectionsRequest;
import cms.hub.belogistics.dto.response.PageSectionsResponse;
import cms.hub.belogistics.entity.PageSections;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface PageSectionsMapper {

    @Mapping(target = "pages", ignore = true)
    @Mapping(target = "id", ignore = true)
    PageSections toEntity(PageSectionsRequest request);

    @Mapping(source = "pages.id", target = "pageId")
    @Mapping(source = "pages.name", target = "pageTitle")
    PageSectionsResponse toResponse(PageSections pageSections);
}
