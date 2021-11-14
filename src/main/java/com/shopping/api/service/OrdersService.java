package com.shopping.api.service;

import com.shopping.api.domain.orders.Orders;
import com.shopping.api.domain.orders.OrdersRepository;
import com.shopping.api.web.dto.orders.OrdersListResponseDto;
import com.shopping.api.web.dto.orders.OrdersResponseDto;
import com.shopping.api.web.dto.orders.OrdersSaveRequestDto;
import com.shopping.api.web.dto.orders.OrdersUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class OrdersService {
    public final OrdersRepository ordersRepository;

    //주문저장
    @Transactional
    public Long save(OrdersSaveRequestDto requestDto){

        return ordersRepository.save(requestDto.toEntity()).getId();
    }


    //주문 업데이트
    @Transactional
    public Long Update(Long id, OrdersUpdateRequestDto requestDto){
        Orders orders = ordersRepository.findById(id)
                .orElseThrow(()->new IllegalArgumentException("존재하지 않는 주문입니다(주문번호 : "+ id +" )"));
        orders.Update(requestDto.getAddress0(),requestDto.getAddress1(),requestDto.getAddressnum(),requestDto.getPhonenum(),requestDto.getShippingnum(),requestDto.getShipname());
        return id;
    }

    //주문ID별 검색
    @Transactional
    public OrdersResponseDto findById(Long id){
        Orders entity = ordersRepository.findById(id)
                .orElseThrow(()->new IllegalArgumentException("존재하지 않는 주문입니다(주문번호 : "+id+" )"));
        return new OrdersResponseDto(entity);
    }

    //주문 조건별 검색
    @Transactional
    public Page<OrdersListResponseDto> findAllOrdersWithPagination(Long postsid, Long memberid, Date orderdate, Pageable pageable){
        return ordersRepository.findAllOrdersWithPagination(postsid,memberid,orderdate, pageable).map(OrdersListResponseDto::new);
    }

    //주문자 주문 업데이트용
    @Transactional
    public Long userupdate(Long id, OrdersUpdateRequestDto requestDto){
        Orders orders = ordersRepository.findById(id)
                .orElseThrow(()->new IllegalArgumentException("존재하지 않는 주문입니다(주문번호 : "+ id +" )"));
        orders.userupdate(requestDto.getAddress0(),requestDto.getAddress1(),requestDto.getAddressnum(),requestDto.getPhonenum());
        return id;
    }
    //전체 조건 주문 검색(관리자)
    @Transactional
    public List<OrdersListResponseDto> findAllDesc(){
        return ordersRepository.findAllDesc().stream().map(OrdersListResponseDto::new).collect(Collectors.toList());
    }
}
