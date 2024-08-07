package javaSE11_developer_certification_master.WorkingwithJavaDataTypesandStringAPIs.m4.v3_CustomWrapper.after;

public final class Volume {

    public final double liters;
    private final static double MIN_LITERS = 0;
    private final static double MAX_LITERS = Double.MAX_VALUE;

    public Volume(double inLiters){
        if( inLiters <= MIN_LITERS ) throw new java.lang.NumberFormatException();

        liters = inLiters;
    }
    public double getVolume(){
        return liters;
    }
    public double inMilliliters(){
        return liters * 1000;
    }
    public double inQuarts(){
        return liters * 1.05669;
    }
    public boolean equals(Object obj){
        if( obj.getClass() != this.getClass() ) return false;
        Volume other = (Volume)obj;
        if(other.getVolume() == this.liters) return true;
        return false;
    }
    public String toString(){
        return Double.toString(liters) + "ltrs";
    }

    public int hashCode(){
        return this.toString().hashCode();
    }

}
