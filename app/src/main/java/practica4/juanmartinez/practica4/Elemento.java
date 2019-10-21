package practica4.juanmartinez.practica4;

import android.os.Parcel;
import android.os.Parcelable;

public class Elemento implements Parcelable {
    private String v1;
    private String v2;
    private String v3;

    public Elemento(String v1, String v2, String v3) {
        this.v1 = v1;
        this.v2 = v2;
        this.v3 = v3;
    }

    public String getV1() {
        return v1;
    }

    public void setV1(String v1) {
        this.v1 = v1;
    }

    public String getV2() {
        return v2;
    }

    public void setV2(String v2) {
        this.v2 = v2;
    }

    public String getV3() {
        return v3;
    }

    public void setV3(String v3) {
        this.v3 = v3;
    }

    //*********************PARCELABLE************************
    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.v1);
        dest.writeString(this.v2);
        dest.writeString(this.v3);
    }

    protected Elemento(Parcel in) {
        this.v1 = in.readString();
        this.v2 = in.readString();
        this.v3 = in.readString();
    }

    public static final Parcelable.Creator<Elemento> CREATOR = new Parcelable.Creator<Elemento>() {
        @Override
        public Elemento createFromParcel(Parcel source) {
            return new Elemento(source);
        }

        @Override
        public Elemento[] newArray(int size) {
            return new Elemento[size];
        }
    };
}
