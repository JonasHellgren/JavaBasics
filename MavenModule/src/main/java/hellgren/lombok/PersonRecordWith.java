package hellgren.lombok;

import lombok.Builder;
import lombok.With;

@Builder
public record PersonRecordWith (
        String firstName,
        String lastName,
        @With String eMail,
        @With String employeer

) {



}
