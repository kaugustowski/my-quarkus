package pl.wizyg.quarkus.stock;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class StockMapper {

    public Stock mapToEntity(StockForm form) {
        return Stock.builder()
                .buyPrice(form.getBuyPrice())
                .name(form.getName())
                .count(form.getCount())
                .transactionDate(form.getTransactionDate())
                .build();
    }

    public StockDto mapToDto(Stock stock){
        return StockDto.of(stock);
    }

}
