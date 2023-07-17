package javaSE11_developer_certification_master.object_oriented_approach.four_static_members;

public final class ConversionHelper {
    private static int metersInOneNm;

    static {
        metersInOneNm = 1852;
    }

    public static int fromFeetToFL(int feet) {
        return feet / 100;
    }

    public static double fromNmToMeters(double nm) {
        return nm * metersInOneNm;
    }
}
