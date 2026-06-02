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

    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<PageSectionsResponse>> update(@PathVariable Long id, @Valid @RequestBody PageSectionsRequest request) {
        PageSectionsResponse response = pageSectionsService.update(id, request);
        return ResponseEntity.ok(ApiResponse.success(response));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<Void>> delete(@PathVariable Long id) {
        pageSectionsService.delete(id);
        return ResponseEntity.ok(ApiResponse.success("Deleted successfully", null));
    }

    @GetMapping
    public ResponseEntity<ApiResponse<List<PageSectionsResponse>>> getByPageId(@RequestParam Long pageId) {
        List<PageSectionsResponse> response = pageSectionsService.getByPageId(pageId);
        return ResponseEntity.ok(ApiResponse.success(response));
    }
}
