package com.example.socialmedia2.base;
import java.util.List;

public interface BaseMapper<T extends BaseEntity
        , D extends BaseDto>  {

    T convertDtoToT(D d);

    D convertTToDto(T t);

    List<T> convertListDtoToListEntity(List<D> dList);

    List<D> convertListEntityToListDto(List<T> tList);

}
