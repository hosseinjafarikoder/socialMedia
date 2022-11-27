package com.example.socialmedia2.base;

import com.example.socialmedia2.dto.NullChecking;
import com.example.socialmedia2.exceptions.BaseException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.io.Serializable;
import java.util.List;

@RequiredArgsConstructor
public abstract class BaseRestController<D extends BaseDto,
        E extends BaseEntity,
        M extends BaseMapper<E, D>,
        S extends BaseService<E, ID>,
        ID extends Serializable> {

    protected final S service;
    protected final M mapper;

    @PostMapping
    public ResponseEntity<D> add(@Validated(NullChecking.class) @RequestBody D d) throws BaseException {
        E e = mapper.convertDtoToT(d);
        return ResponseEntity.ok(
                mapper.convertTToDto(
                        service.saveOrUpdate(e)
                )
        );
    }

    @PutMapping
    public ResponseEntity<D> update(@Valid @RequestBody D d) throws BaseException {
        E e = mapper.convertDtoToT(d);
        return ResponseEntity.ok(
                mapper.convertTToDto(
                        service.saveOrUpdate(e)
                )
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity<D> findById(@PathVariable ID id) throws BaseException {
        return ResponseEntity.ok(
                mapper.convertTToDto(
                        service.findById(id)
                )
        );
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable ID id) throws BaseException {
        service.findById(id);
        service.deleteById(id);
    }

    @GetMapping
    public ResponseEntity<List<D>> findAll() throws BaseException {
        List<E> all = service.findAll();
        return ResponseEntity.ok(
                mapper.convertListEntityToListDto(all)
        );
    }
}
