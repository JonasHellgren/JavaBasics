package hellgren.lombok;

import lombok.Builder;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

public class TestBuilderCat {

    BuilderCat cat;

    @Test
    public void testToString() {

        cat= BuilderCat.builder()
                .name("Donna")
                .weight(0.2)
                .age(1)
                .build();

        System.out.println("cat = " + cat);
    }

    @Test
    public void testDefaultAge() {

        cat= BuilderCat.builder()
                .name("Donna")
                .weight(0.2)
                .build();

        System.out.println("cat = " + cat);
        Assert.assertEquals(1,cat.age);
    }

    @Test
    public void testOneChild() {

        cat= BuilderCat.builder()
                .name("Donna")
                .weight(0.2)
                .child("Per")
                .build();

        System.out.println("cat = " + cat);
        Assert.assertEquals(1,cat.childs.size());
    }

    @Test
    public void testManyChilds() {

        BuilderCat.BuilderCatBuilder builder= BuilderCat.builder();

        builder.name("Donna")
                .weight(0.2)
                .childs(Arrays.asList("Per","Gusten","Ragnar"))
                .build();

        cat=builder.build();

        System.out.println("cat = " + cat);
        Assert.assertEquals(3,cat.childs.size());
    }


}
