package cn.jzdy.service;

import org.springframework.web.multipart.MultipartFile;

import cn.jzdy.dto.DictSelectDto;
import cn.jzdy.request_param.DictParam;

public interface DictService {

	Object findDictBySort(DictSelectDto dictSelectDto);

	Object findAllDictSort();

	Object delectDictRecordById(String id);

	Object addDictRecordBySort(DictParam dictParam, MultipartFile file);

	Object updateDictRecordById(DictParam dictParam, MultipartFile file);

}
