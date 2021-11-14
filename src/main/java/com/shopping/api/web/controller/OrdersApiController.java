package com.shopping.api.web.controller;

import com.shopping.api.service.OrdersService;
import com.shopping.api.web.dto.orders.OrdersListResponseDto;
import com.shopping.api.web.dto.orders.OrdersResponseDto;
import com.shopping.api.web.dto.orders.OrdersSaveRequestDto;
import com.shopping.api.web.dto.orders.OrdersUpdateRequestDto;
import com.shopping.api.web.dto.posts.PostsSaveRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;

@CrossOrigin(origins = "*", allowedHeaders = "*") //CORS허용
@RequiredArgsConstructor
@RestController
public class OrdersApiController {
    private final OrdersService ordersService;

    @PostMapping("/api/v1/orders") //주문저장
    public Long save(@RequestBody OrdersSaveRequestDto requestDto){
        return ordersService.save(requestDto);
    }

    @PutMapping("/api/v1/orders/admin/{id}") //업데이트
    public Long update(@PathVariable Long id, @RequestBody OrdersUpdateRequestDto requestDto){
        return ordersService.Update(id, requestDto);
    }

    @PutMapping("/api/v1/orders/{id}") //유저가 업데이트 할수있는 것만
    public Long userupdate(@PathVariable Long id, @RequestBody OrdersUpdateRequestDto requestDto){
        return ordersService.userupdate(id, requestDto);
    }

    @GetMapping("/api/v1/orders/{id}") //주문번호별 조회
    public OrdersResponseDto findById(@PathVariable Long id){
        return ordersService.findById(id);
    }

    @GetMapping("/api/v1/orders/list") //주문목록 페이지
    public Page<OrdersListResponseDto> findAllOrdersWithPagination(@RequestParam(value = "postsid",required = false) Long postsid,
                                                                   @RequestParam(value = "memberid",required = false) Long memberid,
                                                                   @RequestParam(value = "orderdate",required = false) Date orderdate,
                                                                   @PageableDefault(size = 20, sort = "id") Pageable pageable){
        return ordersService.findAllOrdersWithPagination(postsid,memberid,orderdate,pageable);
    }
}
