package inc0n3ck.hw3_recyclerview;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;


public class PostAdapter extends RecyclerView.Adapter<PostAdapter.ViewHolder> {

    private Context context;
    private ArrayList<Posts> posts;

    private boolean isLikeBtnHit;
    private boolean isDislikeBtnHit;


    public PostAdapter(ArrayList<Posts> posts, Context context) {
        this.posts = posts;
        this.context = context;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.posts_part, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, final int position) {

        holder.txtLikes.setText(posts.get(position).getNumberOfLikes());
        holder.txtComments.setText(posts.get(position).getNumberOfComments());
        holder.txtTitle.setText(posts.get(position).getTitle());

        holder.imgPicture.setImageResource(posts.get(position).getPictureId());

        isLikeBtnHit = false;
        isDislikeBtnHit = false;

        holder.btnLike.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String numbers = holder.txtLikes.getText().toString();
                int numberOfLikes = Integer.parseInt(numbers);

                if (!isLikeBtnHit && !isDislikeBtnHit) {
                    numberOfLikes++;
                    holder.btnLike.setImageResource(R.mipmap.like_btn);
                    holder.btnDislike.setImageResource(R.mipmap.dislike_not_selected);
                    isLikeBtnHit = true;

                } else if (isDislikeBtnHit && !isLikeBtnHit) {
                    holder.btnLike.setImageResource(R.mipmap.like_btn);
                    holder.btnDislike.setImageResource(R.mipmap.dislike_not_selected);
                    numberOfLikes += 2;
                    isDislikeBtnHit = false;
                    isLikeBtnHit = true;
                } else if (!isLikeBtnHit) {
                    numberOfLikes++;
                    holder.btnLike.setImageResource(R.mipmap.like_btn);
                    isLikeBtnHit = true;
                } else if (isLikeBtnHit) {
                    numberOfLikes--;
                    holder.btnLike.setImageResource(R.mipmap.like_not_selected);
                    isLikeBtnHit = false;
                }

                holder.txtLikes.setText(posts.get(position).setNumberOfLikes(String.valueOf(numberOfLikes)));

            }
        });

        holder.btnDislike.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String numbers = holder.txtLikes.getText().toString();
                int numberOfLikes = Integer.parseInt(numbers);

                if (!isDislikeBtnHit && !isLikeBtnHit) {
                    numberOfLikes--;
                    holder.btnLike.setImageResource(R.mipmap.like_not_selected);
                    holder.btnDislike.setImageResource(R.mipmap.dislike_btn);
                    isDislikeBtnHit = true;
                } else if (!isDislikeBtnHit && isLikeBtnHit) {
                    holder.btnLike.setImageResource(R.mipmap.like_not_selected);
                    holder.btnDislike.setImageResource(R.mipmap.dislike_btn);
                    numberOfLikes -= 2;
                    isDislikeBtnHit = true;
                    isLikeBtnHit = false;
                } else if (!isDislikeBtnHit) {
                    numberOfLikes--;
                    holder.btnDislike.setImageResource(R.mipmap.dislike_btn);
                    isDislikeBtnHit = true;
                } else if (isDislikeBtnHit) {

                    numberOfLikes++;
                    holder.btnDislike.setImageResource(R.mipmap.dislike_not_selected);
                    isDislikeBtnHit = false;
                }

                holder.txtLikes.setText(posts.get(position).setNumberOfLikes(String.valueOf(numberOfLikes)));

            }
        });


        holder.btnComment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                context.startActivity(new Intent(context, CommentsSectionActivity.class));
            }
        });

    }


    @Override
    public int getItemCount() {
        return posts.size();
    }


    public static class ViewHolder extends RecyclerView.ViewHolder {

        TextView txtTitle;
        TextView txtLikes;
        TextView txtComments;
        ImageButton btnLike;
        ImageButton btnDislike;
        ImageButton btnComment;
        ImageButton btnShare;
        ImageView imgPicture;

        LinearLayout grpPosts;

        ViewHolder(View itemView) {
            super(itemView);


            txtTitle = itemView.findViewById(R.id.txt_title);
            txtLikes = itemView.findViewById(R.id.txt_likes);

            txtComments = itemView.findViewById(R.id.txt_comments);
            btnLike = itemView.findViewById(R.id.btn_like);
            btnDislike = itemView.findViewById(R.id.btn_dislike);
            btnComment = itemView.findViewById(R.id.btn_comment);
            btnShare = itemView.findViewById(R.id.btn_share);

            imgPicture = itemView.findViewById(R.id.img_picture);

            grpPosts = itemView.findViewById(R.id.grp_parts);

        }


        interface OnItemClickListener {
            void onItemClick(Posts posts, int position);
        }
    }
}
