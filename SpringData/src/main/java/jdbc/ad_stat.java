package jdbc;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;


@Data
@AllArgsConstructor
public class ad_stat {
   private String date;
   private String province;
   private String city;
   private Integer adid;
   private Integer clickCount;
}
