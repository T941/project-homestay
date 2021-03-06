package com.example.airbnb.controller;


import com.example.airbnb.model.CategoryRoom;
import com.example.airbnb.service.CategoryRoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin("*")

@RequestMapping("/category/room")

public class CategoryRoomController {
    @Autowired
    private CategoryRoomService categoryRoomService;

    @GetMapping

    public ResponseEntity<Iterable<CategoryRoom>> getAll() {
        Iterable<CategoryRoom> categoryRooms = categoryRoomService.findAll();
        return new ResponseEntity<>(categoryRooms, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<CategoryRoom> create(@RequestBody CategoryRoom categoryRoom) {
        categoryRoomService.save(categoryRoom);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CategoryRoom> edit(@PathVariable("id") Long id, @RequestBody CategoryRoom newCategoryRoom) {
        Optional<CategoryRoom> oldCategoryRoom = categoryRoomService.findById(id);
        if (oldCategoryRoom.isPresent()) {
            oldCategoryRoom.get().setName(newCategoryRoom.getName());

            categoryRoomService.save(oldCategoryRoom.get());
            return new ResponseEntity("thanh cong", HttpStatus.OK);
        } else {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }
}
