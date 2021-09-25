package com.learning.springboot.model;

import com.learning.springboot.entity.Expense;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class Expenses {
    private List<Expense> expense = new ArrayList<>();
}
