package definitely.hw7_exercise.ui;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

@Entity(tableName = "all_cities")
public class Cities {

    @PrimaryKey(autoGenerate = true)
    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    private int picture;
    private String additInfo;
    private boolean isLiked;


    public void setPicture(int picture) {
        this.picture = picture;
    }

    public Cities() {

    }

    public Cities(int picture, String additInfo, boolean isLiked) {
        this.picture = picture;
        this.additInfo = additInfo;
        this.isLiked = isLiked;
    }

    public int getPicture() {
        return picture;
    }


    public String getAdditInfo() {
        return additInfo;
    }

    public void setAdditInfo(String additInfo) {
        this.additInfo = additInfo;
    }

    public boolean isLiked() {
        return isLiked;
    }

    public void setIsLiked(boolean isLiked) {
        this.isLiked = isLiked;
    }
}
