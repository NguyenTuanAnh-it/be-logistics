package cms.hub.belogistics.controller;

import cms.hub.belogistics.common.ApiResponse;
import cms.hub.belogistics.common.enums.Type;
import cms.hub.belogistics.dto.request.PagesRequest;
import cms.hub.belogistics.dto.response.PageWithSectionsResponse;
import cms.hub.belogistics.dto.response.PagesResponse;
import cms.hub.belogistics.service.PageService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/pages")
@RequiredArgsConstructor
public class PagesController {
    private final PageService pageService;

    @PostMapping
    public ResponseEntity<ApiResponse<PagesResponse>> create(@Valid @RequestBody PagesRequest request) {
        PagesResponse response = pageService.create(request);
        return ResponseEntity.ok(ApiResponse.success(response));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<PagesResponse>> update(@PathVariable Long id, @Valid @RequestBody PagesRequest request) {
        PagesResponse response = pageService.update(id, request);
        return ResponseEntity.ok(ApiResponse.success(response));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<Void>> delete(@PathVariable Long id) {
        pageService.delete(id);
        return ResponseEntity.ok(ApiResponse.success("Deleted successfully", null));
    }

    @GetMapping
    public ResponseEntity<ApiResponse<List<PagesResponse>>> findAll() {
        List<PagesResponse> response = pageService.findAll();
        return ResponseEntity.ok(ApiResponse.success(response));
    }

    @GetMapping("/by-type")
    public ResponseEntity<ApiResponse<List<PagesResponse>>> findByType(@RequestParam Type type) {
        List<PagesResponse> response = pageService.findByType(type);
        return ResponseEntity.ok(ApiResponse.success(response));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<PageWithSectionsResponse>> findById(@PathVariable Long id) {
        PageWithSectionsResponse response = pageService.findById(id);
        return ResponseEntity.ok(ApiResponse.success(response));
    }

    @GetMapping("/by-url")
    public ResponseEntity<ApiResponse<PageWithSectionsResponse>> findByUrl(@RequestParam String url) {
        PageWithSectionsResponse response = pageService.findByUrl(url);
        return ResponseEntity.ok(ApiResponse.success(response));
    }
}
