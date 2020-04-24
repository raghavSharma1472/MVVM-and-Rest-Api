package Retrofit.requests.models;

import android.os.Parcel;
import android.os.Parcelable;

class Camera implements Parcelable {
    private String name;
    private String full_name;
    private String id;
    private String rover_id;

    public Camera(String name, String full_name, String id, String rover_id) {
        this.name = name;
        this.full_name = full_name;
        this.id = id;
        this.rover_id = rover_id;
    }

    public Camera() {
    }

    protected Camera(Parcel in) {
        name = in.readString();
        full_name = in.readString();
        id = in.readString();
        rover_id = in.readString();
    }

    public static final Creator<Camera> CREATOR = new Creator<Camera>() {
        @Override
        public Camera createFromParcel(Parcel in) {
            return new Camera(in);
        }

        @Override
        public Camera[] newArray(int size) {
            return new Camera[size];
        }
    };

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFull_name() {
        return full_name;
    }

    public void setFull_name(String full_name) {
        this.full_name = full_name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getRover_id() {
        return rover_id;
    }

    public void setRover_id(String rover_id) {
        this.rover_id = rover_id;
    }

    @Override
    public String toString() {
        return "Camera{" +
                "name='" + name + '\'' +
                ", full_name='" + full_name + '\'' +
                ", id='" + id + '\'' +
                ", rover_id='" + rover_id + '\'' +
                '}';
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeString(full_name);
        dest.writeString(id);
        dest.writeString(rover_id);
    }
}

public class NasaModel implements Parcelable {
    private String id;
    private String earth_date;
    private Rover rover;
    Camera camera;
    private String img_src;

    public NasaModel(String id, String earth_date, Rover rover, Camera camera, String img_src) {
        this.id = id;
        this.earth_date = earth_date;
        this.rover = rover;
        this.camera = camera;
        this.img_src = img_src;
    }

    public NasaModel() {
    }

    protected NasaModel(Parcel in) {
        id = in.readString();
        earth_date = in.readString();
        rover = in.readParcelable(Rover.class.getClassLoader());
        camera = in.readParcelable(Camera.class.getClassLoader());
        img_src = in.readString();
    }

    public static final Creator<NasaModel> CREATOR = new Creator<NasaModel>() {
        @Override
        public NasaModel createFromParcel(Parcel in) {
            return new NasaModel(in);
        }

        @Override
        public NasaModel[] newArray(int size) {
            return new NasaModel[size];
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

    public Camera getCamera() {
        return camera;
    }

    public void setCamera(Camera camera) {
        this.camera = camera;
    }

    public String getImg_src() {
        return img_src;
    }

    public void setImg_src(String img_src) {
        this.img_src = img_src;
    }

    @Override
    public String toString() {
        return "NasaModel{" +
                "id='" + id + '\'' +
                ", earth_date='" + earth_date + '\'' +
                ", rover=" + rover +
                ", camera=" + camera +
                ", img_src='" + img_src + '\'' +
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
        dest.writeParcelable(rover, flags);
        dest.writeParcelable(camera, flags);
        dest.writeString(img_src);
    }
}

