package hellgren.cloneWithApache;

import lombok.*;
import org.apache.commons.beanutils.BeanUtils;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Person {
    private String name;
    private int age;

    @SneakyThrows
    public Person clone() {
        Person clone=new Person();
        BeanUtils.copyProperties(clone, this);
        return clone;
    }


}
