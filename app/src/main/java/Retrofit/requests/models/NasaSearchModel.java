package Retrofit.requests.models;

import android.os.Parcel;
import android.os.Parcelable;

class Rover implements Parcelable{
    private String name ;
    private String landing_date;
    private String launch_date;

    public Rover(String name, String landing_date, String launch_date) {
        this.name = name;
        this.landing_date = landing_date;
        this.launch_date = launch_date;
    }

    public Rover() {
    }

    @Override
    public String toString() {
        return "Rover{" +
                "name='" + name + '\'' +
                ", landing_date='" + landing_date + '\'' +
                ", launch_date='" + launch_date + '\'' +
                '}';
    }

    protected Rover(Parcel in) {
        name = in.readString();
        landing_date = in.readString();
        launch_date = in.readString();
    }

    public static final Creator<Rover> CREATOR = new Creator<Rover>() {
        @Override
        public Rover createFromParcel(Parcel in) {
            return new Rover(in);
        }

        @Override
        public Rover[] newArray(int size) {
            return new Rover[size];
        }
    };

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLanding_date() {
        return landing_date;
    }

    public void setLanding_date(String landing_date) {
        this.landing_date = landing_date;
    }

    public String getLaunch_date() {
        return launch_date;
    }

    public void setLaunch_date(String launch_date) {
        this.launch_date = launch_date;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeString(landing_date);
        dest.writeString(launch_date);
    }
}

public class NasaSearchModel implements Parcelable {
    private String id;
    private String earth_date;
    private Rover rover;

    public NasaSearchModel(String id, String earth_date, Rover rover) {
        this.id = id;
        this.earth_date = earth_date;
        this.rover = rover;
    }

    public NasaSearchModel() {
    }

    protected NasaSearchModel(Parcel in) {
        id = in.readString();
        earth_date = in.readString();
    }

    public static final Creator<NasaSearchModel> CREATOR = new Creator<NasaSearchModel>() {
        @Override
        public NasaSearchModel createFromParcel(Parcel in) {
            return new NasaSearchModel(in);
        }

        @Override
        public NasaSearchModel[] newArray(int size) {
            return new NasaSearchModel[size];
        }
    };

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEarth_date() {
        return earth_date;
    }

    public void setEarth_date(String earth_date) {
        this.earth_date = earth_date;
    }

    public Rover getRover() {
        return rover;
    }

    public void setRover(Rover rover) {
        this.rover = rover;
    }

    @Override
    public String toString() {
        return "NasaSearchModel{" +
                "id='" + id + '\'' +
                ", earth_date='" + earth_date + '\'' +
                ", rover=" + rover +
                '}';
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(id);
        dest.writeString(earth_date);
    }
}
