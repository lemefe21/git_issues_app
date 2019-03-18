package com.leme.gitissuesapp.view.activity;

import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.leme.gitissuesapp.R;
import com.leme.gitissuesapp.contract.IssueDetailContract;
import com.leme.gitissuesapp.model.Issue;
import com.leme.gitissuesapp.presenter.IssueDetailPresenter;
import com.squareup.picasso.Picasso;

import butterknife.BindView;
import butterknife.ButterKnife;
import de.hdodenhof.circleimageview.CircleImageView;

public class IssueDetailActivity extends AppCompatActivity implements IssueDetailContract.View {

    //TODO Create SplashScreen
    //TODO implement unit tests

    private IssueDetailPresenter mDetailPresenter;

    @BindView(R.id.detail_issue_activity_iv_user_avatar)
    CircleImageView mImageViewUserAvatar;

    @BindView(R.id.iv_issue_icon_state)
    ImageView mImageViewIconState;

    @BindView(R.id.detail_issue_activity_iv_banner)
    View mViewDetailBanner;

    @BindView(R.id.detail_issue_activity_tv_detail_login)
    TextView mTextViewDetailLogin;

    @BindView(R.id.tv_detail_issue_state)
    TextView mTextViewDetailState;

    @BindView(R.id.tv_detail_issue_title)
    TextView mTextViewDetailTitle;

    @BindView(R.id.tv_detail_issue_body)
    TextView mTextViewDetailBody;

    @BindView(R.id.tv_detail_issue_created_date)
    TextView mTextViewDetailCreatedData;

    @BindView(R.id.detail_issue_button_to_url)
    Button mButtonToOpenUrlUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_issue_detail);

        initUi();

    }

    private void initUi() {

        ButterKnife.bind(this);

        mDetailPresenter = new IssueDetailPresenter(this);
        mDetailPresenter.getIntentExtras(getIntent());

    }

    @Override
    public void setIssueDetailData(Issue issue) {

        mTextViewDetailLogin.setText(issue.getUser().getLogin());
        mTextViewDetailState.setText(getString(R.string.label_detail_issue_state, issue.getState()));
        mTextViewDetailTitle.setText(issue.getTitle());
        mTextViewDetailBody.setText(issue.getBody());
        mTextViewDetailCreatedData.setText(issue.getCreated_at());

        Picasso.with(this)
                .load(issue.getUser().getAvatar_url())
                .placeholder(R.drawable.default_avatar)
                .error(R.drawable.default_avatar)
                .into(mImageViewUserAvatar);

    }

    @Override
    public void setCurrentIconByState(int resource) {
        mImageViewIconState.setImageResource(resource);
    }

    @Override
    public void setCurrentDetailColorByState(int resource) {
        mTextViewDetailState.setTextColor(ContextCompat.getColor(this, resource));
    }

    @Override
    public void setCurrentBannerByState(int resource) {
        mViewDetailBanner.setBackgroundColor(ContextCompat.getColor(this, resource));
    }

    @Override
    public void setCurrentButtonByState(int resourceColor, int resourceFontColor) {
        mButtonToOpenUrlUser.setBackground(getResources().getDrawable(resourceColor));
        mButtonToOpenUrlUser.setTextColor(ContextCompat.getColor(this, resourceFontColor));
    }

    @Override
    public void openUrlUser(View view) {
        mDetailPresenter.goToUrlUser(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mDetailPresenter.onDestroy();
    }
}
