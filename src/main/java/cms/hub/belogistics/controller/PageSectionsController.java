package cms.hub.belogistics.controller;

import cms.hub.belogistics.common.ApiResponse;
import cms.hub.belogistics.dto.request.PageSectionsRequest;
import cms.hub.belogistics.dto.response.PageSectionsResponse;
import cms.hub.belogistics.service.PageSectionsService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/page-sections")
@RequiredArgsConstructor
public class PageSectionsController {

    private final PageSectionsService pageSectionsService;

    @PostMapping
    public ResponseEntity<ApiResponse<PageSectionsResponse>> create(@Valid @RequestBody PageSectionsRequest request) {
        PageSectionsResponse response = pageSectionsService.create(request);
        return ResponseEntity.ok(ApiResponse.success(response));
    }

    @GetMapping
    public ResponseEntity<ApiResponse<List<PageSectionsResponse>>> getByPageId(@RequestParam Long pageId) {
        List<PageSectionsResponse> response = pageSectionsService.getByPageId(pageId);
        return ResponseEntity.ok(ApiResponse.success(response));
    }
}
