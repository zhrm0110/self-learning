package annotation;

public class AnnotationTest {
    private String companyName;
    private String contactPhone;
    @FieldIgnore(value = true)
    private String taxCode;

    public AnnotationTest() {
    }

    public AnnotationTest(String companyName, String contactPhone) {
        this.companyName = companyName;
        this.contactPhone = contactPhone;
    }

    public AnnotationTest(String companyName, String contactPhone, String taxCode) {
        this.companyName = companyName;
        this.contactPhone = contactPhone;
        this.taxCode = taxCode;
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        AnnotationTest annotationTest = new AnnotationTest();
    }

}
