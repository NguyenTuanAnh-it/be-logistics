package cms.hub.belogistics.dto.response;

import cms.hub.belogistics.common.enums.Type;
import cms.hub.belogistics.dto.OtherOption;
import lombok.Data;

import java.io.Serializable;
import java.time.Instant;
import java.util.List;

@Data
public class PageWithSectionsResponse implements Serializable {

    private Long id;

    private String name;

    private String url;

    private String shortDescription;

    private List<String> description;

    private String content;

    private List<OtherOption> otherOptions;

    private Integer sortIndex;

    private Boolean active;

    private Type type;

    private Long parentId;

    private List<PageSectionsResponse> sections;

    private Instant createdAt;

    private Instant updatedAt;
}
