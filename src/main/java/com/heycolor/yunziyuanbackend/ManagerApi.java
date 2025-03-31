package com.heycolor.yunziyuanbackend;

import com.heycolor.yunziyuanbackend.DAOManage.ManageVO;
import com.heycolor.yunziyuanbackend.DAOManage.ManagerRe;
import com.heycolor.yunziyuanbackend.constant.ReturnInfo;
import com.heycolor.yunziyuanbackend.mapper.ManageMapper;
import com.heycolor.yunziyuanbackend.service.ManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static com.heycolor.yunziyuanbackend.constant.StateCode.SUCCESS;

@RequestMapping("/manage")
@RestController
public class ManagerApi {

    @Autowired
    ManageMapper manageMapper;

    @PostMapping({"/managerOperate"})
    private ResponseEntity<ReturnInfo> managerOperate(@Validated @RequestBody ManageVO vo) {
        Object re = null;
        String operate = vo.getOperate();
        if ("q".equals(operate)) {
            re = manageMapper.getManagerReList(vo);
        }else if ("d".equals(operate)) {
            re = manageMapper.deleteManager(vo) > 0 ? "操作成功":"操作失败";
        } else if ("h".equals(operate)) {
            //恢复密码
        }
        return ResponseEntity.ok()
                .body(ReturnInfo.res(SUCCESS, "", re));
    }

    @PostMapping({"/resourceOperate"})
    private ResponseEntity<ReturnInfo> resourceOperate(@Validated @RequestBody ManageVO vo) {
        Object re = null;
        String operate = vo.getOperate();
        if ("q".equals(operate)) {
            re = manageMapper.getResourceeList(vo);
        } else if ("a".equals(operate)) {
            re = manageMapper.addResource(vo) > 0 ? "操作成功":"操作失败";
        } else if ("d".equals(operate)) {
            re = manageMapper.deleteResource(vo) > 0 ? "操作成功":"操作失败";
        } else if ("u".equals(operate)) {
            re = manageMapper.updateResource(vo) > 0 ? "操作成功":"操作失败";
        }
        return ResponseEntity.ok()
                .body(ReturnInfo.res(SUCCESS, "", re));
    }

    @PostMapping({"/userOperate"})
    private ResponseEntity<ReturnInfo> userOperate(@Validated @RequestBody ManageVO vo) {
        Object re = null;
        String operate = vo.getOperate();
        if ("q".equals(operate)) {
            re = manageMapper.getManagerReList(vo);
        } else if ("u".equals(operate)) {
            re = manageMapper.getResourceeList(vo);
        } else if ("h".equals(operate)) {
            //恢复密码
        }
        return ResponseEntity.ok()
                .body(ReturnInfo.res(SUCCESS, "", re));
    }
}
