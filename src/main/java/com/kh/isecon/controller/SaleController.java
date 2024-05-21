package com.kh.isecon.controller;
import com.kh.isecon.dao.CartDao;
import com.kh.isecon.dao.SaleDao;
import com.kh.isecon.vo.ProductVo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/isecon/sale")
@RequiredArgsConstructor

public class SaleController {
    @GetMapping("/allsale") // 결제내역 보기
    public ResponseEntity<List<ProductVo>> allSaleSelect(@RequestParam("uno") int uno) {
        SaleDao dao = new SaleDao();
        return ResponseEntity.ok(dao.saleView(uno));
    }

}
