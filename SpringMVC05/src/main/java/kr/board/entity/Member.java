package kr.board.entity;

import java.util.List;

import lombok.Data;

@Data
public class Member {
	  private int memIdx; 
	  private String memID;  
	  private String memPassword;
	  private String memName;
	  private int memAge; // <-null, 0
	  private String memGender;
	  private String memEmail;
	  private String memProfile; //사진정보
	  private List<AuthVO> authList; 
	  //authList[0].auth, authList[1].auth, authList[2].auth
}
