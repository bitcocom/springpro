package kr.board.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import kr.board.entity.Board;

@Mapper //- Mybatis API
public interface BoardMapper {	 
     public List<Board> getLists();
     public void boardInsert(Board vo); 
     public Board boardContent(int idx);
     public void boardDelete(int idx);
}
