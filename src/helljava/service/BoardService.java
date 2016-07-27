package helljava.service;

import helljava.domain.Board;
import helljava.repository.BoardRepository;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by yongjunjung on 2016. 7. 26..
 */
public class BoardService {

    public static final String ALL_QUERY = "ALL";
    public static final String NAME_QUERY = "NAME";
    public static final String CONTENT_QUERY = "CONTENT";
    public static final String TITLE_QUERY = "TITLE";

    BoardRepository boardRepository = new BoardRepository();

    public List<Board> boardList(HttpServletRequest request) {

        String searchWord = request.getParameter("searchWord");
        String queryInput = request.getParameter("queryInput");

        if (ALL_QUERY.equals(queryInput) || queryInput == null) {
            return boardRepository.findAll(searchWord);
        } else if (NAME_QUERY.equals(queryInput)) {
            return boardRepository.findbyName(searchWord);
        } else if (CONTENT_QUERY.equals(queryInput)) {
            return boardRepository.findbyContent(searchWord);
        } else if (TITLE_QUERY.equals(queryInput)) {
            return boardRepository.findbyTitle(searchWord);
        }

        throw new IllegalArgumentException("Board Search Exception!!");

    }

}
