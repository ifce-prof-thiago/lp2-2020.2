package com.ifce.lp2;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("statistics")
public class RevisaoController {

    static List<Integer> sample = new ArrayList<>();

    @GetMapping
    public Statistic search(Integer x) {
        sample.add(x);

        var statistic = new Statistic();
        statistic.setAvg(sample.stream().mapToDouble(a -> a).average().orElse(0.0));
        statistic.setMin(sample.stream().mapToDouble(v -> v).min().orElse(0.0));
        statistic.setMax(sample.stream().mapToDouble(v -> v).max().orElse(0.0));
        statistic.setElements(sample);

        return statistic;
    }

}
