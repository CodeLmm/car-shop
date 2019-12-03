package cn.jzdy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import cn.jzdy.dto.DictSelectDto;
import cn.jzdy.request_param.DictParam;
import cn.jzdy.service.DictService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

/**
 * 字典管理
 * Lujingdong
 * 2019年12月1日
 */
@RestController
@RequestMapping("admin/dict")
@Api(tags = "管理端字典模块")
public class DictController {
	@Autowired
	private DictService dictService;
	/**
	 * 查看字典类别下的记录
	 * authod lujingdong
	 * 2019年12月1日
	 * @param dictSelectDto
	 * @return
	 */
	@ApiImplicitParams({
		@ApiImplicitParam(name = "userTicket", value = "用户凭证", paramType = "header", required = true)
	})
	@ApiOperation(value = "查看字典类别下的记录", notes = "查看字典类别下的记录")
	@PostMapping("findDictBySort")
	public Object findOrderList(
			@RequestBody
			@ApiParam(name="dictSelectDto",value="页面传来的参数实体",required = true)
			DictSelectDto dictSelectDto) {
		return dictService.findDictBySort(dictSelectDto);
	}
	
	/**
	 * 查询所有字典的类别
	 * authod lujingdong
	 * 2019年12月3日
	 * @return
	 */
	@ApiImplicitParams({
		@ApiImplicitParam(name = "userTicket", value = "用户凭证", paramType = "header", required = true)
	})
	@ApiOperation(value = "查询所有字典的类别", notes = "根查询所有字典的类别")
	@PostMapping("findAllDictSort")
	public Object findAllDictSort() {
		return dictService.findAllDictSort();
	}
	
	/**
	 * 删除字典类别下的记录
	 * authod lujingdong
	 * 2019年12月3日
	 * @return
	 */
	@ApiImplicitParams({
		@ApiImplicitParam(name = "userTicket", value = "用户凭证", paramType = "header", required = true),
		@ApiImplicitParam(name = "id", value = "字典记录的id", paramType = "query", required = true)
	})
	@ApiOperation(value = "删除字典类别下的记录(真删)", notes = "删除字典类别下的记录(真删)")
	@PostMapping("delectDictRecordById")
	public Object delectDictRecordById(String id) {
		return dictService.delectDictRecordById(id);
	}
	
	/**
	 * 添加字典类别下的记录
	 * authod lujingdong
	 * 2019年12月3日
	 * @return
	 */
	@ApiImplicitParams({
		@ApiImplicitParam(name = "userTicket", value = "用户凭证", paramType = "header", required = true)
	})
	@ApiOperation(value = "添加字典类别下的记录", notes = "添加字典类别下的记录")
	@PostMapping("addDictRecordBySort")
	public Object addDictRecordBySort(
			@RequestParam(value = "file", required = false) MultipartFile file,
			@ApiParam(name="dictParam",value="页面传来的参数实体",required = true)
			DictParam dictParam) {
		return dictService.addDictRecordBySort(dictParam,file);
	}
	
	/**
	 * 修改字典类别下的记录
	 * authod lujingdong
	 * 2019年12月3日
	 * @return
	 */
	@ApiImplicitParams({
		@ApiImplicitParam(name = "userTicket", value = "用户凭证", paramType = "header", required = true)
	})
	@ApiOperation(value = "修改字典类别下的记录", notes = "修改字典类别下的记录")
	@PostMapping("updateDictRecordById")
	public Object updateDictRecordById(
			@RequestParam(value = "file", required = false) MultipartFile file,
			@ApiParam(name="dictParam",value="页面传来的参数实体",required = true)
			DictParam dictParam) {
		return dictService.updateDictRecordById(dictParam,file);
	}
	
}
