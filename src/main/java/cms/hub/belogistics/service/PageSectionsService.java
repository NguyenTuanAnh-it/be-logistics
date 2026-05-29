package cms.hub.belogistics.service;

import cms.hub.belogistics.dto.request.PageSectionsRequest;
import cms.hub.belogistics.dto.response.PageSectionsResponse;

import java.util.List;

public interface PageSectionsService {
    PageSectionsResponse create(PageSectionsRequest request);
    List<PageSectionsResponse> getByPageId(Long pageId);
}
