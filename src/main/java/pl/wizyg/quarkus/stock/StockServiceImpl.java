package pl.wizyg.quarkus.stock;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@ApplicationScoped
public class StockServiceImpl implements StockService {

    private final StockRepository stockRepository;
    private final StockMapper stockMapper;

    @Inject
    public StockServiceImpl(StockRepository stockRepository, StockMapper stockMapper) {
        this.stockRepository = stockRepository;
        this.stockMapper = stockMapper;
    }

    @Override
    public void createStock(StockForm stockForm) {
        stockRepository.createStock(stockMapper.mapToEntity(stockForm));
    }

    @Override
    public List<StockDto> getAllStocks() {
        return stockRepository.findAllStocks()
                .stream()
                .map(stockMapper::mapToDto)
                .collect(Collectors.toList());
    }

    @Override
    public StockDto getStock(String stockName) {
        return stockRepository.findByStockName(stockName)
                .map(stockMapper::mapToDto)
                .orElseThrow(NoSuchElementException::new);
    }

    @Override
    public StockDto getStock(long id) {
        return stockRepository.findByStockId(id)
                .map(stockMapper::mapToDto)
                .orElseThrow(NoSuchElementException::new);
    }
}
