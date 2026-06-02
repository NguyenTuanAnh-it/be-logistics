package cms.hub.belogistics.service;

import cms.hub.belogistics.dto.request.PagesRequest;
import cms.hub.belogistics.dto.response.PageWithSectionsResponse;
import cms.hub.belogistics.dto.response.PagesResponse;
import cms.hub.belogistics.common.enums.Type;

import java.util.List;

public interface PageService {
    PagesResponse create(PagesRequest request);
    PagesResponse update(Long id, PagesRequest request);
    void delete(Long id);
    PageWithSectionsResponse findById(Long id);
    PageWithSectionsResponse findByUrl(String url);
    List<PagesResponse> findAll();
    List<PagesResponse> findByType(Type type);
}
