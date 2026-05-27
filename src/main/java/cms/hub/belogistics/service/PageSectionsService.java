package cms.hub.belogistics.service;

import cms.hub.belogistics.dto.request.PageSectionsRequest;
import cms.hub.belogistics.dto.response.PageSectionsResponse;

public interface PageSectionsService {
    PageSectionsResponse create(PageSectionsRequest request);
}
