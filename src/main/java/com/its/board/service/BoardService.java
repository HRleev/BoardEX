package com.its.board.service;

import com.its.board.dto.BoardDTO;
import com.its.board.repository.BoardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class BoardService {
    @Autowired
    private BoardRepository boardRepository;

    public boolean save(BoardDTO boardDTO) {
        int result =boardRepository.save(boardDTO);
        if(result>0){
            return true;
        }else {
            return false;
        }
    }

    public List<BoardDTO> findAll() {
        return boardRepository.findAll();
    }

    public BoardDTO findById(long id) {
        boardRepository.updateHits(id);
        return boardRepository.findById(id);
    }

    public void delete(long id) {
        boardRepository.delete(id);
    }

    public void update(BoardDTO boardDTO) {
        boardRepository.update(boardDTO);
    }

    public void saveFile(BoardDTO boardDTO)throws IOException {
        MultipartFile boardFile = boardDTO.getBoardFile();
        //DTO객체에 담긴 파일을 꺼냄
        String boardFileName=boardFile.getOriginalFilename();
        //파일의 이름을 가져옴
        boardFileName=System.currentTimeMillis()+"-"+boardFileName;
        //파일 이름 중복 방지
        boardDTO.setBoardFileName(boardFileName);
        //파일 이름을 DTO객체의 boardFileName에 저장
        String savePath ="D:\\source\\spring_img\\" +boardFileName;
        //파일의 저장 위치 지정.
        if(!boardFile.isEmpty()){
            boardFile.transferTo(new File(savePath));
            //파일 저장 처리
        }boardRepository.saveFile(boardDTO);
        //DTO객체 repository로 전달
    }
    private static final int PAGE_LIMIT =3;
    private static final int BLOCK_LIMIT=3;
    public List<BoardDTO> pagingList(int page) {
        int pagingStart =(page-1)*PAGE_LIMIT;
        Map<String, Integer> pagingParam=new HashMap<>();
        pagingParam.put("start",pagingStart);
        pagingParam.put("limit",)
    }
}
