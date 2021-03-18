package pl.wizyg.quarkus.stock;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
public class StockForm {

    private String name;
    private int count;
    private BigDecimal buyPrice;
    private LocalDate transactionDate;

    public Stock toEntity(StockForm stock){
        return Stock.builder()
                .name(stock.getName())
                .count(stock.getCount())
                .buyPrice(stock.getBuyPrice())
                .transactionDate(stock.getTransactionDate())
                .build();
    }
}
