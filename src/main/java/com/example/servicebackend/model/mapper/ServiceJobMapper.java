package com.example.servicebackend.model.mapper;

import com.example.servicebackend.model.dto.ServiceJobDto;
import com.example.servicebackend.model.entity.ServiceJob;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Component;

@Mapper
public interface ServiceJobMapper {
     ServiceJobMapper INSTANCE = Mappers.getMapper(ServiceJobMapper.class);

     ServiceJobDto toDto(ServiceJob serviceJob);

     ServiceJob toEntity(ServiceJobDto serviceJobDto);
}


//@Mapper
//public interface ProductMapper {
//
//    ProductMapper INSTANCE = Mappers.getMapper(ProductMapper.class);
//
//    @Mapping(target = "shopName", source = "shopProduct.shopName")
//    @Mapping(target = "shopId", source = "shopProduct.id")
//    @Mapping(target = "categoryName", source = "category.categoryName")
//    @Mapping(target = "categoryId", source = "category.id")
//    ProductDTO toDTO(Product product);
//
//    @Mapping(target = "reportList", ignore = true)
//    @Mapping(target = "wishlistList", ignore = true)
//    @Mapping(target = "status", ignore = true)
//    @Mapping(target = "orderDetailList", ignore = true)
//    @Mapping(target = "productImageList", ignore = true)
//    @Mapping(target = "shopProduct", source = "shopId", qualifiedByName = "mapShop")
//    @Mapping(target = "category", source = "categoryId", qualifiedByName = "mapCategory")
//    Product toEntity(ProductDTO dto);
//
//    @Named("mapShop")
//    default Shop mapShop(Integer id) {
//        Shop shop = new Shop();
//        shop.setId(id);
//        return shop;
//    }
//
//    @Named("mapCategory")
//    default Category mapCategory(Integer id) {
//        Category c = new Category();
//        c.setId(id);
//        return c;
//    }
//
//    @AfterMapping
//    default void getTotalRating(@MappingTarget ProductDTO dto, Product product) {
//        dto.setTotalRating(
//                product.getOrderDetailList()
//                        .stream()
//                        .mapToLong(orderDetail -> orderDetail.getProductOrderDetail().getRating())
//                        .filter(rating -> rating > 0)
//                        .count()
//        );
//    }
//}