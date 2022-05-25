package com.its.board.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

import java.sql.Timestamp;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class BoardDTO {
     private long id;
     private String boardTitle;
     private String boardWriter;
     private String boardPassword;
     private String boardContents;
     private int boardHits;
     private Timestamp boardCreatedDate;
     private MultipartFile boardFile;
     private String boardFileName;

}
