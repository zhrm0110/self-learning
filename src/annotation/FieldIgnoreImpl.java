package annotation;

import java.lang.annotation.Annotation;

public class FieldIgnoreImpl implements FieldIgnore {

    @Override
    public boolean value() {
        // TODO Auto-generated method stub
        System.out.println("..........impl field ignore..............");
        return false;
    }

    @Override
    public Class<? extends Annotation> annotationType() {
        // TODO Auto-generated method stub
        return null;
    }

}
