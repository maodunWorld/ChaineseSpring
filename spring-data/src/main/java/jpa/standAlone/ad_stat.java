package jpa.standAlone;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Data
public class ad_stat {
    private String date;
    private String province;
    private String city;
    @Id
    private Integer adid;
    private Integer click_count;
}
