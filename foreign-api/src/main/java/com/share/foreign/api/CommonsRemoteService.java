package com.share.foreign.api;

import com.share.foreign.wrapper.BaseDTO;
import com.share.foreign.wrapper.ResponseTemplate;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

/**
 * @author cuimeng
 */
@FeignClient(
    name = "${remote.service.openfeign.name}",
    contextId = "commons",
    path = "${remote.service.openfeign.path}")
public interface CommonsRemoteService {

  /**
   * @Description: 公共查询接口
   * @Date: 7/20/22 9:42 AM
   * @Author: Mr.Cui
   * @param requestMap
   * @return: ResponseTemplate<Map>
   **/
  @RequestMapping("/commons/queryCommons")
  @ResponseBody
  ResponseTemplate<Map> queryCommons(@RequestBody BaseDTO<Map> requestMap);
}
