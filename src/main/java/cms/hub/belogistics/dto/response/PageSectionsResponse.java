package cms.hub.belogistics.dto.response;

import cms.hub.belogistics.dto.DescriptionItem;
import cms.hub.belogistics.dto.TitleItem;
import lombok.Data;

import java.io.Serializable;
import java.time.Instant;
import java.util.List;

@Data
public class PageSectionsResponse implements Serializable {

    private Long id;

    private Long pageId;

    private String pageTitle;

    private List<TitleItem> title;

    private List<DescriptionItem> description;

    private List<String> images;

    private Integer sortIndex;

    private Boolean active;

    private Instant createdAt;

    private Instant updatedAt;
}
