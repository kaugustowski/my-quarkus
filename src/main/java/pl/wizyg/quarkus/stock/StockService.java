package pl.wizyg.quarkus.stock;

import java.util.List;

public interface StockService {
    void createStock(StockForm stockForm);

    List<StockDto> getAllStocks();

    StockDto getStock(String stockName);

    StockDto getStock(long id);
}
