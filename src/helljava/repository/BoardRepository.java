package helljava.repository;

import helljava.DB.MemoryDB;
import helljava.domain.Board;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by yongjunjung on 2016. 7. 25..
 */
public class BoardRepository {

    public void write(String username, String title, String content) {

        Board board = new Board(title,content ,username);
        MemoryDB.boardList.add(board);
    }

    public List<Board> findAll(String searchWord) {

        List<Board> boardList = MemoryDB.boardList;

        List<Board> collect = boardList.stream()
                .filter(b -> searchWord == null || b.getContent().contains(searchWord) || b.getUsername().contains(searchWord) || b.getTitle().contains(searchWord) || "".equals(searchWord))
                .collect(Collectors.toList());

        return collect;
    }

    public List<Board> findbyContent(String searchWord) {

        ArrayList<Board> boardList = MemoryDB.boardList;

        List<Board> collect = boardList.stream()
                .filter(b -> b.getContent().contains(searchWord))
                .collect(Collectors.toList());

        return collect;
    }

    public List<Board> findbyName(String searchWord) {

        ArrayList<Board> boardList = MemoryDB.boardList;

        List<Board> collect = boardList.stream()
                .filter(b -> b.getUsername().contains(searchWord))
                .collect(Collectors.toList());

        return collect;
    }

    public List<Board> findbyTitle(String searchWord) {

        ArrayList<Board> boardList = MemoryDB.boardList;

        List<Board> collect = boardList.stream()
                .filter(b -> b.getTitle().contains(searchWord))
                .collect(Collectors.toList());

        return collect;
    }

}