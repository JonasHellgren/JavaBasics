package youtube.avoiding_if_else_command_pattern.common;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
public class Command {

    CommandTypes type;
    List<String> params;
}
