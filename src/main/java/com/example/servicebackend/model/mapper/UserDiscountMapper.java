package com.example.servicebackend.model.mapper;

import com.example.servicebackend.model.dto.UserDiscountDto;
import com.example.servicebackend.model.entity.DiscountExchange;
import com.example.servicebackend.model.entity.PaymentTransaction;
import com.example.servicebackend.model.entity.RewardPoint;
import com.example.servicebackend.model.entity.UserDiscount;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UserDiscountMapper {
    UserDiscountMapper INSTANCE = Mappers.getMapper(UserDiscountMapper.class);

    @Mapping(target = "discountExchangeId", source = "discountExchange.discountExchangeId")
    @Mapping(target = "paymentTransactionId", source = "paymentTransaction.paymentTransactionId")
    @Mapping(target = "rewardPointId", source = "rewardPoint.rewardPointId")
    UserDiscountDto toDto(UserDiscount userDiscount);

    @Mapping(target = "discountExchange", source = "discountExchangeId", qualifiedByName = "discountExchangeIdToDiscountExchange")
    @Mapping(target = "paymentTransaction", source = "paymentTransactionId", qualifiedByName = "paymentTransactionIdToPaymentTransaction")
    @Mapping(target = "rewardPoint", source = "rewardPointId", qualifiedByName = "rewardPointIdToRewardPoint")
    UserDiscount toEntity(UserDiscountDto userDiscountDto);

    @Named("discountExchangeIdToDiscountExchange")
    default DiscountExchange discountExchangeIdToDiscountExchange(Long discountExchangeId) {
        DiscountExchange discountExchange = new DiscountExchange();
        discountExchange.setDiscountExchangeId(discountExchangeId);
        return discountExchange;
    }

    @Named("paymentTransactionIdToPaymentTransaction")
    default PaymentTransaction paymentTransactionIdToPaymentTransaction(Long paymentTransactionId) {
        PaymentTransaction paymentTransaction = new PaymentTransaction();
        paymentTransaction.setPaymentTransactionId(paymentTransactionId);
        return paymentTransaction;
    }

    @Named("rewardPointIdToRewardPoint")
    default RewardPoint rewardPointIdToRewardPoint(Long rewardPointId) {
        RewardPoint rewardPoint = new RewardPoint();
        rewardPoint.setRewardPointId(rewardPointId);
        return rewardPoint;
    }
}
