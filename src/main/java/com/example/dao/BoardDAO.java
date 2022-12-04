package com.example.dao;

import com.example.bean.BoardVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
@Repository
public class BoardDAO {

@Autowired
    private JdbcTemplate jdbcTemplate;

    private final String BOARD_INSERT = "insert into Board2(name, card, content, price, installment) values (?,?,?,?,?)";
    private final String BOARD_UPDATE = "update Board2 set name =?, card=?, content=?, price=?, installment=? where seq=?";
    private final String BOARD_DELETE = "delete from Board2 where seq=?";

    public int insertBoard(BoardVO vo){
        return jdbcTemplate.update(BOARD_INSERT, new Object[]{vo.getName(),vo.getCard(),vo.getContent(),vo.getPrice(),vo.getInstallment()});
    }

    public int deleteBoard(int id){
        return jdbcTemplate.update(BOARD_DELETE,new Object[]{id});
    }

    public int updateBoard(BoardVO vo){
        return jdbcTemplate.update(BOARD_UPDATE,
                new Object[]{vo.getName(),vo.getCard(),vo.getContent(),vo.getPrice(),vo.getInstallment(),vo.getSeq()});
    }

    private final String BOARD_GET = "select * from Board2 where seq=?";

    public BoardVO getBoard(int seq){
        return jdbcTemplate.queryForObject(BOARD_GET,
                new Object[]{seq},
                new BeanPropertyRowMapper<BoardVO>(BoardVO.class));
    }

    private final String BOARD_LIST = "select * from Board2 order by seq desc";

    public List<BoardVO> getBoardList(){
        return jdbcTemplate.query(BOARD_LIST, new RowMapper<BoardVO>() {
            @Override
            public BoardVO mapRow(ResultSet rs, int rowNum) throws SQLException {
                BoardVO data = new BoardVO();
                data.setSeq(rs.getInt("seq"));
                data.setName(rs.getString("name"));
                data.setCard(rs.getString("card"));
                data.setPrice(rs.getString("price"));
                data.setRegdate(rs.getDate("regdate"));
                data.setContent(rs.getString("content"));
                data.setInstallment(rs.getString("installment"));
                data.setCnt(rs.getInt("cnt"));
                return data;
            }
        });
    }




}
