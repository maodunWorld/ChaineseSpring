package jpa.first;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Data
public class ad_stat {
   private String date;
   private String province;
   private String city;
   @Id
   private Integer adid;
   private Integer clickCount;
}
