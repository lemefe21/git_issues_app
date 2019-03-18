package com.leme.gitissuesapp.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.leme.gitissuesapp.R;
import com.leme.gitissuesapp.model.Issue;
import com.leme.gitissuesapp.model.User;
import com.leme.gitissuesapp.util.IssueUtil;
import com.squareup.picasso.Picasso;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import de.hdodenhof.circleimageview.CircleImageView;

public class IssueItemAdapter extends RecyclerView.Adapter<IssueItemAdapter.IssueViewHolder> {

    private List<Issue> mIssueList;
    private final IssueItemAdapterOnClickHandle mClickHandle;
    private Context mContext;

    public IssueItemAdapter(Context context, IssueItemAdapterOnClickHandle clickHandle) {
        mContext = context;
        mClickHandle = clickHandle;
    }

    public interface IssueItemAdapterOnClickHandle {
        void onClick(Issue issueClicked);
    }

    @NonNull
    @Override
    public IssueViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {

        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.issues_item_list, viewGroup, false);
        return new IssueViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull IssueViewHolder issueViewHolder, int position) {

        Issue issue = mIssueList.get(position);
        User user = issue.getUser();
        String state = issue.getState();

        issueViewHolder.mUserLoginTextView.setText(user.getLogin());
        issueViewHolder.mIssueTitleTextView.setText(issue.getTitle());
        issueViewHolder.mIssueIconStateImageView.setImageResource(IssueUtil.getResourceByIconState(state));
        issueViewHolder.mIssueItemDivider.setBackgroundColor(ContextCompat.getColor(mContext, IssueUtil.getResourceByDetailStateColor(state)));

        Picasso.with(mContext)
                .load(user.getAvatar_url())
                .placeholder(R.drawable.default_avatar)
                .error(R.drawable.default_avatar)
                .into(issueViewHolder.mUserAvatarImageView);

    }

    @Override
    public int getItemCount() {
        if(mIssueList == null) return 0;
        return mIssueList.size();
    }

    public void setIssuesData(List<Issue> issuesList) {
        mIssueList = issuesList;
        notifyDataSetChanged();
    }

    public class IssueViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        @BindView(R.id.iv_issue_item_user_avatar)
        CircleImageView mUserAvatarImageView;

        @BindView(R.id.tv_issue_item_login)
        TextView mUserLoginTextView;

        @BindView(R.id.tv_issue_item_title)
        TextView mIssueTitleTextView;

        @BindView(R.id.iv_issue_icon_state)
        ImageView mIssueIconStateImageView;

        @BindView(R.id.view_issue_item_divider)
        View mIssueItemDivider;

        public IssueViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);

            itemView.setOnClickListener(this);

        }

        @Override
        public void onClick(View view) {

            Issue issue = mIssueList.get(getAdapterPosition());
            mClickHandle.onClick(issue);

        }

    }

}
