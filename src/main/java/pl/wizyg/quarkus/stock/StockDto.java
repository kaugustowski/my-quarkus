package pl.wizyg.quarkus.stock;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
@Builder
public class StockDto {

    private String name;
    private int count;
    private BigDecimal buyPrice;
    @JsonFormat(pattern="yyyy-MM-dd")
    private LocalDate transactionDate;

    public static StockDto of(Stock stock){
        return StockDto.builder()
                .name(stock.getName())
                .count(stock.getCount())
                .buyPrice(stock.getBuyPrice())
                .transactionDate(stock.getTransactionDate())
                .build();
    }


}
