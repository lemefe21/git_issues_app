package com.leme.gitissuesapp;

import com.leme.gitissuesapp.api.ApiClient;
import com.leme.gitissuesapp.api.ApiInterface;
import com.leme.gitissuesapp.contract.MainContract;
import com.leme.gitissuesapp.handler.ExceptionHandler;
import com.leme.gitissuesapp.model.Issue;
import com.leme.gitissuesapp.presenter.MainPresenter;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InOrder;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;

public class MainPresenterTest {

    private MainPresenter presenter;

    @Mock
    private ApiInterface apiInterface;

    @Mock
    private MainContract.View view;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void fetchValidDataShouldLoadIntoView() {

        ApiInterface api = ApiClient.getClient().create(ApiInterface.class);
        Call<List<Issue>> call = api.getIssuesList();

        Mockito.when(apiInterface.getIssuesList()).thenReturn(call);

    }

    @Test
    public void orderViewMethodsCallInPresenter() {

        Exception exception = new Exception();

        presenter = new MainPresenter(this.view);

        InOrder inOrder = Mockito.inOrder(view);

        presenter.requestDataFromServer();
        inOrder.verify(view, Mockito.times(1)).showProgress();
        inOrder.verify(view, Mockito.never()).hideProgress();
        inOrder.verify(view, Mockito.never()).setDataToRecyclerView(new ArrayList<Issue>());
        inOrder.verify(view, Mockito.never()).showError(ExceptionHandler.FormatErrorToUi(exception));

        presenter.success(new ArrayList<Issue>());
        inOrder.verify(view, Mockito.times(1)).setDataToRecyclerView(new ArrayList<Issue>());
        inOrder.verify(view, Mockito.times(1)).hideProgress();
        inOrder.verify(view, Mockito.never()).showProgress();
        inOrder.verify(view, Mockito.never()).showError(ExceptionHandler.FormatErrorToUi(exception));

        presenter.error(exception);
        inOrder.verify(view, Mockito.times(1)).showError(ExceptionHandler.FormatErrorToUi(exception));
        inOrder.verify(view, Mockito.times(1)).hideProgress();
        inOrder.verify(view, Mockito.never()).showProgress();
        inOrder.verify(view, Mockito.never()).setDataToRecyclerView(new ArrayList<Issue>());

    }

}
