package com.vet.main.approval.format;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;


@Mapper
public interface ApFormatDAO {
	
	public int setFormatAdd(ApFormatVO apFormatVO) throws Exception;

	public List<ApFormatVO> getFormatList(ApFormatVO apFormatVO);
	
	public ApFormatVO getFormatDetail(ApFormatVO apFormatVO) throws Exception;

	public int setFormatUpdate(ApFormatVO apFormatVO);

}
