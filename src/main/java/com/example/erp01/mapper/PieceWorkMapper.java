package com.example.erp01.mapper;

import com.example.erp01.model.PieceWork;
import org.apache.ibatis.annotations.Mapper;

import java.util.Date;
import java.util.List;

@Mapper
public interface PieceWorkMapper {

    int addPieceWorkBatch(List<PieceWork> pieceWorkList);

    int addPieceWork(PieceWork pieceWork);

    int deletePieceWork(Integer id);

    PieceWork getPieceWorkByID(Integer id);

    List<PieceWork> getAllPieceWork();

    List<PieceWork> getPieceWorkByEmpNum(String employeeNumber);

    List<PieceWork> getPieceWorkByTime(Date from, Date to);

    List<PieceWork> getPieceWorkByEmpNumTime(String employeeNumber,Date from, Date to);

    List<PieceWork> getDetailPieceWork(Date from, Date to, String groupName, String employeeNumber);

    List<Object> getPieceWorkToday();

    List<Object> getPieceWorkThisMonth();

    List<PieceWork> getPieceWorkEmpToday(String employeeNumber);

    List<PieceWork> getPieceWorkEmpThisMonth(String employeeNumber);

    List<Object> queryPieceWorkToday(String groupName, String employeeNumber);

    List<Object> queryPieceWorkThisMonth(String groupName, String employeeNumber);

    List<Object> queryPieceWork(Date from, Date to, String groupName, String employeeNumber);

}
