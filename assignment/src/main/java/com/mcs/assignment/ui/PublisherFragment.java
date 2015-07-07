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
 * Display power usage summary
 *
 * @author eranga herath(eranga.herath@pagero.com)
 */
public class PublisherFragment extends android.support.v4.app.Fragment implements View.OnClickListener {

    private TextView nameTextView;
    private TextView addressTextView;
    private TextView phoneTextView;
    private EditText nameEditText;
    private EditText addressEditText;
    private EditText phoneEditText;

    // use custom font here
    private Typeface typeface;

    /**
     * {@inheritDoc}
     */
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        ViewGroup root = (ViewGroup) inflater.inflate(R.layout.layout_new_publisher, container, false);

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
        nameTextView = (TextView) getActivity().findViewById(R.id.publisher_fragment_name_label);
        addressTextView = (TextView) getActivity().findViewById(R.id.publisher_fragment_address_label);
        phoneTextView = (TextView) getActivity().findViewById(R.id.publisher_fragment_phone_label);

        nameTextView.setTypeface(typeface, Typeface.BOLD);
        addressTextView.setTypeface(typeface, Typeface.BOLD);
        phoneTextView.setTypeface(typeface, Typeface.BOLD);

        nameEditText = (EditText) getActivity().findViewById(R.id.publisher_fragment_name_text);
        addressEditText = (EditText) getActivity().findViewById(R.id.publisher_fragment_address_text);
        phoneEditText = (EditText) getActivity().findViewById(R.id.publisher_fragment_phone_text);

        nameEditText.setTypeface(typeface, Typeface.NORMAL);
        addressEditText.setTypeface(typeface, Typeface.NORMAL);
        phoneEditText.setTypeface(typeface, Typeface.NORMAL);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void onClick(View v) {
    }
}
