package designpatterns.connect4.models;


import designpatterns.connect4.types.Color;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class BoardBuilder {

    private List<String> rows;

    public BoardBuilder(){
        this.rows = new ArrayList<String>();
    }

    public BoardBuilder rows(String... rows){
        assert rows.length > 0 && rows.length <= 6;

        for(String row: rows){
            assert Pattern.matches("[YR ]{7}", row);
            this.rows.add(row);
        }
        return this;
    }

    public Board build() {
        Board board = new Board();
        if(!this.rows.isEmpty()){
            for (int i = 0; i < 6; i++){
                String string;
                if(i >= this.rows.size()){
                    string = "       ";
                }else {
                    string = this.rows.get(i);
                }

                for (int j = 0; j < string.length(); j++){
                    board.putToken(j + 1, Color.get(string.charAt(j)));
                }
            }
        }
        return board;
    }
}
