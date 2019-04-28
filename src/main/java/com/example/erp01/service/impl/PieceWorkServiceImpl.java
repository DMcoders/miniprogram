package com.example.erp01.service.impl;

import com.example.erp01.mapper.PieceWorkMapper;
import com.example.erp01.model.PieceWork;
import com.example.erp01.service.PieceWorkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class PieceWorkServiceImpl implements PieceWorkService {

    @Autowired
    private PieceWorkMapper pieceWorkMapper;

    @Override
    public int addPieceWorkBatch(List<PieceWork> pieceWorkList) {
        try{
            pieceWorkMapper.addPieceWorkBatch(pieceWorkList);
            return 0;
        }catch (Exception e){
            e.printStackTrace();
        }
        return 1;
    }

    @Override
    public int addPieceWork(PieceWork pieceWork) {
        try{
            pieceWorkMapper.addPieceWork(pieceWork);
            return 0;
        }catch (Exception e){
            e.printStackTrace();
        }
        return 1;
    }

    @Override
    public int deletePieceWork(Integer id) {
        try{
            pieceWorkMapper.deletePieceWork(id);
            return 0;
        }catch (Exception e){
            e.printStackTrace();
        }
        return 1;
    }

    @Override
    public PieceWork getPieceWorkByID(Integer id) {
        PieceWork pieceWork = null;
        try{
            pieceWork = pieceWorkMapper.getPieceWorkByID(id);
            return pieceWork;
        }catch (Exception e){
            e.printStackTrace();
        }
        return pieceWork;

    }

    @Override
    public List<PieceWork> getAllPieceWork() {
        List<PieceWork> pieceWorkList = new ArrayList<>();
        try{
            pieceWorkList = pieceWorkMapper.getAllPieceWork();
            return pieceWorkList;
        }catch (Exception e){
            e.printStackTrace();
        }
        return pieceWorkList;
    }

    @Override
    public List<PieceWork> getPieceWorkByEmpNum(String employeeNumber) {
        List<PieceWork> pieceWorkList = new ArrayList<>();
        try{
            pieceWorkList = pieceWorkMapper.getPieceWorkByEmpNum(employeeNumber);
            return pieceWorkList;
        }catch (Exception e){
            e.printStackTrace();
        }
        return pieceWorkList;
    }

    @Override
    public List<PieceWork> getPieceWorkByTime(Date from, Date to) {
        List<PieceWork> pieceWorkList = new ArrayList<>();
        try{
            pieceWorkList = pieceWorkMapper.getPieceWorkByTime(from,to);
            return pieceWorkList;
        }catch (Exception e){
            e.printStackTrace();
        }
        return pieceWorkList;
    }

    @Override
    public List<PieceWork> getPieceWorkByEmpNumTime(String employeeNumber, Date from, Date to) {
        List<PieceWork> pieceWorkList = new ArrayList<>();
        try{
            pieceWorkList = pieceWorkMapper.getPieceWorkByEmpNumTime(employeeNumber, from, to);
            return pieceWorkList;
        }catch (Exception e){
            e.printStackTrace();
        }
        return pieceWorkList;
    }

    @Override
    public List<PieceWork> getDetailPieceWork(Date from, Date to, String groupName, String employeeNumber) {
        List<PieceWork> pieceWorkList = new ArrayList<>();
        try{
            pieceWorkList = pieceWorkMapper.getDetailPieceWork(from, to, groupName, employeeNumber);
            return pieceWorkList;
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<PieceWork> getPieceWorkToday() {
        List<PieceWork> pieceWorkList = new ArrayList<>();
        try{
            pieceWorkList = pieceWorkMapper.getPieceWorkToday();
            return pieceWorkList;
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<PieceWork> getPieceWorkThisMonth() {
        List<PieceWork> pieceWorkList = new ArrayList<>();
        try{
            pieceWorkList = pieceWorkMapper.getPieceWorkThisMonth();
            return pieceWorkList;
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<PieceWork> getPieceWorkEmpToday(String employeeNumber) {
        List<PieceWork> pieceWorkList = new ArrayList<>();
        try{
            pieceWorkList = pieceWorkMapper.getPieceWorkEmpToday(employeeNumber);
            return pieceWorkList;
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<PieceWork> getPieceWorkEmpThisMonth(String employeeNumber) {
        List<PieceWork> pieceWorkList = new ArrayList<>();
        try{
            pieceWorkList = pieceWorkMapper.getPieceWorkEmpThisMonth(employeeNumber);
            return pieceWorkList;
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Object> queryPieceWorkToday(String groupName, String employeeNumber) {
        List<Object> objectList = new ArrayList<>();
        try{
            objectList = pieceWorkMapper.queryPieceWorkToday(groupName, employeeNumber);
            return objectList;
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Object> queryPieceWorkThisMonth(String groupName, String employeeNumber) {
        List<Object> objectList = new ArrayList<>();
        try{
            objectList = pieceWorkMapper.queryPieceWorkThisMonth(groupName, employeeNumber);
            return objectList;
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Object> queryPieceWork(Date from, Date to, String groupName, String employeeNumber) {
        List<Object> objectList = new ArrayList<>();
        try{
            objectList = pieceWorkMapper.queryPieceWork(from, to, groupName, employeeNumber);
            return objectList;
        }catch (Exception e){
            e.printStackTrace();
        }
        return objectList;
    }
}
