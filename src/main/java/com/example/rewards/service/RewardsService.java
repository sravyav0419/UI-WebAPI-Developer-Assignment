package com.example.rewards.service;

import com.example.rewards.model.Transaction;
import com.example.rewards.model.RewardsResponse;
import org.springframework.stereotype.Service;

import java.time.format.TextStyle;
import java.util.*;
import java.time.LocalDate;
import java.util.stream.Collectors;

@Service
public class RewardsService {

    private final List<Transaction> transactions = List.of(
        new Transaction("C001", 120, LocalDate.of(2025, 3, 5)),
        new Transaction("C001", 75, LocalDate.of(2025, 3, 18)),
        new Transaction("C001", 200, LocalDate.of(2025, 4, 10)),
        new Transaction("C002", 95, LocalDate.of(2025, 3, 8)),
        new Transaction("C002", 130, LocalDate.of(2025, 5, 15))
    );

    public List<RewardsResponse> calculateRewards() {
        Map<String, Map<String, Integer>> customerMonthlyPoints = new HashMap<>();

        for (Transaction tx : transactions) {
            int points = calculatePoints(tx.getAmount());
            String month = tx.getDate().getMonth().getDisplayName(TextStyle.SHORT, Locale.ENGLISH) + " " + tx.getDate().getYear();

            customerMonthlyPoints
                .computeIfAbsent(tx.getCustomerId(), k -> new HashMap<>())
                .merge(month, points, Integer::sum);
        }

        List<RewardsResponse> responseList = new ArrayList<>();
        for (Map.Entry<String, Map<String, Integer>> entry : customerMonthlyPoints.entrySet()) {
            int total = entry.getValue().values().stream().mapToInt(Integer::intValue).sum();
            responseList.add(new RewardsResponse(entry.getKey(), entry.getValue(), total));
        }

        return responseList;
    }

    private int calculatePoints(double amount) {
        int points = 0;
        if (amount > 100) {
            points += (int) ((amount - 100) * 2) + 50;
        } else if (amount > 50) {
            points += (int) (amount - 50);
        }
        return points;
    }
}
