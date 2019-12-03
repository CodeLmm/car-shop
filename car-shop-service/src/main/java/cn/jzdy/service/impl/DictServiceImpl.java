package cn.jzdy.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import cn.jzdy.dao.DictMapper;
import cn.jzdy.dto.DictSelectDto;
import cn.jzdy.message.ResultMsg;
import cn.jzdy.request_param.DictParam;
import cn.jzdy.response.ErrorResult;
import cn.jzdy.response.SuccessResult;
import cn.jzdy.service.DictService;
import cn.jzdy.util.FileUploadUtils;
import cn.jzdy.util.id.UuidUtils;
@Service
@Transactional(rollbackFor = Exception.class)
public class DictServiceImpl implements DictService {
	@Autowired
	private DictMapper dictMapper;
	
	@Override
	public Object findDictBySort(DictSelectDto dictSelectDto) {
		dictSelectDto.init();
		long count = dictMapper.findDictCountBySort(dictSelectDto);
		List<Map<String,Object>> data = dictMapper.findDictBySort(dictSelectDto);
		return new SuccessResult<>(dictSelectDto.pageResponse(data, count));
	}
	
	@Override
	public Object findAllDictSort() {
		return new SuccessResult<>(dictMapper.findAllDictSort());
	}

	@Override
	public Object delectDictRecordById(String id) {
		dictMapper.delectDictRecordById(id);
		return new SuccessResult<>(ResultMsg.DELETE_SUCCESS);
	}
	
	@Override
	public Object addDictRecordBySort(DictParam dictParam,MultipartFile file) {
		dictParam.setId(UuidUtils.getUuid());
		dictParam.setKey(UuidUtils.getUuid().substring(0,20));
		if(file!=null) {
			dictParam.setImageUrl(FileUploadUtils.upload(file));
		}
		List<String> sortList = dictMapper.findAllDictSort();
		if(!sortList.contains(dictParam.getSort())) {
			return new ErrorResult<>("找不到字典类别");
		}
		dictMapper.addDictRecordBySort(dictParam);
		return new SuccessResult<>(ResultMsg.ADD_SUCCESS);
	}

	@Override
	public Object updateDictRecordById(DictParam dictParam, MultipartFile file) {
		dictMapper.updateDictRecordById(dictParam);
		return new SuccessResult<>(ResultMsg.UPDATE_SUCCESS);
	}
	
}
