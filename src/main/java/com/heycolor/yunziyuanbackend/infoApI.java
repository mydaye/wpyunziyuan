package com.heycolor.yunziyuanbackend;

import com.heycolor.yunziyuanbackend.DAOinfo.Request.addParams;
import com.heycolor.yunziyuanbackend.DAOinfo.addBean;
import com.heycolor.yunziyuanbackend.DAOinfo.infoBean;
import com.heycolor.yunziyuanbackend.constant.ReturnInfo;
import com.heycolor.yunziyuanbackend.service.infoService;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

import static com.heycolor.yunziyuanbackend.constant.StateCode.*;

@RequestMapping("/info")
@RestController
public class infoApI {
    private final infoService xInfo;

    public infoApI(infoService xInfo) {
        this.xInfo = xInfo;
    }
    @GetMapping({"/getData/all"})
    private ResponseEntity<ReturnInfo> userGetData() {
        List<infoBean> dbData = xInfo.selectInfo();
        if (!dbData.isEmpty()) {
            return ResponseEntity.ok()
                    .body(ReturnInfo.res(SUCCESS, "", dbData));
        }
        return ResponseEntity.ok()
                .body(ReturnInfo.res(NOT_LOGGED_IN, "", dbData));

    }
    @PostMapping({"/add"})
    private ResponseEntity<ReturnInfo> infoToAdd(@Validated @RequestBody addParams bao) {
        if (bao.getData_title() != null) {
            // 更新时间
            Date addTime = new Date();
            int dbData = xInfo.infoAdd(new addBean(
                    bao.getData_title(),
                    bao.getData_img_list(),
                    bao.getData_img_mx(),
                    bao.getData_url(),
                    bao.isData_good(),
                    bao.getData_dir(),
                    bao.getData_type(),
                    bao.getData_country(),
                    bao.getData_year(),
                    bao.getData_note(),
                    0,
                    0,
                    addTime));
            if (dbData>0) {
                return ResponseEntity.ok()
                        .body(ReturnInfo.res(SUCCESS, "", null));
            }
        }
        return ResponseEntity.ok()
                .body(ReturnInfo.res(NOT_LOGGED_IN, "", null));

    }
}
