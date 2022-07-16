package effective_java.H_Methods.item56;

import java.util.Date;


/***
 * The interface for container of two dates.
 * @author Jonas Hellgren
*/

public interface PeriodInterface {

     /**
      * Gets the first date
      *  @return {@link Date}
      */

     Date getStart();

     /**
      * Gets the second date
      * @return {@link Date}
      */

     Date getEnd();
}
