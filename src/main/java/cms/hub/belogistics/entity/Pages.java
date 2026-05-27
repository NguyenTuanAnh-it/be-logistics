package cms.hub.belogistics.entity;

import cms.hub.belogistics.common.BaseEntity;
import cms.hub.belogistics.common.enums.Type;
import cms.hub.belogistics.dto.OtherOption;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.io.Serializable;
import java.util.List;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "pages")
public class Pages extends BaseEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "url")
    private String url;

    @Column(name = "short_description")
    private String shortDescription;

    @Convert(converter = cms.hub.belogistics.common.converter.StringListConverter.class)
    @Column(name = "description", columnDefinition = "text")
    private List<String> description;

    @Column(name = "content", columnDefinition = "text")
    private String content;

    @Convert(converter = cms.hub.belogistics.common.converter.OtherOptionListConverter.class)
    @Column(name = "other_options", columnDefinition = "json")
    private List<OtherOption> otherOptions;

    @Column(name = "sort_index")
    private Integer sortIndex;

    @Column(name = "active")
    private Boolean active = true;

    @Enumerated(EnumType.STRING)
    @Column(name = "type")
    private Type type;

    @ManyToOne
    @JoinColumn(name = "parent_id")
    private Pages parent;
}
