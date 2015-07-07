package com.mcs.assignment.ui;

import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.mcs.assignment.R;
import com.mcs.assignment.adapters.PusthakayaListAdapter;

import java.util.ArrayList;

/**
 * Assignment4 fragment class
 *
 * @author eranga herath(erangae@gmail.com)
 */
public class ListFragment extends Fragment implements View.OnClickListener {

    // use to populate list
    private PusthakayaListAdapter adapter;
    private ListView urlListView;

    private ArrayList<String> list;

    // set custom font
    Typeface typeface;

    /**
     * {@inheritDoc}
     */
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        ViewGroup root = (ViewGroup) inflater.inflate(R.layout.layout_url_list, container, false);

        // initialize list
        list = getArguments().getStringArrayList("list");

        return root;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        typeface = Typeface.createFromAsset(this.getActivity().getAssets(), "fonts/vegur_2.otf");

        initUi();
        initUrlList();
    }

    /**
     * Initialize UI components
     */
    private void initUi() {
        urlListView = (ListView) getActivity().findViewById(R.id.url_list);

        // add header and footer for list
        View headerView = View.inflate(getActivity(), R.layout.list_header, null);
        View footerView = View.inflate(getActivity(), R.layout.list_header, null);
        urlListView.addHeaderView(headerView);
        urlListView.addFooterView(footerView);
    }

    /**
     * Create url list
     */
    private void initUrlList() {
        adapter = new PusthakayaListAdapter((HomeActivity) getActivity(), list);
        urlListView.setAdapter(adapter);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void onClick(View v) {
    }

}
