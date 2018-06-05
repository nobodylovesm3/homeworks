package inc0n3ck.hw3_recyclerview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements PostAdapter.ViewHolder.OnItemClickListener {

    private ArrayList<Posts> posts;
    private Posts post;

    private RecyclerView recyclerView;
    private PostAdapter postAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        buildList();

        setupRecyclerView();
    }

    private void setupRecyclerView() {
        recyclerView = findViewById(R.id.rv_posts);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        postAdapter = new PostAdapter(posts, this);
        recyclerView.setAdapter(postAdapter);
    }


    void buildList() {
        posts = new ArrayList<>();


        post = new Posts("is this real life?!", "392", "0", getResources().getIdentifier("meme", "drawable", getPackageName()));
        posts.add(post);

        post = new Posts("the guy above me is a dentist", "320", "0", getResources().getIdentifier("meme2", "drawable", getPackageName()));
        posts.add(post);

        post = new Posts("secretly, we are monsters", "4930", "0", getResources().getIdentifier("meme3", "drawable", getPackageName()));
        posts.add(post);

        post = new Posts("Detroit:Become Human looks decent", "13", "0", getResources().getIdentifier("meme4", "drawable", getPackageName()));
        posts.add(post);
    }

    @Override
    public void onItemClick(Posts posts, int position) {

    }
}
