package cms.hub.belogistics.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OtherOption implements Serializable {
    private String icon;
    private String image;
    private String type;
    private String value;
}
