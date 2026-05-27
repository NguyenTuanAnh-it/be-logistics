package cms.hub.belogistics.controller;

import cms.hub.belogistics.common.ApiResponse;
import cms.hub.belogistics.dto.request.PagesRequest;
import cms.hub.belogistics.dto.response.PageWithSectionsResponse;
import cms.hub.belogistics.dto.response.PagesResponse;
import cms.hub.belogistics.service.PageService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
