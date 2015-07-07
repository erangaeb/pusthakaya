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
public class BookFragment extends android.support.v4.app.Fragment {

    // UI Components
    private TextView titleTextView;
    private TextView publisherTextView;

    private EditText titleEditText;
    private EditText publisherEditText;

    // use custom font here
    private Typeface typeface;

    /**
     * {@inheritDoc}
     */
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        ViewGroup root = (ViewGroup) inflater.inflate(R.layout.layout_assignment1, container, false);

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
        titleTextView = (TextView) getActivity().findViewById(R.id.book_fragment_name_label);
        publisherTextView = (TextView) getActivity().findViewById(R.id.book_fragment_publisher_label);

        titleTextView.setTypeface(typeface, Typeface.BOLD);
        publisherTextView.setTypeface(typeface, Typeface.BOLD);

        titleEditText = (EditText) getActivity().findViewById(R.id.book_fragment_name_text);
        publisherEditText = (EditText) getActivity().findViewById(R.id.book_fragment_publisher_text);

        titleEditText.setTypeface(typeface, Typeface.NORMAL);
        publisherEditText.setTypeface(typeface, Typeface.NORMAL);
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
