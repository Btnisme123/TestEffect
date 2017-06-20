package com.example.nguyenvulan.framgia.testblureffect.fragment;

import android.annotation.SuppressLint;
import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.nguyenvulan.framgia.testblureffect.R;
import com.example.nguyenvulan.framgia.testblureffect.activity.DetailActivity;
import com.example.nguyenvulan.framgia.testblureffect.util.CardAdapter;


public class CardFragment extends Fragment {

    private CardView cardView;
    private int mPosition;

    public static Fragment getInstance(int position) {
        CardFragment f = new CardFragment();
        return f;
    }

    @SuppressLint("DefaultLocale")
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.item_viewpager, container, false);

        cardView = (CardView) view.findViewById(R.id.cardView);
        cardView.setMaxCardElevation(cardView.getCardElevation() * CardAdapter.MAX_ELEVATION_FACTOR);

        TextView title = (TextView) view.findViewById(R.id.title);
        Button button = (Button) view.findViewById(R.id.button);
        TextView content = (TextView) view.findViewById(R.id.text_view);
        title.setText(String.format("Card %d", getPosition()));
        content.setText(MapFragment.sMarkers.get(getPosition()).getText());
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), DetailActivity.class);
                startActivity(intent);
            }
        });

        return view;
    }

    public int getPosition() {
        return mPosition;
    }

    public void setPosition(int position) {
        mPosition = position;
    }

    public CardView getCardView() {
        return cardView;
    }
}
