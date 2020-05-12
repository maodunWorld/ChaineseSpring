package jdbc.standAlone;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.annotation.Id;


@Data
@AllArgsConstructor
public class ad_stat {
   private String date;
   private String province;
   private String city;
   @Id
   private Integer adid;
   private Integer clickCount;
}
