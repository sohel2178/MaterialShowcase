package com.droidsonroids.materialshowcase.screen_main;

import android.os.Handler;
import android.os.Looper;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;
import com.droidsonroids.materialshowcase.R;
import com.droidsonroids.materialshowcase.data.entities.GithubRepo;

public class GithubRepoViewHolder extends RecyclerView.ViewHolder {

    TextView mTvHeader;
    TextView mTvStars;
    TextView mTvWatchers;
    TextView mTvForks;
	//@Bind(R.id.activity_details_vw_circle) View mFab;

	 String mStars;
	 String mWatchers;
	 String mForks;

	private int currentPosition;

	public GithubRepoViewHolder(View itemView, OnGithubRepoViewClickListener listener) {
		super(itemView);
		//ButterKnife.bind(this, itemView);
		initView(itemView);
		//mFab.setOnClickListener(v -> listener.onItemClick(this, currentPosition));
	}

	private void initView(View itemView) {
		mTvHeader = (TextView) itemView.findViewById(R.id.cardview_github_tv_header);
		mTvStars = (TextView) itemView.findViewById(R.id.cardview_github_tv_header);
		mTvWatchers = (TextView) itemView.findViewById(R.id.cardview_github_tv_header);
		mTvForks = (TextView) itemView.findViewById(R.id.cardview_github_tv_header);

		mStars = itemView.getContext().getString(R.string.stars);
		mWatchers = itemView.getContext().getString(R.string.watchers);
		mForks = itemView.getContext().getString(R.string.forks);
	}

	public void updateViews(GithubRepo githubRepo, int position) {
		currentPosition = position;
		new Handler(Looper.getMainLooper()).post(() -> {
			mTvHeader.setText(githubRepo.getName());
			mTvStars.setText(mStars + " " + githubRepo.getStargazersCount());
			mTvWatchers.setText(mWatchers + " " + githubRepo.getWatchersCount());
			mTvForks.setText(mForks + " " + githubRepo.getForksCount());
		});
	}

	//public View getFab() {
	//	return mFab;
	//}

	public TextView getTitle() {
		return mTvHeader;
	}
}
