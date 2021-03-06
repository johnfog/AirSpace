package com.yyy.xxxx.airspace2.DataBase;

import android.database.Cursor;
import android.database.CursorWrapper;

import com.yyy.xxxx.airspace2.DataBase.BoardSchema.BoardTable;
import com.yyy.xxxx.airspace2.Model.Board;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

/**
 * 커서용 /
 * Created by len on 2017. 3. 30..
 */

public class BoardCursorWrapper extends CursorWrapper {

    public BoardCursorWrapper(Cursor cursor) {
        super(cursor);

    }

    public Board getBoard() throws ParseException {

        String uuidString = getString(getColumnIndex(BoardTable.Cols.UUID));
        String titleString = getString(getColumnIndex(BoardTable.Cols.TITLE));
        String dateString = getString(getColumnIndex(BoardTable.Cols.DATE));
        String contentString = getString(getColumnIndex(BoardTable.Cols.CONTENT));
        String mapPointString = getString(getColumnIndex(BoardTable.Cols.MAPPOINT));
        String photoUrlString = getString(getColumnIndex(BoardTable.Cols.PHOTOURL));

        Board board = new Board(UUID.fromString(uuidString));

        SimpleDateFormat transFormat = new SimpleDateFormat("yyyy-MM-dd");

        Date toTransDate = transFormat.parse(dateString);

        board.setDate(toTransDate);
        board.setTitle(titleString);
        board.setDescription(contentString);
        board.setMapPoint(mapPointString);
        board.setPhotoUri(photoUrlString);

        return board;
    }

    /**
     * String from = "2013-04-08 10:10:10";

     SimpleDateFormat transFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

     Date to = transFormat.parse(from);


     Date from = new Date();

     SimpleDateFormat transFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

     String to = transFormat.format(from);

     */
}
