package com.mcs.assignment.ui;

import android.graphics.Typeface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import com.mcs.assignment.R;

/**
 * Fragment to display today power consumption
 *
 * @author eranga herath(eranga.herath@pagero.com)
 */
public class LendingFragment extends android.support.v4.app.Fragment {

    // UI Components
    private TextView memberTextView;
    private TextView bookTextView;

    private EditText memberEditText;
    private EditText bookEditText;

    // use custom font here
    private Typeface typeface;

    /**
     * {@inheritDoc}
     */
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        ViewGroup root = (ViewGroup) inflater.inflate(R.layout.layout_lending, container, false);

        return root;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        typeface = Typeface.createFromAsset(getActivity().getAssets(), "fonts/vegur_2.otf");
        initUi();
    }

    /**
     * Initialize UI components
     */
    private void initUi() {
        memberTextView = (TextView) getActivity().findViewById(R.id.lending_fragment_member_label);
        bookTextView = (TextView) getActivity().findViewById(R.id.lending_fragment_book_label);

        memberTextView.setTypeface(typeface, Typeface.BOLD);
        bookTextView.setTypeface(typeface, Typeface.BOLD);

        memberEditText = (EditText) getActivity().findViewById(R.id.lending_fragment_member_text);
        bookEditText = (EditText) getActivity().findViewById(R.id.lending_fragment_book_text);

        memberEditText.setTypeface(typeface, Typeface.NORMAL);
        bookEditText.setTypeface(typeface, Typeface.NORMAL);
    }

    /**
     * {@inheritDoc}
     */
    public void onResume() {
        super.onResume();
    }

    /**
     * {@inheritDoc}
     */
    public void onPause() {
        super.onPause();
    }

}
