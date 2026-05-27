package cms.hub.belogistics.service;

import cms.hub.belogistics.dto.request.PagesRequest;
import cms.hub.belogistics.dto.response.PageWithSectionsResponse;
import cms.hub.belogistics.dto.response.PagesResponse;

public interface PageService {
    PagesResponse create(PagesRequest request);
    PageWithSectionsResponse findById(Long id);
    PageWithSectionsResponse findByUrl(String url);
}
