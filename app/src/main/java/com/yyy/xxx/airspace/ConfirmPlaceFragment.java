package com.yyy.xxx.airspace;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.yyy.xxx.airspace.Model.Board;
import com.yyy.xxx.airspace.Model.BoardLab;

import java.text.ParseException;
import java.util.UUID;

import butterknife.BindView;


/**
 * Created by len on 2017. 4. 15..
 */

<<<<<<< HEAD
public class ConfirmPlaceFragment extends DialogFragment implements ACTIVITY_REQUEST{
=======
public class ConfirmPlaceFragment extends DialogFragment implements ACTIVITY_REQUEST {
>>>>>>>  - 쓸모없는 부분 정리 / 1차 완

    private static final String TAG = ConfirmPlaceFragment.class.getName();

    private static final String ARG_TITLE = "title";
    private static final String ARG_DESC = "description";
    private static final String ARG_UUID = "uuid";
    @BindView(R.id.alert_title)
    TextView alertTitleTextView;

    @BindView(R.id.alert_description)
    TextView alertDescTextView;

    @BindView(R.id.btn_Dialog_MoveToDetailed)
    Button moveTodetailedButton;

    @BindView(R.id.btn_Dialog_Change)
    Button changeButton;

    @BindView(R.id.btn_Dialog_Delete)
    Button deleteButton;

    @BindView(R.id.btn_Dialog_cancel)
    Button cancelButton;

    public ConfirmPlaceFragment() {
    }

    public static ConfirmPlaceFragment newInstance(String id, String title, String desc){
        Bundle args = new Bundle();
        args.putSerializable(ARG_UUID, id);
        args.putSerializable(ARG_TITLE, title);
        args.putSerializable(ARG_DESC, desc);

        ConfirmPlaceFragment fragment = new ConfirmPlaceFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        super.onCreateDialog(savedInstanceState);

        final String id = (String) getArguments().getSerializable(ARG_UUID);
        String desc = (String) getArguments().getSerializable(ARG_DESC);
        String title = (String) getArguments().getSerializable(ARG_DESC);

        View view = LayoutInflater.from(getActivity())
                .inflate(R.layout.dialog_detailcomfirm_message, null);

        alertTitleTextView = (TextView) view.findViewById(R.id.alert_title);
        alertDescTextView = (TextView) view.findViewById(R.id.alert_description);

        moveTodetailedButton = (Button) view.findViewById(R.id.btn_Dialog_MoveToDetailed);
        changeButton = (Button) view.findViewById(R.id.btn_Dialog_Change);
        deleteButton = (Button) view.findViewById(R.id.btn_Dialog_Delete);
        cancelButton = (Button) view.findViewById(R.id.btn_Dialog_cancel);

        moveTodetailedButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //TODO 해당 카드로 이동하기

            }
        });

        changeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent confirmIntent = AddBoardActivity.newIntent(getActivity(), UUID.fromString(id));
                startActivity(confirmIntent);
                Log.d(TAG, "확인 버튼 누름");
            }
        });

        deleteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
<<<<<<< HEAD
                //TODO 해당 데이터베이스를 찾아 지워버리기
=======
                //TODO 해당 데이터베이스를 찾아 지워버리기,MAP REFRESH
>>>>>>>  - 쓸모없는 부분 정리 / 1차 완
                try {
                    Board board = BoardLab.getBoardLab(getActivity()).getBoard(UUID.fromString(id));
                    Log.d(TAG, board.getUUID() + "");
                    BoardLab.getBoardLab(getActivity()).deleteBoard(board);
<<<<<<< HEAD

                    dismiss();

                    //리프레쉬해줄수 있는 방법

                } catch (ParseException e) {
                    e.printStackTrace();
                }

=======
                    dismiss();
                    //리프레쉬해줄수 있는 방법
                } catch (ParseException e) {
                    e.printStackTrace();
                }
>>>>>>>  - 쓸모없는 부분 정리 / 1차 완
            }
        });

        cancelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss();
            }
        });
        alertTitleTextView.setText(title);
        alertDescTextView.setText(desc);


        return new AlertDialog.Builder(getActivity())
                .setView(view)
                .create();
    }

    private void reload() {

    }
}
