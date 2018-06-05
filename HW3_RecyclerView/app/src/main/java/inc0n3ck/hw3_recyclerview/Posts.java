package inc0n3ck.hw3_recyclerview;

import android.graphics.drawable.Drawable;
import android.widget.ImageButton;

class Posts {

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getNumberOfLikes() {
        return numberOfLikes;
    }

    public String setNumberOfLikes(String numberOfLikes) {
        this.numberOfLikes = numberOfLikes;
        return numberOfLikes;
    }

    public String getNumberOfComments() {
        return numberOfComments;
    }

    public void setNumberOfComments(String numberOfComments) {
        this.numberOfComments = numberOfComments;
    }

    public Drawable getPicture() {
        return picture;
    }

    public void setPicture(Drawable picture) {
        this.picture = picture;
    }

    private String title;
    private String numberOfLikes;
    private String numberOfComments;
    private Drawable picture;

    public ImageButton getBtnCommentPost() {
        return btnCommentPost;
    }

    public void setBtnCommentPost(ImageButton btnCommentPost) {
        this.btnCommentPost = btnCommentPost;
    }

    private ImageButton btnCommentPost;

    public int getPictureId() {
        return pictureId;
    }

    public void setPictureId(int pictureId) {
        this.pictureId = pictureId;
    }

    private int pictureId;

    public Posts(String title, String numberOfLikes, String numberOfComments, int pictureId) {
        this.title = title;
        this.numberOfLikes = numberOfLikes;
        this.numberOfComments = numberOfComments;
        this.pictureId = pictureId;
    }


}
